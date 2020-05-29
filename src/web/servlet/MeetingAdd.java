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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

@WebServlet("/meetingAdd")
public class MeetingAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(),"utf-8"));
        String line = null;
        StringBuilder str = new StringBuilder();
        while ((line = br.readLine()) != null) {
            str.append(line);
        }
        MeetingService meetingService = new MeetingServiceImpl();
        ObjectMapper objectMapper= new ObjectMapper();
        Meeting meeting = objectMapper.readValue(str.toString(), Meeting.class);
        Integer count = meetingService.addMeeting(meeting);
        PrintWriter out = response.getWriter();
        String s="fail";
        if (count.equals(1)){
            s = "successful";
        }
        out.write(s);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
