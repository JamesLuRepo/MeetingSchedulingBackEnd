package test.testDao;


import main.dao.ScheduleDao;
import main.dao.impl.ScheduleDaoImpl;
import main.domian.Schedule;
import org.junit.Test;


public class TestScheduleDao {

    ScheduleDao scheduleDao = new ScheduleDaoImpl();

    @Test
    public void testAdd() {
        Schedule schedule = new Schedule();
        schedule.setMeetingId(5);
        schedule.setUserEmail("asd");
        int count = scheduleDao.add(schedule);
        System.out.println(count);

    }

    @Test
    public void testDelete() {
        Schedule schedule = new Schedule();
        schedule.setMeetingId(6);
        schedule.setUserEmail("asd");
        int count = scheduleDao.delete(schedule);
        System.out.println(count);
    }

    @Test
    public void testUpdate() {
        Schedule oldSchedule = new Schedule();
        oldSchedule.setMeetingId(5);
        oldSchedule.setUserEmail("asd");
        Schedule newSchedule = new Schedule();
        newSchedule.setMeetingId(6);
        newSchedule.setUserEmail("asd");
        int count = scheduleDao.update(oldSchedule,newSchedule);
        System.out.println(count);
    }


}
