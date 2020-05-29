package main.service;

import main.domian.User;

import java.util.List;

public interface UserService {

    public int checkEmail(String email);

    public int addUser(String email, String name, String password);

    public int sendVerificationCode(String email,String verificationCode);

    public String logIn(String email,String password);

    public List<User> searchUsers(String searchContent);

    public List<User> findUserByGroupId(String gid);

}
