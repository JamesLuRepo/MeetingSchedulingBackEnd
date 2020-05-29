package test.testDao;

import main.dao.PreferenceDao;
import main.dao.impl.PreferenceDaoImpl;
import main.domian.Preference;
import org.junit.Test;

import java.util.List;

public class TestPreferenceDao {
    PreferenceDao preferenceDao = new PreferenceDaoImpl();

    @Test
    public void testAdd() {
        int count = preferenceDao.add(new Preference(null,
                "2020-5-20 01:00:00",
                "2020-5-21 01:11:00",
                "asd"));
        System.out.println(count);
    }
    @Test
    public void testFindByUserEmail(){
        List<Preference> asd = preferenceDao.findPreferenceByUserEmail("asd");

        System.out.println(asd);

    }

}
