/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Account;
import entity.Usergroup;
import java.io.IOException;
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
import session.UsergroupFacade;

/**
 *
 * @author rick
 */
@WebServlet(name = "UserServlet", urlPatterns = {"/login", "/logout", "/register", "/doRegister"})
public class UserServlet extends HttpServlet {

    @EJB
    private AccountFacade accountFacade;

    @EJB
    private UsergroupFacade usergroupFacade;

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
        
        //request.setAttribute("user", request.getRemoteUser());

        String userPath = request.getServletPath();

        if (userPath.equals("/logout")) {

            // log out the current user
            request.logout();

            // redirect to home page
            response.sendRedirect("index");
        } else if (userPath.equals("/doRegister")) {

            // get all field values for new advertisement from the request
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String emailAddress = request.getParameter("email");

            // hash the password using MD5 for secure database storage
            try {
                MessageDigest md5 = MessageDigest.getInstance("MD5");
                byte[] tmp = password.getBytes();
                md5.update(tmp);
                password = byteArrToString(md5.digest());
            } catch (NoSuchAlgorithmException ex) {

            }

            // create a new account entity
            Account newAccount = new Account();
            newAccount.setUsername(username);
            newAccount.setPassword(password);
            newAccount.setFirstName(firstName);
            newAccount.setLastName(lastName);
            newAccount.setEmailAdress(emailAddress);

            // set the usergroup of the new account to 'USER'
            Collection<Usergroup> newAccountGroup = new ArrayList<Usergroup>();
            List<Usergroup> groups = usergroupFacade.findAll();
            for (Usergroup group : groups) {
                if (group.getName().equals("USER")) {
                    newAccountGroup.add(group);
                    break;
                }
            }
            newAccount.setUsergroupCollection(newAccountGroup);

            try {
                // create the account through the account facade, this invokes bean validation
                accountFacade.create(newAccount);
                userPath = "/registerSuccess";
            } catch (ConstraintViolationException ex) {
                ex.getConstraintViolations();
                //TODO handle exception, chances of hitting this catch clause should be reduced by implementing validators on the HTML form in 'register.jsp'
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
