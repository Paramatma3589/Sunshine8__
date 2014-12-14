package com.sunshine.satyananda.sunshine;

import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

/**
 * Created by Satyananda on 25.11.2014.
 */

public class SettingsActivity extends PreferenceActivity
        implements Preference.OnPreferenceChangeListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Add preferences from XML file
        addPreferencesFromResource(R.xml.pref_general);
        // For all preferences, attach this for updates to UI summary when preference changes.
        bindPreferenceSummaryToValue(findPreference(getString(R.string.pref_location_key)));
        bindPreferenceSummaryToValue(findPreference(getString(R.string.pref_units_key)));
        }

    /**
     * Attach a listener so summary is always updated preference value.
     * Also fire listener once, to initialize the summary
     */
    private void bindPreferenceSummaryToValue(Preference preference) {
        // Set the listener to watch for value changes.
        preference.setOnPreferenceChangeListener(this);

        // Trigger the listener immediately with the preference's
        // current value.
       onPreferenceChange(preference,
                PreferenceManager
                        .getDefaultSharedPreferences(preference.getContext())
                        .getString(preference.getKey(), ""));
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object value) {
        String stringValue = value.toString();

        if (preference instanceof ListPreference) {
            // For list preferences, look up the correct display value in
            // the preference's 'entries' list (since they have separate labels/values).
            ListPreference listPreference = (ListPreference) preference;
            int prefIndex = listPreference.findIndexOfValue(stringValue);
            if (prefIndex >= 0) {
                preference.setSummary(listPreference.getEntries()[prefIndex]);
            }
        } else {
            // For others, set summary to value's simple string representation.
            preference.setSummary(stringValue);
        }
        return true;
    }

}
