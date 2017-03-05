/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
public class Search_A extends HttpServlet {

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
            BufferedReader xx=new BufferedReader(new FileReader(f.getAbsoluteFile()));
            String user=xx.readLine();
            xx.readLine();
            String b;
            if(xx.readLine().equals("~"))
                b="Not Banned";
            else
                b="Banned";
            String fname=xx.readLine();
            String lname=xx.readLine();
            String email=xx.readLine();
            String country=xx.readLine();
            String temp=xx.readLine();
            String dob=temp.substring(0,2)+"/"+temp.substring(2,4)+"/"+temp.substring(4,8);
            
                    
                    
            p.println("<html>\n" +
"    <head>\n" +
"        <title>ZEDDIT - The almost-front page of the Internet</title>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"    </head>\n" +
"    <body>\n" +
"        <br><br><br>\n" +
"\n" +
"<form action=\"Admin_Panel\" method=\"post\">\n" +
"<center>Username<input type=\"text\" value=\""+user+"\" readonly></center>\n" +
"<center>First Name<input type=\"text\" value=\""+fname+"\" readonly></center>\n" +
"<center>Last name<input type=\"text\" value=\""+lname+"\" readonly></center>\n" +
"<center>Email<input type=\"text\" value=\""+email+"\" readonly></center>\n" +
"<center>Country<input type=\"text\" value=\""+country+"\" readonly></center>\n" +
"<center>Date of Birth<input type=\"text\" value=\""+dob+"\" readonly></center>\n" +
"<center>Ban Status<input type=\"text\" value =\""+b+"\" readonly></center>\n" +
"<br>\n" +
"<br>\n" +
"<center><input type=\"submit\" value=\"Back\"></center></form>\n" +
"</body>\n" +
"</html>");
            
            
        }
        if(ff.isFile())
        {
            BufferedReader xx=new BufferedReader(new FileReader(ff.getAbsoluteFile()));
            String user=xx.readLine();
            xx.readLine();
            String b;
            if(xx.readLine().equals("~"))
                b="Not Banned";
            else
                b="Banned";
            String fname=xx.readLine();
            String lname=xx.readLine();
            String email=xx.readLine();
            String country=xx.readLine();
            String temp=xx.readLine();
            String dob=temp.substring(0,2)+"/"+temp.substring(2,4)+"/"+temp.substring(4,8);
            
                    
                    
            p.println("<html>\n" +
"    <head>\n" +
"        <title>ZEDDIT - The almost-front page of the Internet</title>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"    </head>\n" +
"    <body>\n" +
"        <br><br><br>\n" +
"\n" +
"<form action=\"Admin_Panel\" method=\"post\">\n" +
"<center>Username<input type=\"text\" value=\""+user+"\" readonly></center>\n" +
"<center>First Name<input type=\"text\" value=\""+fname+"\" readonly></center>\n" +
"<center>Last name<input type=\"text\" value=\""+lname+"\" readonly></center>\n" +
"<center>Email<input type=\"text\" value=\""+email+"\" readonly></center>\n" +
"<center>Country<input type=\"text\" value=\""+country+"\" readonly></center>\n" +
"<center>Date of Birth<input type=\"text\" value=\""+dob+"\" readonly></center>\n" +
"<center>Ban Status<input type=\"text\" value =\""+b+"\" readonly></center>\n" +
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
