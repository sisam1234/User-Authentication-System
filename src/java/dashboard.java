
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.PrintWriter;
@WebServlet("/dashboard")
public class dashboard extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) {
        try {
            res.setContentType("text/html");
            try (PrintWriter pw = res.getWriter()) {

                HttpSession session = req.getSession(false);
                String username = (String) session.getAttribute("username");
                pw.print("Welcome," + username + "!");
                pw.print("<a href='logout'>Logout</a>");
            }
            
        }catch(Exception e){
                System.out.println(e);
            }
    }
}
