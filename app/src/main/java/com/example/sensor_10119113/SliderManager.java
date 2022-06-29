package com.example.sensor_10119113;

import android.content.Context;
import android.content.SharedPreferences;

public class SliderManager {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    private static String PREF_NAME = "sliderManager";
    private static String IS_FIRST_TIME = "isFirst";

    public SliderManager(Context context)
    {
        sharedPreferences = context.getSharedPreferences(PREF_NAME,0);
        editor = sharedPreferences.edit();
    }

    public void setFirstTime(boolean isFirst)
    {
        editor.putBoolean(IS_FIRST_TIME, isFirst);
        editor.commit();
    }

    public boolean isFirstTime()
    {
        return sharedPreferences.getBoolean(IS_FIRST_TIME, true);
    }
}

//NIM : 10119113
//Nama : Dafa Rizky Fahreza
//Kelas : IF3