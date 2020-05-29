package test.testDao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import main.dao.UserGpsDao;
import main.dao.impl.UserGpsDaoImpl;
import main.domian.Meeting;
import main.domian.User;
import main.domian.UserGps;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestUserGpsDao {

    UserGpsDao userGpsDao = new UserGpsDaoImpl();

    @Test
    public void testAdd() {
        UserGps userGps = new UserGps();
        userGps.setUserEmail("asd");
        userGps.setGpsGid(5);
        int count = userGpsDao.add(userGps);
        System.out.println(count);

    }

    @Test
    public void testDelete() {
        UserGps userGps = new UserGps();
        userGps.setUserEmail("asd");
        userGps.setGpsGid(5);
        int count = userGpsDao.delete(userGps);
        System.out.println(count);
    }

    @Test
    public void testUpdate() {
        UserGps oldUserGps = new UserGps();
        oldUserGps.setUserEmail("asd");
        oldUserGps.setGpsGid(4);
        UserGps newUserGps = new UserGps();
        newUserGps.setUserEmail("asd");
        newUserGps.setGpsGid(5);
        int count = userGpsDao.update(oldUserGps, newUserGps);
        System.out.println(count);
    }

}
