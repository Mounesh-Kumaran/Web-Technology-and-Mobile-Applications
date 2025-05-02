import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    HttpSession session = request.getSession(false);

    if (session != null && session.getAttribute("user") != null) {
      String username = (String) session.getAttribute("user");
      out.println("<h2>Welcome, " + username + "!</h2>");
      out.println("<a href='LogoutServlet'>Logout</a>");
    } else {
      out.println("<h3>Session expired! Please login again.</h3>");
      request.getRequestDispatcher("index.html").include(request, response);
    }
  }
}
