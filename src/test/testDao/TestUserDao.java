package test.testDao;

import main.dao.impl.UserDaoImpl;
import main.domian.User;
import org.junit.Test;

import java.util.List;

public class TestUserDao {
    UserDaoImpl userDao = new UserDaoImpl();
    @Test
    public void testAdd(){

        User user = new User("888888","23131","3423423423");

        userDao.add(user);
    }


    @Test
    public void testDelete() {
        userDao.delete(null);
    }

    @Test
    public void testFindFromName() {

        userDao.findFromName(null);

    }

    @Test
    public void testFindFromEmail() {

        List<User> fromEmail = userDao.findFromEmail("2");
        System.out.println(fromEmail);

    }

    @Test
    public void testFindByEmail() {
        System.out.println(userDao.findByEmail("ziyulu45@gmail.com"));
    }

    @Test
    public void testCount() {
        System.out.println(userDao.count());
    }

    @Test
    public void testUpdate(){
        int count = userDao.update(new User("aaa", "bbb", "ccc"),
                new User("aaa", "ddd", "ccc"));
        System.out.println(count);
    }

    @Test
    public void testFindUserByGroupId() {
        List<User> userByGroupId = userDao.findUserByGroupId(19);
        System.out.println(userByGroupId);


    }
}
