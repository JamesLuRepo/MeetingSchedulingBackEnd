package test.testService;

import main.domian.Preference;
import main.service.PreferenceService;
import main.service.impl.PreferenceServiceImpl;
import org.junit.Test;

import java.util.List;

public class TestPreferenceService {

    PreferenceService preferenceService = new PreferenceServiceImpl();
    @Test
    public void testGetPreferenceList(){

        List<Preference> preferenceList = preferenceService.getPreferenceList("ziyulu45@gmail.com");
        for (Preference preference : preferenceList) {
            System.out.println(preference);
        }
    }

    @Test
    public void testAddPreference() {
        Integer asd = preferenceService.addPreference(new Preference(null,
                "2020-5-20 01:00:00",
                "2020-5-21 01:11:00",
                "asd"));
        System.out.println(asd);

    }
}
