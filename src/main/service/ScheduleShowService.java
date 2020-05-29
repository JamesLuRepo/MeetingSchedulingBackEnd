package main.service;

import main.domian.ScheduleShow;

import java.util.List;

public interface ScheduleShowService {

    public List<ScheduleShow> getScheduleList(String email);
    public List<ScheduleShow> getAvailableMeetingList(String email);
    public List<ScheduleShow> getUnavailableMeetingList(String email);


}
