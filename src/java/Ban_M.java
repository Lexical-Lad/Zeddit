/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
public class Ban_M extends HttpServlet {

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
         
         if(!f.isFile())
         {
             RequestDispatcher r=request.getRequestDispatcher("Mod_Panel");
            r.include(request, response);
            
            p.println("<center><font color='red'>Sorry, No such user exists! Try again</font></center>");
         }
         
         
          if(f.isFile())
        {
            BufferedReader xx=new BufferedReader(new FileReader(f.getAbsoluteFile()));
            
            
            
            String t=xx.readLine(); 
            
            t=xx.readLine();
            t=xx.readLine();
            xx.close();
            
            
            if(t.equals("~"))
            {
                xx=new BufferedReader(new FileReader(f.getAbsoluteFile()));
               File temp=new File("C:\\Users\\Samuel\\Documents\\NetBeansProjects\\Zeddit\\Users\\temporary.user");
               FileWriter fw=new FileWriter(temp);
               
               while(xx.ready())
               {
                   fw.write(xx.readLine().replaceAll("~","*")+System.lineSeparator());
               }
               fw.close();
               xx.close();
               f.delete();
               temp.renameTo(f);
            
             
                p.println("<html>\n" +
"<body>\n" +
"<br><br><br>\n" +
"<center>The User is Banned</center>\n" +
"<form action=\"Mod_Panel\" method=\"post\">\n" +
"\n" +
"<br>\n" +
"<br>\n" +
"<center><input type=\"submit\" value=\"Back\"></center></form>\n" +
"</body>\n" +
"</html>");
            }
            else
            {
                 p.println("<html>\n" +
"<body>\n" +
"<br><br><br>\n" +
"<center>The User is Already Banned</center>\n" +
"<form action=\"Mod_Panel\" method=\"post\">\n" +
"\n" +
"<br>\n" +
"<br>\n" +
"<center><input type=\"submit\" value=\"Back\"></center></form>\n" +
"</body>\n" +
"</html>");
            }
            
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
