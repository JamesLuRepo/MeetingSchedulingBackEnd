package test.testService;

import main.domian.ScheduleShow;
import main.service.ScheduleShowService;
import main.service.impl.ScheduleShowServiceImpl;
import org.junit.Test;

import java.util.List;

public class TestScheduleShowService {

    ScheduleShowService scheduleShowService = new ScheduleShowServiceImpl();

    @Test
    public void testGetScheduleList() {
        List<ScheduleShow> scheduleList = scheduleShowService.getScheduleList("ziyulu45@gmail.com");
        for (ScheduleShow scheduleShow : scheduleList) {
            System.out.println(scheduleShow);
        }

    }

    @Test
    public void testGetAvailableMeetingList() {
        List<ScheduleShow> availableList = scheduleShowService.getAvailableMeetingList("asd");
        for (ScheduleShow scheduleShow : availableList) {
            System.out.println(scheduleShow);
        }
    }
    @Test
    public void testGetUnavailableMeetingList() {
        List<ScheduleShow> availableList = scheduleShowService.getUnavailableMeetingList("asd");
        for (ScheduleShow scheduleShow : availableList) {
            System.out.println(scheduleShow);
        }
    }
}
