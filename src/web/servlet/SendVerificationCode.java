package web.servlet;

import main.service.UserService;
import main.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sendVerificationCode")
public class SendVerificationCode extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        String email = request.getParameter("email");
        int i = userService.checkEmail(email);
        response.getWriter().write(i+"");
        String verificationCode = request.getParameter("verificationCode");
        userService.sendVerificationCode(email, verificationCode);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
