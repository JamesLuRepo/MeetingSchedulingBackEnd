package main.dao;



import main.domian.Schedule;




public interface ScheduleDao {

    public int add(Schedule schedule);
    public int delete(Schedule schedule);
    public int update(Schedule oldSchedule, Schedule newSchedule);




}
