/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Samuel
 */
public class Mod_Panel extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        
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
        
        
        ServletContext sc=getServletContext();
        String mod=(String)sc.getAttribute("current");
        
        String s="<html>\n" +
"    <head>\n" +
"        <title>Moderator Control Panel</title>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"    </head>\n" +
"    <body><center> Welcome " +mod+
                "</center><br><br><br>\n" +
"<center> What would you like to do?</center>\n" +
"<br><br>\n" +
"<form action=\"Search_M\" method=\"post\">\n" +
"<center><input type=\"text\" name=\"username\">&nbsp;<input type=\"submit\" value=\"Search\" name=\"searchbutton\"></form></center>\n" +
"<br><br>\n" +
"<form action=\"Ban_M\" method=\"post\">\n" +
"<center><input type=\"text\" name=\"username\">&nbsp;<input type=\"submit\" value=\"Ban\" name=\"banbutton\"></form></center>\n" +
"<br><br>\n" +
"<form action=\"Unban_M\" method=\"post\">\n" +
"<center><input type=\"text\" name=\"username\">&nbsp;<input type=\"submit\" value=\"Unban\" name=\"unbanbutton\"></form></center>\n" +
"<br><br>\n" +
"<br><br><br>\n" +
"<form action=\"Logout\" method=\"post\">\n" +
"<center><input type=\"submit\" value=\"Logout\" name=\"logoutbutton\"></form><center>\n" +
"</body>\n" +
"</html>";
        
        PrintWriter p=response.getWriter();
        p.println(s);
        
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
