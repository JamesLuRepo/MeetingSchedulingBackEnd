package main.service;



import main.domian.Meeting;
import main.domian.ScheduleShow;

import java.util.List;

public interface MeetingService {


    public Integer addMeeting(Meeting meeting);
    public Meeting getMeetingInformation(int mid);
    public List<ScheduleShow> findScheduleShowByGid(String gid);
    public Integer modifyMeeting(Meeting meeting);

}
