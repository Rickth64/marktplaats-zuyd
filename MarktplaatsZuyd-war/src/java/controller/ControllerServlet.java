/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Account;
import entity.Advertisement;
import entity.Bidding;
import entity.Category;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import session.AccountFacade;
import session.AdvertisementFacade;
import session.CategoryFacade;

/**
 *
 * @author rick
 */
@WebServlet(name = "ControllerServlet",
        loadOnStartup = 1,
        urlPatterns = {"/index", "/categories", "/category", "/advertisement",
            "/login", "/logout", "/register", "/doRegister",
            "/placeAd"})
public class ControllerServlet extends HttpServlet {

    @EJB
    private AdvertisementFacade advertisementFacade;

    @EJB
    private CategoryFacade categoryFacade;

    @EJB
    private AccountFacade accountFacade;

    private List<Advertisement> recentAds;
    private List<Category> allCategories;
    private Advertisement selectedAd;
    private Category selectedCategory;
    private Collection<Advertisement> categoryAds;
    private Collection<Bidding> selectedAdBiddings;
    private Account selectedAdSeller;

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

        String user = request.getRemoteUser();

        request.setAttribute("user", user);

        String userPath = request.getServletPath();

        // if category page is requested
        if (userPath.equals("/index")) {

            int numberOfAds = advertisementFacade.count();

            if (numberOfAds <= 10) {
                recentAds = advertisementFacade.findAll();
                request.setAttribute("recentAdsCount", numberOfAds);
            } else {
                recentAds = advertisementFacade.findRange(new int[]{numberOfAds - 10, numberOfAds});
                request.setAttribute("recentAdsCount", 10);
            }

            request.setAttribute("recentAds", recentAds);

        } else if (userPath.equals("/categories")) {

            allCategories = categoryFacade.findAll();
            request.setAttribute("categories", allCategories);

        } else if (userPath.equals("/category")) {

            String categoryId = request.getQueryString();

            if (categoryId != null) {

                // get selected category
                selectedCategory = categoryFacade.find(Integer.parseInt(categoryId));

                // place selected category in request scope
                request.setAttribute("selectedCategory", selectedCategory);

                // get all advertisements for selected category
                categoryAds = selectedCategory.getAdvertisementCollection();

                // place category advertisement in request scope
                request.setAttribute("categoryAds", categoryAds);
            }

        } else if (userPath.equals("/advertisement")) {

            // get advertisementId from request
            String adId = request.getQueryString();

            if (adId != null) {

                // get selected advertisement
                selectedAd = advertisementFacade.find(Integer.parseInt(adId));

                // place selected advertisement in request scope
                request.setAttribute("selectedAd", selectedAd);

                selectedAdSeller = selectedAd.getAccountIdaccount();

                request.setAttribute("seller", selectedAdSeller);
            }

        } else if (userPath.equals("/logout")) {
            request.logout();
            response.sendRedirect("index");
        } else if (userPath.equals("/doRegister")) {

            //REGISTREREN PROBEERSEL!!!
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            //TODO hash to MD5
            try {
                MessageDigest md5 = MessageDigest.getInstance("MD5");
                byte[] tmp = password.getBytes();
                md5.update(tmp);
                password = byteArrToString(md5.digest());
            } catch (NoSuchAlgorithmException exc) {

            }
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String emailAddress = request.getParameter("email");

            Account newAccount = new Account();
            newAccount.setUsername(username);
            newAccount.setPassword(password);
            newAccount.setFirstName(firstName);
            newAccount.setLastName(lastName);
            newAccount.setEmailAddress(emailAddress);

            try {
                accountFacade.create(newAccount);
            } catch (ConstraintViolationException exc) {
                exc.getConstraintViolations();
            }

            //request.login(username, password);
            userPath = "/index";

            //EINDE PROBEERSEL
        }

        // use RequestDispatcher to forward request internally
        String url = "/WEB-INF/view" + userPath + ".jsp";

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private static String byteArrToString(byte[] b) {
        String res = null;
        StringBuffer sb = new StringBuffer(b.length * 2);
        for (int i = 0; i < b.length; i++) {
            int j = b[i] & 0xff;
            if (j < 16) {
                sb.append('0');
            }
            sb.append(Integer.toHexString(j));
        }
        res = sb.toString();
        return res.toUpperCase();
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
