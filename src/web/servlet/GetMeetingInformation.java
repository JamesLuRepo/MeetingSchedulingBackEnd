package web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import main.domian.Meeting;
import main.service.MeetingService;
import main.service.impl.MeetingServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/getMeetingInformation")
public class GetMeetingInformation extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int mid = Integer.parseInt(request.getParameter("mid"));
        MeetingService meetingService =new MeetingServiceImpl();
        ObjectMapper objectMapper = new ObjectMapper();
        Meeting meeting = meetingService.getMeetingInformation(mid);
        String jsonString = objectMapper.writeValueAsString(meeting);
        PrintWriter out = response.getWriter();
        out.write(jsonString);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
