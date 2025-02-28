/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet; 
import jakarta.servlet.http.HttpServletRequest; 
import jakarta.servlet.http.HttpServletResponse;  
import java.io.*;
import java.sql.*;


/**
 *
 * @author Lenovo
 */
@WebServlet("/register")
public class RegistrationServelet extends HttpServlet {
   @Override
    protected void doPost(HttpServletRequest req,HttpServletResponse res)throws  IOException{
     String username = req.getParameter("username");
     String email = req.getParameter("email");
     String password = req.getParameter("password");
     try(Connection con = dbConnection.getConnections()){
         String sql ="Insert into users (username,email,password) values (?,?,?)";
         PreparedStatement stm = con.prepareStatement(sql);
         stm.setString(1, username);
         stm.setString(2,email);
         stm.setString(3, password);
         stm.executeUpdate();
         con.close();
         res.sendRedirect("login.html");
     }
     catch(SQLException e){
    res.getWriter().println("Registration failed: " + e.getMessage());
}

     
    }
    
    
    
     

}
