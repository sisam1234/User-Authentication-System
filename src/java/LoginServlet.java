
import jakarta.servlet.ServletException;
import java.sql.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.*;
@WebServlet("/login")
public class LoginServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        try(Connection con = dbConnection.getConnections()){
            String sql = "select * from users where email=? and password = ?";
            PreparedStatement ps  = con.prepareStatement(sql);
            ps.setString(1,email);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                HttpSession session = req.getSession();
                session.setAttribute("username", rs.getString("username"));
                res.sendRedirect("dashboard");
                
            }
            else{
                res.getWriter().println("Invalid credentials");
            }
        }
        catch(SQLException  e ){
            res.getWriter().println("login failed");
        }
    }
    
}