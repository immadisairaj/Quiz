package com.example.immadisairaj.quiz;

import android.content.SharedPreferences;

import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
    }

    public static class QuizPreferenceFragment extends PreferenceFragment implements Preference.OnPreferenceChangeListener {
        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.settings_main);
            Preference list_preference_difficulty = findPreference(getString(R.string.difficulty_key));
            Preference list_preference_category = findPreference(getString(R.string.category_key));
            list_preference_difficulty.setOnPreferenceChangeListener(this);
            list_preference_category.setOnPreferenceChangeListener(this);
            bindPreferenceSummaryToValue(list_preference_difficulty);
            bindPreferenceSummaryToValue(list_preference_category);
        }

        private void bindPreferenceSummaryToValue(Preference preference) {
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(preference.getContext());
            String value = sharedPreferences.getString(preference.getKey(), " ");
            onPreferenceChange(preference, value);

        }

        @Override
        public boolean onPreferenceChange(Preference preference, Object newValue) {
            String stringValue = newValue.toString();
            ListPreference listPreference = (ListPreference) preference;
            int prefIndex = listPreference.findIndexOfValue(stringValue);
            if (prefIndex >= 0) {
                CharSequence[] labels = listPreference.getEntries();
                preference.setSummary(labels[prefIndex]);
            }
            return true;
        }


    }

}
