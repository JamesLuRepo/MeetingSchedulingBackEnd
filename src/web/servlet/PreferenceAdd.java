package web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import main.domian.Meeting;
import main.domian.Preference;
import main.service.MeetingService;
import main.service.PreferenceService;
import main.service.impl.MeetingServiceImpl;
import main.service.impl.PreferenceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

@WebServlet("/preferenceAdd")
public class PreferenceAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(request.getInputStream(), "utf-8"));
        String line = null;
        StringBuilder str = new StringBuilder();
        while ((line = bufferedReader.readLine()) != null) {
            str.append(line);
        }
        PreferenceService preferenceService = new PreferenceServiceImpl();
        ObjectMapper objectMapper = new ObjectMapper();
        Preference preference = objectMapper.readValue(str.toString(), Preference.class);
        Integer count = preferenceService.addPreference(preference);
        PrintWriter out = response.getWriter();
        out.write(count);
        out.flush();
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
