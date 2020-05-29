package main.service.impl;

import main.dao.MeetingDao;
import main.dao.PreferenceDao;
import main.dao.impl.MeetingDaoImpl;
import main.dao.impl.PreferenceDaoImpl;
import main.domian.Meeting;
import main.domian.Preference;
import main.domian.ScheduleShow;
import main.service.ScheduleShowService;

import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

import static main.utils.TimeCalculator.showTime;
import static main.utils.TimeCalculator.getMillisecondsFromTime;


public class ScheduleShowServiceImpl implements ScheduleShowService {
    MeetingDao meetingDao = new MeetingDaoImpl();
    PreferenceDao preferenceDao = new PreferenceDaoImpl();

    @Override
    public List<ScheduleShow> getScheduleList(String email) {
        List<ScheduleShow> scheduleShowList = new LinkedList<>();
        List<Meeting> meetingsByEmail = meetingDao.findMeetingsByEmail(email);


        for (Meeting meeting : meetingsByEmail) {

            scheduleShowList.add(new ScheduleShow(meeting.getMid(), meeting.getName(),
                    showTime(meeting.getHoldTime(), 0) + " to "
                            + showTime(meeting.getHoldTime(), meeting.getTimeLength())));


        }
        return scheduleShowList;
    }

    @Override
    public List<ScheduleShow> getAvailableMeetingList(String email) {
        List<Preference> preferenceList = preferenceDao.findPreferenceByUserEmail(email);
        List<Meeting> meetingList = meetingDao.findMeetingsByEmail(email);
        List<ScheduleShow> scheduleShowList = new LinkedList<>();
        loop:
        for (Meeting meeting : meetingList) {
            for (Preference preference : preferenceList) {
                if (
                        getMillisecondsFromTime(preference.getStartTime()) <= getMillisecondsFromTime(meeting.getHoldTime())
                                && (getMillisecondsFromTime(meeting.getHoldTime()) + meeting.getTimeLength() * 60000) <= getMillisecondsFromTime(preference.getEndTime())
                ) {
                    scheduleShowList.add(new ScheduleShow(meeting.getMid(), meeting.getName(),
                            showTime(meeting.getHoldTime(), 0) + " to "
                                    + showTime(meeting.getHoldTime(), meeting.getTimeLength())));
                    continue loop;
                }
            }
        }
        return scheduleShowList;
    }

    @Override
    public List<ScheduleShow> getUnavailableMeetingList(String email) {
        List<Preference> preferenceList = preferenceDao.findPreferenceByUserEmail(email);
        List<Meeting> meetingList = meetingDao.findMeetingsByEmail(email);
        List<ScheduleShow> scheduleShowList = new LinkedList<>();
        loop:
        for (Meeting meeting : meetingList) {
            for (Preference preference : preferenceList) {
                if (
                        getMillisecondsFromTime(preference.getStartTime()) <= getMillisecondsFromTime(meeting.getHoldTime())
                                && (getMillisecondsFromTime(meeting.getHoldTime()) + meeting.getTimeLength() * 60000) <= getMillisecondsFromTime(preference.getEndTime())
                ) {

                    continue loop;
                }
            }
            scheduleShowList.add(new ScheduleShow(meeting.getMid(), meeting.getName(),
                    showTime(meeting.getHoldTime(), 0) + " to "
                            + showTime(meeting.getHoldTime(), meeting.getTimeLength())));
        }
        return scheduleShowList;
    }
}
