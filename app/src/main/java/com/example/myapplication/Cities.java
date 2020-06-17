package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Cities extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cities);
    }

    public void cityIsChosen(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);



    }
    public void onClick(View v) {

    }


}
