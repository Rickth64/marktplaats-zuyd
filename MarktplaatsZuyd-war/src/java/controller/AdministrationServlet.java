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
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.AccountFacade;
import session.AdvertisementFacade;
import session.BiddingFacade;
import session.CategoryFacade;

/**
 *
 * @author rick
 */
@WebServlet(name = "AdministrationServlet", urlPatterns = {"/changeAd", "/doChangeAd", "/changeBidding", "/doChangeBidding", "/changeAccount", "/doChangeAccount"})
public class AdministrationServlet extends HttpServlet {

    @EJB
    private AdvertisementFacade advertisementFacade;

    @EJB
    private CategoryFacade categoryFacade;

    @EJB
    private BiddingFacade biddingFacade;

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

        if (userPath.equals("/changeAd")) {

            String adId = request.getQueryString();

            if (adId != null) {
                // get selected advertisement
                Advertisement selectedAd = advertisementFacade.find(Integer.parseInt(adId));

                if (!selectedAd.getAccountIdaccount().getUsername().equals(request.getRemoteUser()) && !request.isUserInRole("admin")) {
                    //TODO replace by redirecting to error page?
                    response.sendRedirect("index");
                    return;
                }

                // place selected advertisement in request scope
                request.setAttribute("adToChange", selectedAd);

                // get all available categories
                List<Category> allCategories = categoryFacade.findAll();

                // place all available categories in request scope
                request.setAttribute("availableCategories", allCategories);
            }
        } else if (userPath.equals("/doChangeAd")) {

            Advertisement adv = advertisementFacade.find(Integer.parseInt(request.getParameter("adId")));

            if (!adv.getAccountIdaccount().getUsername().equals(request.getRemoteUser()) && !request.isUserInRole("admin")) {
                //TODO replace by redirecting to error page?
                response.sendRedirect("index");
                return;
            }

            String action = request.getParameter("action");

            if (action.equals("update")) {

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

                // update fields
                adv.setName(title);
                adv.setCategoryIdcategory(category);
                adv.setContactphone(phone);
                adv.setContactemail(email);
                adv.setContactaddress(home);
                adv.setDescription(description);
                adv.setPrice(price);

                advertisementFacade.edit(adv);

                //TODO forward to success page?
                response.sendRedirect("index");

            } else if (action.equals("delete")) {

                advertisementFacade.remove(adv);

                //TODO forward to success page?
                response.sendRedirect("index");
            }
        } else if (userPath.equals("/changeBidding")) {

            String biddingId = request.getQueryString();

            if (biddingId != null) {
                // get selected advertisement
                Bidding bidding = biddingFacade.find(Integer.parseInt(biddingId));

                if (!bidding.getAccountIdaccount().getUsername().equals(request.getRemoteUser()) && !request.isUserInRole("admin")) {
                    //TODO replace by redirecting to error page?
                    response.sendRedirect("index");
                    return;
                }

                request.setAttribute("biddingToChange", bidding);
            }

        } else if (userPath.equals("/doChangeBidding")) {

            Bidding bidding = biddingFacade.find(Integer.parseInt(request.getParameter("biddingId")));

            if (!bidding.getAccountIdaccount().getUsername().equals(request.getRemoteUser()) && !request.isUserInRole("admin")) {
                //TODO replace by redirecting to error page?
                response.sendRedirect("index");
                return;
            }

            String action = request.getParameter("action");

            if (action.equals("update")) {

                bidding.setAmount(BigDecimal.valueOf(Double.parseDouble(request.getParameter("amount"))));

                biddingFacade.edit(bidding);

                //TODO forward to success page?
                response.sendRedirect("index");

            } else if (action.equals("delete")) {

                biddingFacade.remove(bidding);

                //TODO forward to success page?
                response.sendRedirect("index");

            }
        } else if (userPath.equals("/changeAccount")) {

            String accUsername = request.getQueryString();

            if (accUsername != null) {

                Account account = accountFacade.getAccountByUsername(accUsername);

                if (!account.getUsername().equals(request.getRemoteUser()) && !request.isUserInRole("admin")) {
                    //TODO replace by redirecting to error page?
                    response.sendRedirect("index");
                    return;
                }

                request.setAttribute("accountToChange", account);

            }

        } else if (userPath.equals("/doChangeAccount")) {
            Account account = accountFacade.find(Integer.parseInt(request.getParameter("accountId")));

            if (!account.getUsername().equals(request.getRemoteUser()) && !request.isUserInRole("admin")) {
                //TODO replace by redirecting to error page?
                response.sendRedirect("index");
                return;
            }

            String action = request.getParameter("action");

            if (action.equals("update")) {

                String password = request.getParameter("password");

                if (!password.equals("")) {
                    
                    // hash the password using MD5 for secure database storage
                    try {
                        MessageDigest md5 = MessageDigest.getInstance("MD5");
                        byte[] tmp = password.getBytes();
                        md5.update(tmp);
                        password = byteArrToString(md5.digest());
                    } catch (NoSuchAlgorithmException ex) {

                    }
                    
                    account.setPassword(password);
                }
                account.setFirstName(request.getParameter("firstName"));
                account.setLastName(request.getParameter("lastName"));
                account.setEmailAdress(request.getParameter("email"));

                accountFacade.edit(account);

                //TODO forward to success page?
                response.sendRedirect("index");

            } else if (action.equals("delete")) {

                List<Bidding> allBiddings = biddingFacade.findAll();

                for (Bidding bidding : allBiddings) {
                    if (bidding.getAccountIdaccount().equals(account)) {
                        biddingFacade.remove(bidding);
                    }
                }

                List<Advertisement> allAds = advertisementFacade.findAll();

                for (Advertisement ad : allAds) {
                    if (ad.getAccountIdaccount().equals(account)) {
                        advertisementFacade.remove(ad);
                    }
                }

                accountFacade.remove(account);

                if (account.getUsername().equals(request.getRemoteUser())) {

                    request.logout();
                }

                //TODO forward to success page?
                response.sendRedirect("index");

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

    private static String byteArrToString(byte[] b) {
        StringBuilder sb = new StringBuilder(b.length * 2);
        for (int i = 0; i < b.length; i++) {
            int j = b[i] & 0xff;
            if (j < 16) {
                sb.append('0');
            }
            sb.append(Integer.toHexString(j));
        }
        String res = sb.toString();
        return res.toUpperCase();
    }

}
