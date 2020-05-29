package web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import main.domian.Gps;
import main.service.GpsService;
import main.service.impl.GpsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/userGroups")
public class UserGroups extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        GpsService gpsService = new GpsServiceImpl();
        ObjectMapper objectMapper = new ObjectMapper();
        List<Gps> allGps = gpsService.findGroupsByEmail(email);
        String jsonString = objectMapper.writeValueAsString(allGps);
        PrintWriter out = response.getWriter();
        out.write(jsonString);
        out.flush();
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
