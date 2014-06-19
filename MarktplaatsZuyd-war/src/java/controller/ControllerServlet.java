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
import entity.Usergroup;
import java.io.IOException;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
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
import session.BiddingFacade;
import session.CategoryFacade;
import session.UsergroupFacade;

/**
 *
 * @author rick
 */
@WebServlet(name = "ControllerServlet",
        loadOnStartup = 1,
        urlPatterns = {"/index", "/categories", "/category", "/advertisement",
            "/login", "/logout",
            "/register", "/doRegister", "/registerSuccess",
            "/placeAd", "/doPlaceAd", "/placeAdSuccess",
            "/placeBidding", "/doPlaceBidding"})
public class ControllerServlet extends HttpServlet {

    @EJB
    private AdvertisementFacade advertisementFacade;

    @EJB
    private CategoryFacade categoryFacade;

    @EJB
    private AccountFacade accountFacade;
    
    @EJB
    private BiddingFacade biddingFacade;
    
    @EJB
    private UsergroupFacade userGroupFacade;

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
            newAccount.setEmailAdress(emailAddress);
            
            Collection<Usergroup> newAccountGroup = new ArrayList<Usergroup>();
            
            List<Usergroup> groups = userGroupFacade.findAll();
            
            for (Usergroup group : groups)
            {
                if (group.getName().equals("USER"))
                {
                    newAccountGroup.add(group);
                    break;
                }
            }
            
            newAccount.setUsergroupCollection(newAccountGroup);

            try {
                accountFacade.create(newAccount);
            } catch (ConstraintViolationException exc) {
                exc.getConstraintViolations();
            }

            //request.login(username, password);
            userPath = "/registerSuccess";

            //EINDE PROBEERSEL
        } else if (userPath.equals("/placeAd")) {
            allCategories = categoryFacade.findAll();
            request.setAttribute("categories", allCategories);
        } else if (userPath.equals("/doPlaceAd")) {

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

            Advertisement newAd = new Advertisement();
            newAd.setName(title);
            newAd.setCategoryIdcategory(category);
            newAd.setContactphone(phone);
            newAd.setContactemail(email);
            newAd.setContactaddress(home);
            newAd.setDescription(description);
            newAd.setPrice(price);

            newAd.setAccountIdaccount(accountFacade.getAccountByUsername(user));

            advertisementFacade.create(newAd);
            
            userPath = "/placeAdSuccess";
        } else if (userPath.equals("/placeBidding")) {
            // get advertisementId from request
            String adId = request.getQueryString();

            if (adId != null) {
                // get selected advertisement
                selectedAd = advertisementFacade.find(Integer.parseInt(adId));

                // place selected advertisement in request scope
                request.setAttribute("selectedAd", selectedAd);
            }
        } else if (userPath.equals("/doPlaceBidding")) {
            
            String adId = request.getParameter("selectedAdId");
            
            Advertisement ad = advertisementFacade.find(Integer.parseInt(adId));
            
            Bidding bidding = new Bidding();
            bidding.setAccountIdaccount(accountFacade.getAccountByUsername(user));
            bidding.setAdvertisementIdadvertisement(ad);
            bidding.setAmount(BigDecimal.valueOf(Double.parseDouble(request.getParameter("amount"))));
            
            biddingFacade.create(bidding);
            
            request.getRequestDispatcher("/advertisement?" + adId).forward(request, response);
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
