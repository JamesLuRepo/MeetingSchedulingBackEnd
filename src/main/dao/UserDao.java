package main.dao;

import main.domian.User;

import java.util.List;

public interface UserDao {
    public int add(User user) ;

    public int delete(User user);

    public int update(User oldUser,User newUser);

    /**
     * an accurate research
     * @param email
     * @return
     */
    public User findByEmail(String email);

    /**
     * fuzzy search from the database from name
     * @param charWithinName
     * @return
     */
    public List<User> findFromName(String charWithinName);

    /**
     * fuzzy search from the database from the email
     * @param charWithinEmail
     * @return
     */
    public List<User> findFromEmail(String charWithinEmail);

    /**
     * count total numbers from the table
     * @return
     */
    public Long count();

    public List<User> findUserByGroupId(Integer gid);




}
