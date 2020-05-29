package main.service;

import main.domian.Gps;
import main.domian.User;

import java.util.List;

public interface GpsService {

    public Integer addGps(List<User> userList, Gps gps);

    public List<Gps> findGroupsByEmail(String email);


}
