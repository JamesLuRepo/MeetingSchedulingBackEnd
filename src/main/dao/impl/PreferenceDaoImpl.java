package main.dao.impl;

import main.dao.PreferenceDao;
import main.domian.Meeting;
import main.domian.Preference;
import main.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class PreferenceDaoImpl implements PreferenceDao {
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public int add(Preference preference) {

        String sql = "insert into preference(start_time, end_time, user_email) values(?,?,?)";
        int count = template.update(sql,
                preference.getStartTime(),
                preference.getEndTime(),
                preference.getUserEmail());


        return count;
    }

    @Override
    public List<Preference> findPreferenceByUserEmail(String email) {
        String sql = "select * from preference where user_email=?";
        return template.query(sql, new BeanPropertyRowMapper<Preference>(Preference.class),email);
    }
}
