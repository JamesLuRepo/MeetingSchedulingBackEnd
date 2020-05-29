package main.dao.impl;

import main.dao.ScheduleDao;
import main.domian.Schedule;
import main.utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

public class ScheduleDaoImpl implements ScheduleDao {
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public int add(Schedule schedule) {
        String sql = "insert into schedules(user_email, meeting_id) values(?,?)";
        int count = template.update(sql,
                schedule.getUserEmail(),
                schedule.getMeetingId());
        return count;
    }

    @Override
    public int delete(Schedule schedule) {
        String sql = "DELETE FROM schedules WHERE user_email=? AND meeting_id=?";
        int count = template.update(sql, schedule.getUserEmail(),schedule.getMeetingId());
        return count;
    }

    @Override
    public int update(Schedule oldSchedule, Schedule newSchedule) {
        String sql = "update schedules set user_email=?,meeting_id=? WHERE user_email=? AND meeting_id=?";
        int count = template.update(sql,
                newSchedule.getUserEmail(),
                newSchedule.getMeetingId(),
                oldSchedule.getUserEmail(),
                oldSchedule.getMeetingId());
        return count;
    }
}
