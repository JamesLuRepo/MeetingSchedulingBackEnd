package web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import main.domian.ScheduleShow;
import main.service.MeetingService;
import main.service.impl.MeetingServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/getMeetings")
public class GetMeetings extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MeetingService meetingService = new MeetingServiceImpl();
        String gid = request.getParameter("gid");
        List<ScheduleShow> meetingsByGid = meetingService.findScheduleShowByGid(gid);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(meetingsByGid);
        PrintWriter out = response.getWriter();
        out.write(jsonString);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
