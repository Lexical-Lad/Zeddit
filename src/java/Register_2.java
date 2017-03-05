/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Samuel
 */
public class Register_2 extends HttpServlet {

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
        
        String username=request.getParameter("username"),
        password=request.getParameter("password"),
        fname=request.getParameter("fname"),
        lname=request.getParameter("lname"),
        email=request.getParameter("email"),
        country=request.getParameter("country"),
        dob=request.getParameter("dd")+request.getParameter("mm")+request.getParameter("yyyy");
        
        
        List l=new LinkedList();
        
        boolean arr[]=new boolean[7];
        
        if(username.length()==0)
        {
            l.add("Username");
            arr[0]=true;
        }
        
        if(password.length()==0)
        {
            l.add("Password");
            arr[1]=true;
        }
        if(fname.length()==0)
        {
            l.add("First Name");
            arr[2]=true;
        }
        if(lname.length()==0)
        {
            l.add("Last Name");
            arr[3]=true;
        }
        if(email.length()==0)
        {
            l.add("Email");
            arr[4]=true;
        }
                
        if(country.length()==0)
        {
            l.add("Country");
            arr[5]=true;
        }
        
        if(dob.length()<8)
        {
            l.add("Date of Birth");
            arr[6]=true;
        }
        
        if(!l.isEmpty())
        {
            p.println("Some fields(marked) were left incomplete/empty. Please fill them!");
            
            String s="<html>\n" +
"    <head>\n" +
"        <title>Registration</title>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"    </head>\n" +
"\n" +
"<body>\n" +
"<form action=\"Register_2\" method=\"post\">\n";
            
           if(arr[0])
               s=s+"<center><font color='red'>**</font> Pick a Username<input type=\"text\" name=\"username\"></center><br>\n";
           else
               s=s+"<center> Pick a Username<input type=\"text\" name=\"username\" value=\""+username+"\"></center><br>\n";
            
           if(arr[1])
               s=s+"<center><font color='red'>**</font> Set a Password<input type=\"password\" name=\"password\"></center><br>\n";
           else
               s=s+"<center> Set a Password<input type=\"password\" name=\"password\" value=\""+password+"\"></center><br>\n";
           
           if(arr[2])
               s=s+"<center><font color='red'>**</font> First Name<input type=\"text\" name=\"fname\"></center><br>\n";
           else
               s=s+"<center> First Name<input type=\"text\" name=\"fname\" value=\""+fname+"\"></center><br>\n";
                       
           if(arr[3])
               s=s+"<center><font color='red'>**</font> Last Name<input type=\"text\" name=\"lname\"></center><br>\n";
           else
               s=s+"<center> Last Name<input type=\"text\" name=\"lname\" value=\""+lname+"\"></center><br>\n";
           
           if(arr[4])
               s=s+"<center><font color='red'>**</font> Email <input type=\"text\" name=\"email\"></center><br>\n";
           else
               s=s+"<center> Email <input type=\"text\" name=\"email\" value=\""+email+"\"></center><br>\n";
           
           if(arr[5])
               s=s+"<center><font color='red'>**</font> Country <input type=\"text\" name=\"country\"></center><br>\n";
           else
               s=s+"<center> Country <input type=\"text\" name=\"country\" value=\""+country+"\"></center><br>\n";
               
           if(arr[6])
               s=s+"<center><font color='red'>**</font> Date of Birth <input type=\"text\" name=\"dd\" size=\"2\">/<input type=\"text\" name=\"mm\" size=\"2\">/<input type=\"text\" name=\"yyyy\" size=\"4\"></center><br>\n";
           else
               s=s+"<center> Date of Birth <input type=\"text\" name=\"dd\" size=\"2\">/<input type=\"text\" name=\"mm\" size=\"2\">/<input type=\"text\" name=\"yyyy\" size=\"4\"></center><br>\n";
           
           s=s+"<center>&nbsp<input type=\"submit\" value=\"Register\" name=\"register_2\"></center><br></form>\n" +
"<br><br>\n" +
"<center><a href=\"index.html\">Home</a></center>\n" +
"</body>\n" +
"</html>";
           
           p.println(s);
        }
        else
        {
            
            File f=new File("C:\\Users\\Samuel\\Documents\\NetBeansProjects\\Zeddit\\Users\\"+username+".user");
            
            File ff=new File("C:\\Users\\Samuel\\Documents\\NetBeansProjects\\Zeddit\\Moderators\\"+username+".mod");
            
            if(f.isFile() || ff.isFile())
            {
            
            String s="<html>\n" +
"    <head>\n" +
"        <title>Registration</title>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"    </head>\n" +
"\n" +
"<body>center>Username already taken. Please Pick another!!!</center>\n" +
"<form action=\"Register_2\" method=\"post\">\n";
            
            
            
            s=s+"<center> Pick a Username<input type=\"text\" name=\"username\"></center><br>\n";
                           s=s+"<center> Set a Password<input type=\"password\" name=\"password\" value=\""+password+"\"></center><br>\n";
               s=s+"<center> First Name<input type=\"text\" name=\"fname\" value=\""+fname+"\"></center><br>\n";
               s=s+"<center> Last Name<input type=\"text\" name=\"lname\" value=\""+lname+"\"></center><br>\n";
               s=s+"<center> Email <input type=\"text\" name=\"email\" value=\""+email+"\"></center><br>\n";
               s=s+"<center> Country <input type=\"text\" name=\"country\" value=\""+country+"\"></center><br>\n";
               s=s+"<center> Date of Birth <input type=\"text\" name=\"dd\" size=\"2\">/<input type=\"text\" name=\"mm\" size=\"2\">/<input type=\"text\" name=\"yyyy\" size=\"4\"></center><br>\n";
               s=s+"<center>&nbsp<input type=\"submit\" value=\"Register\" name=\"register_2\"></center><br></form>\n" +
                "<br><br>\n" +
                "<center><a href=\"index.html\">Home</a></center>\n" +
                "</body>\n" +
                "</html>";
               
            }
            else
            {
                File file=new File("C:\\Users\\Samuel\\Documents\\NetBeansProjects\\Zeddit\\Users\\"+username+".user");
                
                file.createNewFile();
                
                BufferedWriter xx=new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
                
                xx.write(username);
                xx.write(System.lineSeparator());
                xx.write(password);
                xx.write(System.lineSeparator());
                xx.write("~");
                xx.write(System.lineSeparator());
                xx.write(fname);
                xx.write(System.lineSeparator());
                xx.write(lname);
                xx.write(System.lineSeparator());
                xx.write(email);
                xx.write(System.lineSeparator());
                xx.write(country);
                xx.write(System.lineSeparator());
                xx.write(dob);
                
                xx.close();
                
                
                p.println("<html>\n" +
"    <head>\n" +
"        <title>Account Created!</title>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"    </head>\n" +
"    <body>\n" +
"	<center>Account Creation Successful!\n" +
"		You may now login normally</center>\n" +
"<br><br>\n" +
"<form action=\"index.html\" method=\"post\">\n" +
"<center><input type=\"submit\" value=\"Back to Homepage\" name=\"blah\"</center></form>\n" +
"\n" +
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
