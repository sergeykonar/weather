package com.example.myapplication;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;
import android.content.Context;

public class Settings extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    String lightTheme="0";
    String badWeather = "0";

    Switch switch1;
    Switch switch3;
    private SharedPreferences sharedPrefs;
    private SharedPreferences sharedPrefs2;
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
        switch1.setOnCheckedChangeListener(this);
        switch3.setOnCheckedChangeListener(this);
        Toast.makeText(getApplicationContext(), "Запуск", Toast.LENGTH_SHORT).show();
        Log.d("LOG", "Запуск");

        sharedPrefs = getSharedPreferences(myPrefs, Context.MODE_PRIVATE);
        sharedPrefs2 = getSharedPreferences(myPrefs2, Context.MODE_PRIVATE);
        if (sharedPrefs.contains(nameKey) || sharedPrefs2.contains(nameKey2)) {
            // если есть, то ставим значение этого ключа в EditText
            lightTheme = sharedPrefs.getString(nameKey, "");
            badWeather = sharedPrefs2.getString(nameKey2, "");
        }

        Toast.makeText(this, "Text loaded", Toast.LENGTH_SHORT).show();

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



    }


    private void setOnCheckedChangeListener(Settings settings) {
    }


    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        Toast.makeText(this, "Отслеживание переключения: " + " " +" " + (isChecked ? "on" : "off"),
                Toast.LENGTH_SHORT).show();
        switch (buttonView.getId()) {
            case R.id.switch1:
                if (isChecked) {
                    lightTheme = "1";
                    System.out.println(lightTheme);
                    SharedPreferences.Editor editor = sharedPrefs.edit();
                    editor.putString(nameKey, lightTheme);
                    editor.apply();
                } else {
                    lightTheme = "0";
                    System.out.println(lightTheme);
                    SharedPreferences.Editor editor = sharedPrefs.edit();
                    editor.putString(nameKey, lightTheme);
                    editor.apply();
                }
            case R.id.switch3:
                if (isChecked) {
                    badWeather = "1";
                    System.out.println(badWeather);
                    SharedPreferences.Editor editor2 = sharedPrefs2.edit();
                    editor2.putString(nameKey2, badWeather);
                    editor2.apply();
                } else {
                    badWeather = "0";
                    System.out.println(badWeather);
                    SharedPreferences.Editor editor2 = sharedPrefs2.edit();
                    editor2.putString(nameKey2, badWeather);
                    editor2.apply();
                }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle saveInstanceState){
        super.onSaveInstanceState(saveInstanceState);
        Toast.makeText(getApplicationContext(), "onSaveInstanceState()", Toast.LENGTH_SHORT).show();
        SharedPreferences.Editor editor = sharedPrefs.edit();
        SharedPreferences.Editor editor2 = sharedPrefs2.edit();
        // сохраняем по текст из EditText по ключу nameKey
        editor.putString(nameKey, lightTheme);
        editor2.putString(nameKey2, badWeather);
        editor.apply();
        editor2.apply();

        Toast.makeText(this, "Text saved" + lightTheme +" " + badWeather, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LOG", "Вызов функции onStop()");

        SharedPreferences.Editor editor = sharedPrefs.edit();
        SharedPreferences.Editor editor2 = sharedPrefs2.edit();
        // сохраняем по текст из EditText по ключу nameKey
        editor.putString(nameKey, lightTheme);
        editor2.putString(nameKey2, badWeather);
        editor.apply();
        editor2.apply();

        System.out.println(lightTheme +" " + badWeather);
        Toast.makeText(this, "Text saved" + lightTheme +" " + badWeather, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
        Log.d("LOG", "Back");

        SharedPreferences.Editor editor = sharedPrefs.edit();
        SharedPreferences.Editor editor2 = sharedPrefs2.edit();
        // сохраняем по текст из EditText по ключу nameKey
        editor.putString(nameKey, lightTheme);
        editor2.putString(nameKey2, badWeather);
        editor.apply();
        editor2.apply();

        System.out.println(lightTheme +" " + badWeather);

    }


}
