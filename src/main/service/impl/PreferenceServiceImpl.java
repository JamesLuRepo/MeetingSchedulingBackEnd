package main.service.impl;

import main.dao.PreferenceDao;
import main.dao.impl.PreferenceDaoImpl;
import main.domian.Preference;
import main.service.PreferenceService;

import java.util.List;

public class PreferenceServiceImpl implements PreferenceService {

    PreferenceDao preferenceDao = new PreferenceDaoImpl();
    @Override
    public List<Preference> getPreferenceList(String email) {

        List<Preference> preferenceByUserEmail = preferenceDao.findPreferenceByUserEmail(email);

        return preferenceByUserEmail;
    }

    @Override
    public Integer addPreference(Preference preference) {
        int count = preferenceDao.add(preference);
        return count;
    }
}
