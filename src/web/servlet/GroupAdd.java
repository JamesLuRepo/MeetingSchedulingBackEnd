package web.servlet;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import main.domian.Gps;
import main.domian.User;
import main.service.GpsService;
import main.service.impl.GpsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/groupAdd")
public class GroupAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GpsService gpsService = new GpsServiceImpl();
        String groupName = request.getParameter("groupName");
        String description = request.getParameter("description");
        String[] userEmailArray = request.getParameter("emailString").split("~~");
        List<String> userList = Arrays.asList(userEmailArray);
        List<User> users = new ArrayList<>();
        for (String s : userList) {
            users.add(new User(s,null,null));
        }
//        String userListJSON = request.getParameter("userList");
//        ObjectMapper objectMapper = new ObjectMapper();
//        List<User> users = objectMapper.readValue(userListJSON, new TypeReference<List<User>>() {
//        });
        System.out.println(users);
        Integer count = gpsService.addGps(users, new Gps(null, groupName, description));
        //if count ==1 successful, if count ==0 fail
        PrintWriter out = response.getWriter();
        out.write(count+"");
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
