package fit.se.bai2;


import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private List<Account> accountList;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init();
        //tao danh sach de luu cac tai khoan dk
        accountList = new ArrayList<>();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("yourEmail");
        String password = req.getParameter("newPassword");
        String birthdayMonth = req.getParameter("month");
        String birthdayDay = req.getParameter("day");
        String birthdayYear = req.getParameter("year");
        String gender = req.getParameter("gender");

        // Gộp ngày sinh thành một chuỗi
        String birthday = birthdayMonth + "/" + birthdayDay + "/" + birthdayYear;

        //Tao doi tuong Account va luu vao danh sach
        Account newAccount = new Account(firstName, lastName, email, password, birthday, gender);
        accountList.add(newAccount);

        //chuyen danh sach tk sang View
        req.setAttribute("accounts", accountList);

        // dieu huong den View list.jsp
        req.getRequestDispatcher("list.jsp").forward(req, resp);
    }
}
