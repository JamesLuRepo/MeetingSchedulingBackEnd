package web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import main.domian.Meeting;
import main.domian.User;
import main.service.MeetingService;
import main.service.UserService;
import main.service.impl.MeetingServiceImpl;
import main.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/getGroupMembers")
public class GetGroupMembers extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        String gid = request.getParameter("gid");
        List<User> userByGroupId = userService.findUserByGroupId(gid);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(userByGroupId);
        PrintWriter out = response.getWriter();
        out.write(jsonString);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
