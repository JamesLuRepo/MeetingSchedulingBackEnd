package main.dao.impl;

import main.dao.MeetingDao;
import main.domian.Gps;
import main.domian.Meeting;
import main.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class MeetingDaoImpl implements MeetingDao {
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public int add(Meeting meeting) {
        String sql = "insert into meeting(name, notes, hold_time, time_length,location,scheduling_ddl,gps_gid) values(?,?,?,?,?,?,?)";
        int count = template.update(sql,
                meeting.getName(),
                meeting.getNotes(),
                meeting.getHoldTime(),
                meeting.getTimeLength(),
                meeting.getLocation(),
                meeting.getScheduling_ddl(),
                meeting.getGpsGid());



        return count;
    }

    @Override
    public int delete(Meeting meeting) {
        String sql = "delete from meeting where mid=?";
        int count = template.update(sql, meeting.getMid());
        return count;
    }

    @Override
    public int update(Meeting oldMeeting, Meeting newMeeting) {
        String sql = "update meeting set name=?,notes=?,hold_time=?,time_length=?,location=?,scheduling_ddl=?,gps_gid=? where mid=?";
        int count = template.update(sql,
                newMeeting.getName(),
                newMeeting.getNotes(),
                newMeeting.getHoldTime(),
                newMeeting.getTimeLength(),
                newMeeting.getLocation(),
                newMeeting.getScheduling_ddl(),
                newMeeting.getGpsGid(),
                oldMeeting.getMid());
        return count;
    }

    @Override
    public List<Meeting> findAll() {
        String sql = "select * from meeting";
        return template.query(sql, new BeanPropertyRowMapper<Meeting>(Meeting.class));
    }

    @Override
    public List<Meeting> findMeetingsByGroup(Integer gid) {
        String sql = "select * from meeting where gps_gid=?";
        return template.query(sql, new BeanPropertyRowMapper<Meeting>(Meeting.class),gid);
    }

    @Override
    public List<Meeting> findMeetingsByEmail(String email) {
        String sql = "SELECT MID,NAME,notes,hold_time,time_length,location,scheduling_ddl,gps_gid FROM (SELECT * FROM schedules WHERE user_email=?) e INNER JOIN meeting ON meeting.`mid`=e.meeting_id ORDER BY hold_time ASC";
        return template.query(sql, new BeanPropertyRowMapper<Meeting>(Meeting.class),email);
    }

    @Override
    public Meeting findMeeting(int mid) {
        String sql = "select * from meeting where mid=?";
        return template.query(sql, new BeanPropertyRowMapper<Meeting>(Meeting.class),mid).get(0);
    }

    @Override
    public Meeting findAddedRowJustNow() {
        String sql = "select * from meeting order by mid desc limit 1;";
        return template.query(sql, new BeanPropertyRowMapper<Meeting>(Meeting.class)).get(0);
    }


}
