package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
}

