package main.dao;

import main.domian.Preference;

import java.util.List;

public interface PreferenceDao {

    public int add(Preference preference);
    public List<Preference> findPreferenceByUserEmail(String email);

}
