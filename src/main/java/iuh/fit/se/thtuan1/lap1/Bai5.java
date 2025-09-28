package iuh.fit.se.thtuan1.lap1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "bai5", value = "/bai5")
public class Bai5 extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/formdk.html").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            // Lấy toàn bộ dữ liệu từ form
            String name = req.getParameter("name");
            String username = req.getParameter("username");
            String email = req.getParameter("email");
            String password = req.getParameter("password"); // Không hiển thị
            String facebook = req.getParameter("facebook");
            String shortBio = req.getParameter("shortBio");

            // Bắt đầu in nội dung HTML
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head><title>Kết Quả Đăng Ký</title></head>");
            out.println("<body>");
            out.println("<h2>Kết Quả Đăng Ký</h2>");

            // Hiển thị thông tin đã nhận, trừ mật khẩu
            out.println("<p><b>Họ và tên:</b> " + (name != null && !name.isEmpty() ? name : "Không có") + "</p>");
            out.println("<p><b>Tên đăng nhập:</b> " + (username != null && !username.isEmpty() ? username : "Không có") + "</p>");
            out.println("<p><b>Email:</b> " + (email != null && !email.isEmpty() ? email : "Không có") + "</p>");
            out.println("<p><b>Mật khẩu:</b> [Đã được ẩn]</p>");
            out.println("<p><b>Facebook:</b> " + (facebook != null && !facebook.isEmpty() ? facebook : "Không có") + "</p>");
            out.println("<p><b>Giới thiệu ngắn:</b> " + (shortBio != null && !shortBio.isEmpty() ? shortBio : "Không có") + "</p>");

            out.println("</body></html>");
        }
    }
}
