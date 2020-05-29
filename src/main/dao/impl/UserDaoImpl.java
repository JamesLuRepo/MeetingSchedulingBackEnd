package main.dao.impl;


import main.dao.UserDao;
import main.domian.User;
import main.utils.JDBCUtils;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;


public class UserDaoImpl implements UserDao {
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public int add(User user) {
        String sql = "insert into user(email, name, password) values(?,?,?)";
        int count = template.update(sql, user.getEmail(), user.getName(), user.getPassword());
        return count;
    }

    @Override
    public int delete(User user) {
        String sql = "delete from user where email=?";
        int count = template.update(sql, user.getEmail());
        return count;
    }

    @Override
    public int update(User oldUser, User newUser) {
        String sql = "update user set email=?,name=?,password=? where email=?";
        int count = template.update(sql,
                newUser.getEmail(),newUser.getName(),
                newUser.getPassword(),oldUser.getEmail());
        return count;
    }

    @Override
    public User findByEmail(String email) {
        String sql = "select * from user where email='" + email+"'";
        List<User> list = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return list.isEmpty()?null:list.get(0);
    }

    @Override
    public List<User> findFromName(String charWithinName) {
        String sql = "select * from user where name like '%" + charWithinName + "%'";
        List<User> list = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        for (User user : list) {
            System.out.println(user);
        }

        return null;
    }

    @Override
    public List<User> findFromEmail(String charWithinEmail) {

        String sql = "select * from user where email like '%" + charWithinEmail + "%'";
        List<User> list = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return list;
    }


    @Override
    public Long count() {
        String sql = "select count(email) from user";
        Long total = template.queryForObject(sql, Long.class);
        return total;
    }

    @Override
    public List<User> findUserByGroupId(Integer gid) {

        String sql = "SELECT email,NAME,PASSWORD FROM (SELECT * FROM user_gps WHERE gps_gid=?) t INNER JOIN user ON user.`email`=t.user_email";
        List<User> list = template.query(sql, new BeanPropertyRowMapper<User>(User.class),gid);
        return list;

    }
}
