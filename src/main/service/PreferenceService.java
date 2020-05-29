package main.service;

import main.domian.Preference;

import java.util.List;

public interface PreferenceService {

    public List<Preference> getPreferenceList(String email);
    public Integer addPreference(Preference preference);

}
