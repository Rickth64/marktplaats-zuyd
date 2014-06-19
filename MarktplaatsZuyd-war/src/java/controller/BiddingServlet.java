/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Advertisement;
import entity.Bidding;
import java.io.IOException;
import java.math.BigDecimal;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.AccountFacade;
import session.AdvertisementFacade;
import session.BiddingFacade;

/**
 *
 * @author rick
 */
@WebServlet(name = "BiddingServlet", urlPatterns = {"/placeBidding", "/doPlaceBidding"})
public class BiddingServlet extends HttpServlet {

    @EJB
    private AdvertisementFacade advertisementFacade;

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

        request.setAttribute("user", request.getRemoteUser());

        String userPath = request.getServletPath();

        if (userPath.equals("/placeBidding")) {

            // get advertisement id from request
            String adId = request.getQueryString();

            if (adId != null) {

                // get selected advertisement
                Advertisement selectedAd = advertisementFacade.find(Integer.parseInt(adId));

                // place selected advertisement in request scope
                request.setAttribute("selectedAd", selectedAd);
            }
        } else if (userPath.equals("/doPlaceBidding")) {

            // get advertisement id from request
            String adId = request.getParameter("selectedAdId");

            // get advertisement to place bid on
            Advertisement ad = advertisementFacade.find(Integer.parseInt(adId));

            // create a new bidding entity
            Bidding bidding = new Bidding();
            bidding.setAccountIdaccount(accountFacade.getAccountByUsername(request.getRemoteUser()));
            bidding.setAdvertisementIdadvertisement(ad);
            bidding.setAmount(BigDecimal.valueOf(Double.parseDouble(request.getParameter("amount"))));

            try {

                // create the bidding through the bidding facade, this invokes bean validation
                biddingFacade.create(bidding);
            } catch (javax.validation.ConstraintViolationException ex) {
                ex.getConstraintViolations();
                //TODO handle exception, chances of hitting this catch clause should be reduced by implementing validators on the HTML form in 'placeBidding.jsp'
            }

            //request.getRequestDispatcher("/advertisement?" + adId).forward(request, response);
            //response.sendRedirect("/advertisement?" + adId);
            // let it forward to a confirmation page
            userPath = "/placeBiddingSuccess";
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
