package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Cities extends AppCompatActivity {

    private Button city1;
    private Button city2;
    private Button city3;
    private Button city4;
    private Button find;
    private EditText findCity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cities);
        final String [] cities = new String [] {"Prague", "London", "Kyiv", "New York"};
        city1 = (Button) findViewById(R.id.button);
        city2 = (Button) findViewById(R.id.button2);
        city3 = (Button) findViewById(R.id.button3);
        city4 = (Button) findViewById(R.id.button4);
        find = (Button) findViewById(R.id.button7);
        findCity = (EditText) findViewById(R.id.editText);

        city1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setCity(cities[0]);
            }
        });

        city2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setCity(cities[1]);
            }
        });
        city3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setCity(cities[2]);
            }
        });
        city4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setCity(cities[3]);
            }
        });
        find.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Context context = getApplicationContext();
                Intent intent = new Intent(context, MainActivity.class);
                Log.d("||", String.valueOf(findCity.getText()));
                intent.putExtra("CITY", String.valueOf(findCity.getText()));
                startActivity(intent);
            }
        });
    }
    private void setCity(String cityName){
        Context context = getApplicationContext();
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra("CITY", cityName);
        startActivity(intent);
    }
//    public void cityIsChosen(View view) {
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
//
//
//
//    }
//    public void onClick(View v) {
//
//    }


}
