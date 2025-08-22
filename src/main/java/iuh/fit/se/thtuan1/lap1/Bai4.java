package iuh.fit.se.thtuan1.lap1;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "init-param",
        urlPatterns = {"/init-param", "/param"},
        initParams = {
                @WebInitParam(name = "name", value = "ngoc01"),
                @WebInitParam(name = "email", value = "ngoc@gmail.com"),
                @WebInitParam(name = "password", value = "123")
        }
)
public class Bai4 extends HttpServlet {

    private String name;
    private String email;
    private String password;
    private String companyName;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        name = config.getInitParameter("name");
        email = config.getInitParameter("email");
        password = config.getInitParameter("password");

        ServletContext context = config.getServletContext();
        companyName = context.getInitParameter("companyName");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h2 style = 'color : red'>" + name + "</h2>");
        out.println("<h2 style='color: blue'>" + email + "</h2>");
        out.println("<h2 style='color: blue'>" + password + "</h2>");
        out.println("<h2 style='color: purple'>Company: " + companyName + "</h2>");
        out.println("</body></html>");

    }
    public void destroy(){}

}
