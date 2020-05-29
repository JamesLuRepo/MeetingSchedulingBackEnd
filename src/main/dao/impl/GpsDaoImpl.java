package main.dao.impl;

import main.dao.GpsDao;
import main.domian.Gps;
import main.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class GpsDaoImpl implements GpsDao {
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public int add(Gps gps) {
        String sql = "insert into gps(name, description) values(?,?)";
        int count = template.update(sql,
                gps.getName(),
                gps.getDescription());
        return count;
    }

    @Override
    public int delete(Gps gps) {
        String sql = "delete from gps where gid=?";
        int count = template.update(sql, gps.getGid());
        return count;
    }

    @Override
    public int update(Gps oldGps, Gps newGps) {
        String sql = "update gps set name=?,description=? where gid=?";
        int count = template.update(sql,
                newGps.getName(),
                newGps.getDescription(),
                oldGps.getGid());
        return count;
    }

    @Override
    public List<Gps> findAll() {
        String sql = "select * from gps";
        return template.query(sql, new BeanPropertyRowMapper<Gps>(Gps.class));
    }

    @Override
    public List<Gps> findGpsByEmail(String email) {
        String sql = "SELECT gid,NAME,description FROM (SELECT gps_gid FROM user_gps WHERE user_email=?) g INNER JOIN gps ON g.gps_gid=gps.`gid`";
        return template.query(sql, new BeanPropertyRowMapper<Gps>(Gps.class),email);
    }

    @Override
    public Gps findAddedRowJustNow() {
        String sql = "select * from gps order by gid desc limit 1;";
        return template.query(sql, new BeanPropertyRowMapper<Gps>(Gps.class)).get(0);
    }
}
