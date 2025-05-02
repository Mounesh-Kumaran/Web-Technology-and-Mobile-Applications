import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    if (username.equals("admin") && password.equals("password")) {
      HttpSession session = request.getSession();
      session.setAttribute("user", username);
      response.sendRedirect("DashboardServlet");
    } else {
      out.println("<h3>Invalid Credentials! Try Again.</h3>");
      request.getRequestDispatcher("index.html").include(request, response);
    }
  }
}
