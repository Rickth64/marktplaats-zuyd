/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Advertisement;
import entity.Category;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.AccountFacade;
import session.AdvertisementFacade;
import session.CategoryFacade;

/**
 *
 * @author rick
 */
@WebServlet(name = "AdvertisementServlet", urlPatterns = {"/index", "/advertisement", "/placeAd", "/doPlaceAd"})
public class AdvertisementServlet extends HttpServlet {

    @EJB
    private AdvertisementFacade advertisementFacade;

    @EJB
    private CategoryFacade categoryFacade;

    @EJB
    private AccountFacade accountFacade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userPath = request.getServletPath();

        if (userPath.equals("/index")) {
            
            List<Advertisement> recentAds;
            
            // get total number of advertisements
            int numberOfAds = advertisementFacade.count();
            
            if (numberOfAds <= 10) {
                
                // select all advertisements if total is less than 10 (maximum number of recent ads on home page)
                recentAds = advertisementFacade.findAll();
            } else {
                
                // select only the last 10 advertisements if total is more than 10 (maximum number of recent ads on home page)
                recentAds = advertisementFacade.findRange(new int[]{numberOfAds - 10, numberOfAds});
            }

            // place recent advertisement in request scope
            request.setAttribute("recentAds", recentAds);
            
        } else if (userPath.equals("/advertisement")) {
            
            // get advertisement id from request
            String adId = request.getQueryString();

            if (adId != null) {
                // get selected advertisement
                Advertisement selectedAd = advertisementFacade.find(Integer.parseInt(adId));

                // place selected advertisement in request scope
                request.setAttribute("selectedAd", selectedAd);
            }
        } else if (userPath.equals("/placeAd")) {
            // get all available categories
            List<Category> allCategories = categoryFacade.findAll();

            // place all available categories in request scope
            request.setAttribute("availableCategories", allCategories);
        } else if (userPath.equals("/doPlaceAd")) {
            // get all field values for new advertisement from the request
            String title = request.getParameter("adTitle");
            Category category = categoryFacade.find(Integer.parseInt(request.getParameter("selectedCategory")));
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            String home = request.getParameter("home");
            String description = request.getParameter("description");
            BigDecimal price = null;
            if (!request.getParameter("price").equals("")) {
                price = BigDecimal.valueOf(Double.parseDouble(request.getParameter("price")));
            }

            // create a new advertisement entity
            Advertisement newAd = new Advertisement();
            newAd.setName(title);
            newAd.setCategoryIdcategory(category);
            newAd.setContactphone(phone);
            newAd.setContactemail(email);
            newAd.setContactaddress(home);
            newAd.setDescription(description);
            newAd.setPrice(price);
            newAd.setAccountIdaccount(accountFacade.getAccountByUsername(request.getRemoteUser()));

            try {
                // create the advertisement through the advertisement facade, this invokes bean validation
                advertisementFacade.create(newAd);
                
                // let it forward to a confirmation page
                userPath = "/placeAdSuccess";
            } catch (javax.validation.ConstraintViolationException ex) {
                ex.getConstraintViolations();
                //TODO handle exception, chances of hitting this catch clause should be reduced by implementing validators on the HTML form in 'placeAd.jsp'
            }
        }

        // use RequestDispatcher to forward request internally
        String url = "/WEB-INF/view" + userPath + ".jsp";

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
