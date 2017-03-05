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
import java.util.LinkedList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Samuel
 */
public class Admin_Gateway extends HttpServlet {

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
        
        String username, password;
        
        username=(String)request.getParameter("username");
        password=(String)request.getParameter("password");
        
        if(username.length()==0 || password.length()==0)
        {
            PrintWriter p=response.getWriter();
            p.println("One or more fields are empty. Try Again!");
            RequestDispatcher rd=request.getRequestDispatcher("index.html");
            rd.include(request,response);
        }
        
        username=username.toLowerCase().trim();
        
        File f=new File("C:\\Users\\Samuel\\Documents\\NetBeansProjects\\Zeddit\\Admins\\"+username+".admin");
        PrintWriter p=response.getWriter();
        
 
        if(f.isFile())
        {   
            
            BufferedReader xx=new BufferedReader(new FileReader("C:\\Users\\Samuel\\Documents\\NetBeansProjects\\Zeddit\\Admins\\"+username+".admin"));
            String a=xx.readLine();
            a=xx.readLine();
            
            if(a.equals(password))
            {
                ServletContext sc=getServletContext();
                
                sc.setAttribute("current",username);
                xx.close();
                
                
                RequestDispatcher r=request.getRequestDispatcher("Admin_Panel");
                r.forward(request, response);
            }
            else
            {
                
                 p.println("Wrong Password! Try Again!");
                 RequestDispatcher r=request.getRequestDispatcher("index.html");
                    r.include(request, response);
            }
        }
        else
        {
            p.println("No Such Admin Username found. Try Again!");
            RequestDispatcher r=request.getRequestDispatcher("index.html");
                    r.include(request, response);
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
