package fit.se.bai1;

import fit.se.bai1.entities.Person;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class MainApp extends HttpServlet {
    private ApplicationContext context;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init();
        context = new ClassPathXmlApplicationContext("beans.xml");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Person person  = context.getBean(Person.class);
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().println("<h1>Person Object Loaded Successfully!</h1>");
        resp.getWriter().println("<p>Name: " + person.getName() + "</p>");
        resp.getWriter().println("<p>Addresses: " + person.getAddresses() + "</p>");
        resp.getWriter().println("<p>Emails: " + person.getEmails() + "</p>");
    }
}
