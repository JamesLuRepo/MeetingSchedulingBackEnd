package main.dao;

import main.domian.Gps;
import main.domian.Meeting;


import java.util.List;

public interface GpsDao {

    public int add(Gps gps);
    public int delete(Gps gps);
    public int update(Gps oldGps, Gps newGps);
    public List<Gps> findAll();
    public List<Gps> findGpsByEmail(String email);
    public Gps findAddedRowJustNow();
}
