package main.service.impl;

import main.dao.MeetingDao;
import main.dao.ScheduleDao;
import main.dao.UserDao;
import main.dao.impl.MeetingDaoImpl;
import main.dao.impl.ScheduleDaoImpl;
import main.dao.impl.UserDaoImpl;
import main.domian.Meeting;
import main.domian.Schedule;
import main.domian.ScheduleShow;
import main.domian.User;
import main.service.MeetingService;

import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

import static main.utils.TimeCalculator.showTime;

public class MeetingServiceImpl implements MeetingService {

    MeetingDao meetingDao = new MeetingDaoImpl();
    ScheduleDao scheduleDao = new ScheduleDaoImpl();
    UserDao userDao = new UserDaoImpl();


    /**
     * When add a meeting, add into the meeting table and schedule table
     * @param meeting
     * @return
     */
    @Override
    public Integer addMeeting(Meeting meeting) {

        List<User> userList = userDao.findUserByGroupId(meeting.getGpsGid());
        int count1 = meetingDao.add(meeting);
        Meeting completedMeeting = meetingDao.findAddedRowJustNow();
        for (User user : userList) {
            int count2 = scheduleDao.add(new Schedule(user.getEmail(),completedMeeting.getMid()));
            if (count2 != 1) {
                return 0;
            }
        }
        return count1 == 1 ? 1 : 0;
    }

    @Override
    public Meeting getMeetingInformation(int mid) {
        return meetingDao.findMeeting(mid);
    }

    @Override
    public List<ScheduleShow> findScheduleShowByGid(String gid) {
        List<Meeting> meetingsByGroup = meetingDao.findMeetingsByGroup(Integer.parseInt(gid));
        List<ScheduleShow> scheduleShowList = new LinkedList<>();
        for (Meeting meeting : meetingsByGroup) {


                scheduleShowList.add(new ScheduleShow(meeting.getMid(), meeting.getName(),
                        showTime(meeting.getHoldTime(),0) + " to "
                                + showTime(meeting.getHoldTime(),meeting.getTimeLength())));


        }
        return scheduleShowList;
    }

    @Override
    public Integer modifyMeeting(Meeting meeting) {
        Meeting oldMeeting = meetingDao.findMeeting(meeting.getMid());
        int count = meetingDao.update(oldMeeting, meeting);
        return count;
    }

}
