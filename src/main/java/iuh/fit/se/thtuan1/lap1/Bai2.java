package iuh.fit.se.thtuan1.lap1;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
     name = "hongngocServlet", value = "/ngoc"
)
public class Bai2 extends HttpServlet {
    private  String message;

    public void init()
    {
        message ="Hong Ngoc";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>"+message+"</h2>");
        out.println("</body></html>");

    }
    public void destroy()
    {
    }
}
