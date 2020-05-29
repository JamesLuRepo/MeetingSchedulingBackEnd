package main.dao;


import main.domian.UserGps;

public interface UserGpsDao {


    public int add(UserGps userGps);
    public int delete(UserGps userGps);
    public int update(UserGps oldUserGps, UserGps newUserGps);

}



