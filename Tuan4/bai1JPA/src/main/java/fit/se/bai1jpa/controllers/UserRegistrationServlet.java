package fit.se.bai1jpa.controllers;

import fit.se.bai1jpa.entities.User;
import fit.se.bai1jpa.repositories.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = {"/register", "/listUsers"})
public class UserRegistrationServlet extends HttpServlet {
    private UserRepository userRepository;
    private Validator validator;

    @Override
    public void init() throws ServletException {
        userRepository = new UserRepository();
        try (ValidatorFactory factory = Validation.buildDefaultValidatorFactory()) {
            this.validator = factory.getValidator();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User newUser = new User();
        // Lấy dữ liệu từ form và gán vào newUser
        newUser.setFirstName(request.getParameter("firstName"));
        newUser.setLastName(request.getParameter("lastName"));
        newUser.setEmail(request.getParameter("email"));
        newUser.setPassword(request.getParameter("password"));
        newUser.setBirthday(LocalDate.parse(request.getParameter("birthday")));
        newUser.setGender(request.getParameter("gender"));

        Set<ConstraintViolation<User>> violations = validator.validate(newUser);
        if (!violations.isEmpty()) {
            request.setAttribute("errors", violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList()));
            request.setAttribute("user", newUser);
            request.getRequestDispatcher("/views/UserRegistrationForm.jsp").forward(request, response);
            return;
        }

        try {
            userRepository.save(newUser);
            response.sendRedirect(request.getContextPath() + "/listUsers");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error_message", "Đã xảy ra lỗi khi lưu dữ liệu: " + e.getMessage());
            request.getRequestDispatcher("/views/UserRegistrationForm.jsp").forward(request, response);
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        if (action.equals("/listUsers")) {
            List<User> users = userRepository.findAll();
            request.setAttribute("users", users);
            request.getRequestDispatcher("/views/UserList.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/views/UserRegistrationForm.jsp").forward(request, response);
        }
    }
}
