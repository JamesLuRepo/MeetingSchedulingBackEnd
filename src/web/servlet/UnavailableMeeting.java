package web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import main.domian.ScheduleShow;
import main.service.ScheduleShowService;
import main.service.impl.ScheduleShowServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/unavailableMeeting")
public class UnavailableMeeting extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        ScheduleShowService scheduleShowService = new ScheduleShowServiceImpl();
        ObjectMapper objectMapper = new ObjectMapper();
        List<ScheduleShow> allGps = scheduleShowService.getUnavailableMeetingList(email);
        String jsonStringShownInList = objectMapper.writeValueAsString(allGps);

        PrintWriter out = response.getWriter();
        out.write(jsonStringShownInList);
        out.flush();
        out.close();



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
