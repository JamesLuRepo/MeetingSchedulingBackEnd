package test.testService;

import main.domian.User;
import main.service.UserService;
import main.service.impl.UserServiceImpl;
import org.junit.Test;

import java.util.List;

public class TestUserService {

    UserService userService = new UserServiceImpl();

    @Test
    public void testCheckEmail() {
        int i = userService.checkEmail("u6889341@anu.edu.au");
        System.out.println(i);
    }

    @Test
    public void testAddUser() {
        int i = userService.addUser("asd", "asd", "asd");
        System.out.println(i);
    }
    @Test
    public void testSendVerificationCode(){
        int i = userService.sendVerificationCode("ziyulu45@gmail.com", "1234");
        System.out.println(i);
    }

    @Test
    public void testLogIn() {
        String s = userService.logIn("ziyulu45@gmail.com", "888888");
        System.out.println(s);
    }

    @Test
    public void testSearchUsers(){
        List<User> a = userService.searchUsers("a");

        System.out.println(a);

    }

    @Test
    public void testFindUserByGroupId() {

        List<User> userByGroupId = userService.findUserByGroupId("27");
        for (User user : userByGroupId) {
            System.out.println(user);
        }


    }
}
