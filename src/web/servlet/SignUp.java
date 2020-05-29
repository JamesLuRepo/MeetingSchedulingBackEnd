package web.servlet;

import main.service.UserService;
import main.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/signUp")
public class SignUp extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        Map<String, String[]> parameterMap = request.getParameterMap();
        userService.addUser(parameterMap.get("email")[0], parameterMap.get("name")[0], parameterMap.get("password")[0]);
        response.getWriter().write("reached");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
