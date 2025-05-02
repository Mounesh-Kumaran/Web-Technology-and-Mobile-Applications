import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

@WebServlet("/PreferenceServlet")
public class PreferenceServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String theme = request.getParameter("theme");
        String language = request.getParameter("language");

        Cookie themeCookie = new Cookie("theme", theme);
        Cookie languageCookie = new Cookie("language", language);

        themeCookie.setMaxAge(60 * 60 * 24 * 7);
        languageCookie.setMaxAge(60 * 60 * 24 * 7);

        response.addCookie(themeCookie);
        response.addCookie(languageCookie);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String theme = "light";
        String language = "English";

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("theme".equals(cookie.getName())) {
                    theme = cookie.getValue();
                }
                if ("language".equals(cookie.getName())) {
                    language = cookie.getValue();
                }
            }
        }

        JSONObject json = new JSONObject();
        json.put("theme", theme);
        json.put("language", language);

        response.setContentType("application/json");
        response.getWriter().write(json.toString());
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie themeCookie = new Cookie("theme", "");
        Cookie languageCookie = new Cookie("language", "");

        themeCookie.setMaxAge(0);
        languageCookie.setMaxAge(0);

        response.addCookie(themeCookie);
        response.addCookie(languageCookie);
    }
}
