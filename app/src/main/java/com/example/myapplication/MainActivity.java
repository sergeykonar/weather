package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView text;
    TextView cityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }

    public void chooseTheCity(View view) {
        Intent intent = new Intent(this, Cities.class);
        startActivity(intent);
    }

    public void goToSettings(View view) {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }


    @Override
    public void onClick(View v) {

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LOG", "Вызов функции onStart()");
        Toast.makeText(getApplicationContext(), "Візов функции onStart()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestoreInstanceState(Bundle saveInstanceState){
        super.onRestoreInstanceState(saveInstanceState);
        Log.d("LOG", "Вызов функции onRestoreInstanceState()");
        Toast.makeText(getApplicationContext(), "Вызов функции onRestoreInstanceState()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LOG", "Вызов функции onResume()");
        Toast.makeText(getApplicationContext(), "Вызов функции onResume()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LOG", "Вызов функции onPause()");
        Toast.makeText(getApplicationContext(), "Вызов функции onPause()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onSaveInstanceState(Bundle saveInstanceState){
        super.onSaveInstanceState(saveInstanceState);
        Log.d("LOG", "Вызов функции onSaveInstanceState()");
        Toast.makeText(getApplicationContext(), "Вызов функции onSaveInstanceState()", Toast.LENGTH_SHORT).show();



    }



    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LOG", "Вызов функции onStop()");
        Toast.makeText(getApplicationContext(), "Вызов функции  onStop()", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
        Toast.makeText(getBaseContext(), "Вы нажали на кнопку Назад", Toast.LENGTH_SHORT).show();

    }


}

