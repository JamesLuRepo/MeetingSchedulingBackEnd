package main.dao;

import main.domian.Meeting;

import java.util.List;

public interface MeetingDao {
    public int add(Meeting meeting);
    public int delete(Meeting meeting);
    public int update(Meeting oldMeeting, Meeting newMeeting);
    public List<Meeting> findAll();
    public List<Meeting> findMeetingsByGroup(Integer gid);
    public List<Meeting> findMeetingsByEmail(String email);
    public Meeting findMeeting(int mid);
    public Meeting findAddedRowJustNow();




}
