package fit.se.bai1;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;


public class LoggingFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("LoggingFilter duoc khoi tao");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String uri = httpRequest.getRequestURI();

        System.out.println("Yeu cau duoc nhan:"+uri);
        System.out.println("Thoi gian:" + System.currentTimeMillis());

        // Chuyển tiếp yêu cầu đến filter tiếp theo hoặc đến Servlet đích.
        chain.doFilter(request, response);

        //Xử lý sau khi Response từ Servlet trở về
        System.out.println("Phan hoi duoc xu ly boi Servlet:" + uri);


    }
    public void destroy() {
        System.out.println("LoggingFilt bi huy");
    }
}
