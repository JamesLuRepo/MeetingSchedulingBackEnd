package test.testDao;

import main.dao.GpsDao;
import main.dao.impl.GpsDaoImpl;
import main.domian.Gps;
import org.junit.Test;

import java.util.List;

public class TestGpsDao {

    GpsDao gpsDao = new GpsDaoImpl();

    @Test
    public void testAdd() {
        int count = gpsDao.add(new Gps(null,"groups666","for test"));
        System.out.println(count);

    }

    @Test
    public void testDelete() {
        int count = gpsDao.delete(new Gps(9,"ssdf","sdf"));
        System.out.println(count);
    }

    @Test
    public void testUpdate() {
        int count = gpsDao.update(new Gps(9,"sdf","sdf"),
                new Gps(null,"8888888","888888888"));
        System.out.println(count);
    }

    @Test
    public void testFindAll() {
        List<Gps> list = gpsDao.findAll();
        for (Gps gps : list) {
            System.out.println(gps);
        }
    }

    @Test
    public void testFindGpsByEmail() {
        List<Gps> list = gpsDao.findGpsByEmail("asd");
        for (Gps gps : list) {
            System.out.println(gps);
        }
    }
    @Test
    public void testFindAddedRowJustNow(){
        System.out.println(gpsDao.findAddedRowJustNow());

    }
}
