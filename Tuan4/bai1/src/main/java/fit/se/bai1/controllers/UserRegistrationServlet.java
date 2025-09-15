package fit.se.bai1.controllers;

import fit.se.bai1.daos.UserDAO;
import fit.se.bai1.daos.impl.UserDAOImpl;
import fit.se.bai1.entities.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.Validator;

import javax.naming.NamingException;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;


@WebServlet(urlPatterns = {"/register", "/listUsers"})
public class UserRegistrationServlet extends HttpServlet {
    private UserDAOImpl userDAO;
    private Validator validator;

    @Override
    public void init () throws ServletException {
        try{
            //userDAO = new UserDAOImpl();
            this.userDAO = new UserDAOImpl();
            try(ValidatorFactory factory = Validation.buildDefaultValidatorFactory()) {
                this.validator = factory.getValidator();
            }
        }catch(NamingException e){
            // Nếu có lỗi JNDI, ném ra ngoại lệ để báo cho Tomcat
            throw new ServletException("Error initializing UserDAOImpl", e);
        }

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User newUser = new User();
        newUser.setFirstName(request.getParameter("firstName"));
        newUser.setLastName(request.getParameter("lastName"));
        newUser.setEmail(request.getParameter("email"));
        newUser.setPassword(request.getParameter("password"));

        try {
            int year = Integer.parseInt(request.getParameter("year"));
            int month = Integer.parseInt(request.getParameter("month"));
            int day = Integer.parseInt(request.getParameter("day"));
            newUser.setBirthday(LocalDate.of(year, month, day));
        } catch (Exception e) {
            // Null or invalid date, Bean Validation will handle it
        }
        newUser.setGender(request.getParameter("gender"));

        Set<ConstraintViolation<User>> violations = validator.validate(newUser);

        if (!violations.isEmpty()) {
            request.setAttribute("errors", violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList()));
            request.setAttribute("user", newUser);
            request.getRequestDispatcher("/views/UserRegistrationForm.jsp").forward(request, response);
            return;
        }

        try {
            userDAO.saveUser(newUser);
            response.sendRedirect(request.getContextPath() + "/listUsers");
        } catch (SQLException e) {
            request.setAttribute("errorMessage", "Database Error: " + e.getMessage());
            request.getRequestDispatcher("/views/UserRegistrationForm.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        if (action.equals("/listUsers")) {
            try {
                request.setAttribute("users", userDAO.getAllUsers());
                request.getRequestDispatcher("/views/UserList.jsp").forward(request, response);
            } catch (SQLException e) {
                request.setAttribute("errorMessage", "Error retrieving user list: " + e.getMessage());
                request.getRequestDispatcher("/views/error.jsp").forward(request, response);
            }
        } else {
            // Forward to the registration form
            request.getRequestDispatcher("/views/UserRegistrationForm.jsp").forward(request, response);
        }
    }


}
