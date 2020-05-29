package main.service.impl;

import main.dao.GpsDao;
import main.dao.UserGpsDao;
import main.dao.impl.GpsDaoImpl;
import main.dao.impl.UserGpsDaoImpl;
import main.domian.Gps;
import main.domian.User;
import main.domian.UserGps;
import main.service.GpsService;

import java.util.List;

public class GpsServiceImpl implements GpsService {
    GpsDao gpsDao = new GpsDaoImpl();
    UserGpsDao userGpsDao = new UserGpsDaoImpl();


    /**
     * When add a group, add to the groups table and the user_gps table
     * @param userList
     * @param gps
     * @return
     */
    @Override
    public Integer addGps(List<User> userList, Gps gps) {
        int count1 = gpsDao.add(gps);
        Gps addedGps = gpsDao.findAddedRowJustNow();
        for (User user : userList) {
            int count2 = userGpsDao.add(new UserGps(user.getEmail(), addedGps.getGid()));
            if (count2 != 1) {
                return 0;
            }
        }
        return count1 == 1 ? 1 : 0;
    }

    @Override
    public List<Gps> findGroupsByEmail(String email) {
        List<Gps> list = gpsDao.findGpsByEmail(email);
        return list;
    }
}
