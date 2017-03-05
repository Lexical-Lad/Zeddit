
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Samuel
 */
public class Login_1 extends HttpServlet {

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
        PrintWriter p=response.getWriter();
        
        
        if(request.getParameter("admin_login")!=null)
        {
            p.println("<html>\n" +
"    <head>\n" +
"        <title>Admin Login</title>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"    </head>\n" +
"\n" +
"<body>\n" +
"<form action=\"Admin_Gateway\" method=\"post\">\n" +
"<center> Username <input type=\"text\" name=\"username\"></center><br>\n" +
"<center> Password <input type=\"password\" name=\"password\"></center><br>\n" +
"\n" +
"<center>&nbsp<input type=\"submit\" value=\"Login\" name=\"login\"></center><br></form>\n" +
"<br><br>\n" +
"<center><a href=\"index.html\">Home</a></center>\n" +
"</body>\n" +
"</html>");
        }
            else if(request.getParameter("user_mod_login")!=null)
                    {
                     p.println("<html>\n" +
"    <head>\n" +
"        <title>User/ Moderator Login</title>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"    </head>\n" +
"\n" +
"<body>\n" +
"<form action=\"User_Gateway\" method=\"post\">\n" +
"<center> Username <input type=\"text\" name=\"username\"></center><br>\n" +
"<center> Password <input type=\"password\" name=\"password\"></center><br>\n" +
"\n" +
"<center>&nbsp<input type=\"submit\" value=\"Login\" name=\"login\"></center><br></form>\n" +
"<br><br>\n" +
"<center><a href=\"index.html\">Home</a></center>\n" +
"</body>\n" +
"</html>");
                    }
        
            else if(request.getParameter("register")!=null)
            {
                p.println("<html>\n" +
"    <head>\n" +
"        <title>Registration</title>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"    </head>\n" +
"\n" +
"<body>\n" +
"<form action=\"Register_2\" method=\"post\">\n" +
"<center> Pick a Username<input type=\"text\" name=\"username\"></center><br>\n" +
"<center> Set a Password<input type=\"password\" name=\"password\"></center><br>\n" +
"<center> First Name<input type=\"text\" name=\"fname\"></center><br>\n" +
"<center> Last Name<input type=\"text\" name=\"lname\"></center><br>\n" +
"<center> Email <input type=\"text\" name=\"email\"></center><br>\n" +
"<center> Country <input type=\"text\" name=\"country\"></center><br>\n" +
"<center> Date of Birth <input type=\"text\" name=\"dd\" size=\"2\">/<input type=\"text\" name=\"mm\" size=\"2\">/<input type=\"text\" name=\"yyyy\" size=\"4\"></center><br>\n" +
"<center>&nbsp<input type=\"submit\" value=\"Register\" name=\"register_2\"></center><br></form>\n" +
"<br><br>\n" +
"<center><a href=\"index.html\">Home</a></center>\n" +
"</body>\n" +
"</html>");
            }
                    
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
