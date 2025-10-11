package fit.se.bai1.controller;

import fit.se.bai1.model.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/registration-form")
public class RegistrationServlet extends HttpServlet {
    private  static  final long serialVersionUID = 1L;
    public RegistrationServlet() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws SecurityException, IOException, ServletException {
        response.getWriter().append("Served at: ").append(request.getContextPath());

        Student student = new Student();
        student.setFirstName(request.getParameter("firstName"));
        student.setLastName(request.getParameter("lastName"));
        student.setDob(request.getParameter("dob"));
        student.setEmail(request.getParameter("email"));
        student.setMobileNumber(request.getParameter("mobileNumber"));
        student.setGender(request.getParameter("gender"));
        student.setAddress(request.getParameter("address"));
        student.setCity(request.getParameter("city"));
        student.setState(request.getParameter("state"));
        student.setCountry(request.getParameter("country"));
        student.setQualification(request.getParameter("qualification"));
        student.setCourse(request.getParameter("course"));

        request.setAttribute("student", student);
        RequestDispatcher rd = request.getRequestDispatcher("result-form.jsp");
        rd.forward(request, response);

    }
}
