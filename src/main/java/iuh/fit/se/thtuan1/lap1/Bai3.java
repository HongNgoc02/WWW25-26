package iuh.fit.se.thtuan1.lap1;

import com.fasterxml.jackson.databind.ObjectMapper;
import iuh.fit.se.thtuan1.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "userServlet", value = "/user-json")
public class Bai3  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Thiết lập Content Type là "application/json"
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        //Tạo một đối tượng Java
        User user = new User(1, "Vo Hong Ngoc", "ngoc@gmail.com");

        //Sử dụng ObjectMapper của Jackson để chuyển đối tượng thành chuỗi JSON
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(user);

        //Ghi chuỗi JSON vào response

        try(PrintWriter out = resp.getWriter()){
            out.println(json);
            out.flush();
        }
    }
}
