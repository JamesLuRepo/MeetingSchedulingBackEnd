package test.testDao;

import main.dao.MeetingDao;
import main.dao.impl.MeetingDaoImpl;
import main.domian.Meeting;
import org.junit.Test;

import java.util.List;

public class TestMeetingDao {
    MeetingDao meetingDao = new MeetingDaoImpl();

    @Test
    public void testAdd() {
        int count = meetingDao.add(new Meeting(null,
                "asdf",
                "asfddfd",
                "2020-08-20 13:54:23",
                100,
                "room100",
                "2020-08-20 13:54:23",
                4));
        System.out.println(count);

    }

    @Test
    public void testDelete() {
        int count = meetingDao.delete(new Meeting(17,
                "asdf",
                "asfddfd",
                "2020-08-20 13:54:23",
                100,
                "room100",
                "2020-08-20 13:54:23",
                4));
        System.out.println(count);
    }

    @Test
    public void testUpdate() {
        int count = meetingDao.update(new Meeting(18,
                "asdf",
                "asfddfd",
                "2020-08-20 13:54:23",
                100,
                "room100",
                "2020-08-20 13:54:23",
                4), new Meeting(null,
                "asdf",
                "asfddfd",
                "2020-08-20 13:54:23",
                888,
                "room100",
                "2020-08-20 13:54:23",
                4));
        System.out.println(count);
    }

    @Test
    public void testFindAll() {
        List<Meeting> list = meetingDao.findAll();
        for (Meeting meeting : list) {
            System.out.println(meeting);
        }
    }

    @Test
    public void testFindMeetingByGroup() {
        List<Meeting> list = meetingDao.findMeetingsByGroup(3);
        for (Meeting meeting : list) {
            System.out.println(meeting);
        }

    }

    @Test
    public void testFindMeetingsByEmail() {
        List<Meeting> list = meetingDao.findMeetingsByEmail("aaa");
        for (Meeting meeting : list) {
            System.out.println(meeting);
        }
    }

    @Test
    public void testFindMeeting() {
        System.out.println(meetingDao.findMeeting(9));

    }

    @Test
    public void testFindAddedRowJustNow() {
        System.out.println(meetingDao.findAddedRowJustNow());

    }
}
