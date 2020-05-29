package main.dao.impl;

import main.dao.UserGpsDao;
import main.domian.UserGps;
import main.utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserGpsDaoImpl implements UserGpsDao {
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public int add(UserGps userGps) {
        String sql = "insert into user_gps(user_email, gps_gid) values(?,?)";
        int count = template.update(sql,
                userGps.getUserEmail(),
                userGps.getGpsGid());
        return count;
    }

    @Override
    public int delete(UserGps userGps) {
        String sql = "DELETE FROM user_gps WHERE user_email=? AND gps_gid=?";
        int count = template.update(sql, userGps.getUserEmail(), userGps.getGpsGid());
        return count;
    }

    @Override
    public int update(UserGps oldUserGps, UserGps newUserGps) {
        String sql = "update user_gps set user_email=?,gps_gid=? WHERE user_email=? AND gps_gid=?";
        int count = template.update(sql,
                newUserGps.getUserEmail(),
                newUserGps.getGpsGid(),
                oldUserGps.getUserEmail(),
                oldUserGps.getGpsGid());
        return count;
    }
}
