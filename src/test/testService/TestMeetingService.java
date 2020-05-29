package test.testService;

import com.fasterxml.jackson.databind.ObjectMapper;
import main.domian.Meeting;
import main.domian.ScheduleShow;
import main.service.MeetingService;
import main.service.impl.MeetingServiceImpl;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class TestMeetingService {
    MeetingService meetingService = new MeetingServiceImpl();

    @Test
    public void testAddMeeting() {
        Meeting meeting = new Meeting();
        StringBuilder stringBuilder = new StringBuilder(
                "{\"gpsGid\":4,\"holdTime\":\"2020-4-14 1:21:00\",\"location\":\"egggggg\",\"name\":\"ggggg\",\"notes\":\"dddddd\",\"scheduling_ddl\":\"2020-4-21 4:21:00\",\"timeLength\":56}");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            meeting = objectMapper.readValue(stringBuilder.toString(), Meeting.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Integer count = meetingService.addMeeting(meeting);
        System.out.println(count);
    }

    @Test
    public void testGetMeetingInformation() {

        System.out.println(meetingService.getMeetingInformation(40));

    }

    @Test
    public void testFindScheduleShowByGid() {
        System.out.println(meetingService.findScheduleShowByGid("27"));

    }

    @Test
    public void testModifyMeeting() {
        Integer integer = meetingService.modifyMeeting(new Meeting(41,
                "asdf",
                "asfddfd",
                "2020-08-20 13:54:23",
                100,
                "room100",
                "2020-08-20 13:54:23",
                4));
        System.out.println(integer);
    }
}
