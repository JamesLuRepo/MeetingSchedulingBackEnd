package main.service.impl;

import main.domian.User;
import main.dao.UserDao;
import main.dao.impl.UserDaoImpl;
import main.service.UserService;
import main.utils.EmailSendingUtils;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    /**
     * @param email
     * @return find nothing -->0, find the email --> 1;
     */
    @Override
    public int checkEmail(String email) {
        User user = userDao.findByEmail(email);
        return user == null ? 0 : 1;

    }

    @Override
    public int addUser(String email, String name, String password) {
        User user = new User(email,name,password);
        return userDao.add(user);
    }

    /**
     * send verificationCode
     *
     * @param email
     * @param verificationCode
     * @return
     */
    @Override
    public int sendVerificationCode(String email, String verificationCode) {
        return EmailSendingUtils.sendVerificationCode(email, verificationCode);
    }

    /**
     * the logic of login
     *
     * @param email
     * @param password
     * @return return "successful" if successful, return "fail" if fail
     */
    @Override
    public String logIn(String email, String password) {
        User user = userDao.findByEmail(email);
        if (user==null){
            return "fail";
        }
        if (user.getPassword().equals(password)) {
            return "successful&"+user.getName();
        }
        return "fail";
    }

    @Override
    public List<User> searchUsers(String searchContent) {
        List<User> fromEmail = userDao.findFromEmail(searchContent);
        return fromEmail;
    }

    @Override
    public List<User> findUserByGroupId(String gid) {
        List<User> userByGroupId = userDao.findUserByGroupId(Integer.parseInt(gid));

        return userByGroupId;
    }


}
