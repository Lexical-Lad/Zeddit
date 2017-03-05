/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Samuel
 */
public class Delete_A extends HttpServlet {

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
        
         String username=((String)request.getParameter("username")).toLowerCase().trim();
         File f=new File("C:\\Users\\Samuel\\Documents\\NetBeansProjects\\Zeddit\\Users\\"+username+".user");
        File ff=new File("C:\\Users\\Samuel\\Documents\\NetBeansProjects\\Zeddit\\Moderators\\"+username+".mod");
       
        
        if(!(f.isFile()||ff.isFile()))
        {
            RequestDispatcher r=request.getRequestDispatcher("Admin_Panel");
            r.include(request, response);
            
            p.println("<center><font color='red'>Sorry, No such user exists! Try again</font></center>");
            
        }
        
        if(f.isFile())
        {
            f.delete();
            
            p.println("<html>\n" +
"<body>\n" +
"<br><br><br>\n" +
"<center>The pertinent account is Deleted Successfully</center>\n" +
"<form action=\"Admin_Panel\" method=\"post\">\n" +
"\n" +
"<br>\n" +
"<br>\n" +
"<center><input type=\"submit\" value=\"Back\"></center></form>\n" +
"</body>\n" +
"</html>");
    }
        else if(ff.isFile())
        {
            ff.delete();
            
            p.println("<html>\n" +
"<body>\n" +
"<br><br><br>\n" +
"<center>The pertinent account is Deleted Successfully</center>\n" +
"<form action=\"Admin_Panel\" method=\"post\">\n" +
"\n" +
"<br>\n" +
"<br>\n" +
"<center><input type=\"submit\" value=\"Back\"></center></form>\n" +
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
