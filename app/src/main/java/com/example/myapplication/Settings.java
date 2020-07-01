package com.example.myapplication;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;
import android.content.Context;

public class Settings extends AppCompatActivity  {

    String lightTheme="0";
    String badWeather = "0";
    String TAG = "WEATHER";
    Switch switch1;
    Switch switch3;
    private SharedPreferences sharedPrefs;
    public static final String myPrefs = "myprefs";
    public static final String myPrefs2 = "myprefs2";
    public static final String nameKey = "nameKey";
    public static final String nameKey2 = "nameKey2";

    final String SAVED_TEXT = "saved_text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        //После этой строки нужно искать все View элементы в activity_settings
        switch1 = (Switch) findViewById(R.id.switch1);
        switch3 = (Switch) findViewById(R.id.switch3);
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    lightTheme = "1";
                    setLightTheme(lightTheme);
                } else {
                    lightTheme = "0";
                    setLightTheme(lightTheme);
                }
            }
        });
        switch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    badWeather = "1";
                    setBadWeather(badWeather);
                } else {
                    badWeather = "0";
                    setBadWeather(badWeather);
                }
            }
        });

        Toast.makeText(getApplicationContext(), "Запуск", Toast.LENGTH_SHORT).show();
        Log.d("LOG", "Запуск");

        sharedPrefs = getSharedPreferences(myPrefs, Context.MODE_PRIVATE);
        if (sharedPrefs.contains(nameKey) || sharedPrefs.contains(nameKey2)) {
            lightTheme = sharedPrefs.getString(nameKey, "");
            badWeather = sharedPrefs.getString(nameKey2, "");
        }


            System.out.println(lightTheme);
            if(lightTheme.equals("1")){
                switch1.setChecked(true);
            }
            else if(lightTheme.equals("0")){
                switch1.setChecked(false);
            }
            if(badWeather.equals("1")){
                switch3.setChecked(true);
            }
            else if(badWeather.equals("0")){
                switch3.setChecked(false);
            }
            log("Settings were set");
    }


    private void setOnCheckedChangeListener(Settings settings) {
    }

    private void setLightTheme(String l){

        System.out.println(lightTheme);
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString(nameKey, l);
        editor.apply();
    }

    private void setBadWeather(String w){
        System.out.println(badWeather);
        SharedPreferences.Editor editor2 = sharedPrefs.edit();
        editor2.putString(nameKey2, w);
        editor2.apply();
    }

    @Override
    protected void onSaveInstanceState(Bundle saveInstanceState){
        super.onSaveInstanceState(saveInstanceState);
        log("onSaveInstanceState");
    }

    @Override
    protected void onStop() {
        super.onStop();
        log("onStop()");
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
        log("Back pressed");

    }

    public void log(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        Log.d(TAG, message);
    }
}
