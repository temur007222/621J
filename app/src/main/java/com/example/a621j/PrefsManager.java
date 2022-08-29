package com.example.a621j;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefsManager {
    private static PrefsManager prefsManager;
    private SharedPreferences sharedPreferences;

    public static PrefsManager getInstance(Context context) {
        if (prefsManager == null) {
            prefsManager = new PrefsManager(context);
        }
        return prefsManager;
    }

    private PrefsManager(Context context) {
        sharedPreferences = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
    }

    public void saveData(String key, Integer value) {
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putInt(key, value);
        prefsEditor.apply();
    }

    public int getData(String key) {
        if (sharedPreferences != null)
            return sharedPreferences.getInt(key, 1);
        return 0;
    }

    public void saveDataLong(String key, Long value) {
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putLong(key, value);
        prefsEditor.apply();
    }

    public long getDataLong(String key) {
        if (sharedPreferences != null)
            return sharedPreferences.getLong(key, 1);
        return 0;
    }

    public void saveDataBoolean(String key, Boolean value) {
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putBoolean(key, value);
        prefsEditor.apply();
    }

    public Boolean getDataBoolean(String key) {
        if (sharedPreferences != null)
            return sharedPreferences.getBoolean(key, true);
        return false;
    }

    public void saveDataDouble(String key, Double value) {
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putLong(key, Double.doubleToRawLongBits(value));
        prefsEditor.apply();
    }

}
