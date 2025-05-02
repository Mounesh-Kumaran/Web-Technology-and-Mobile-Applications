import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetPostServlet")
public class GetPostServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("username");

        out.println("<html><body>");
        out.println("<h2>GET Method Received</h2>");
        out.println("<p>Hello, <b>" + name + "</b>! Data sent using GET.</p>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("username");

        out.println("<html><body>");
        out.println("<h2>POST Method Received</h2>");
        out.println("<p>Hello, <b>" + name + "</b>! Data sent using POST.</p>");
        out.println("</body></html>");
    }
}
