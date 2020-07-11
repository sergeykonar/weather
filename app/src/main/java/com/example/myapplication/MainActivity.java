package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.Collectors;

import javax.net.ssl.HttpsURLConnection;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView text;
    private TextView cityName;
    private Button info;
    private TextView cityTemp;
    private static final String WEATHER_URL = "https://api.openweathermap.org/data/2.5/weather?q=";
    private static final String WEATHER_API_KEY = "&units=metric&appid=e89813f0aac2ffe098b97f711aae632a";
    private String [] temperature = {"+22 - Monday", "+26 - Tuesday", "+25 - Wednesday", "+50 - Thursday", "-20 - Friday"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityName = (TextView) findViewById(R.id.cityName);
        info = (Button) findViewById(R.id.button8);
        cityTemp = (TextView) findViewById(R.id.textView4);

        initRecyclerView(temperature);




        String city;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                city= null;
            } else {
                city= extras.getString("CITY");
                cityName.setText(city);
            }
        } else {
            city= (String) savedInstanceState.getSerializable("CITY");
            cityName.setText(city);
        }

        info.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CharSequence c = cityName.getText();
                String url = "https://ru.wikipedia.org/wiki/";
                if(cityName.getText().equals("Prague")){
                    url = url + "Прага";
                }
                if(cityName.getText().equals("London")){
                    url = url + "Лондон";
                }
                if(cityName.getText().equals("Kyiv")){
                    url = url + "Киев";
                }
                if(cityName.getText().equals("New York")){
                    url = url + "Нью-Йорк";
                }
                Uri uri = Uri.parse(url);
                Intent browser = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(browser);

            }
        });

        Context context = getApplicationContext();
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra("CITY", cityName.getText());

        try {
            final URL uri = new URL(WEATHER_URL+cityName.getText()+WEATHER_API_KEY);
            final Handler handler = new Handler();
            new Thread(new Runnable() {

                @RequiresApi(api = Build.VERSION_CODES.N)
                public void run() {
                    HttpsURLConnection urlConnection = null;
                    try {
                        urlConnection = (HttpsURLConnection) uri.openConnection();
                        urlConnection.setRequestMethod("GET");
                        urlConnection.setReadTimeout(10000);
                        BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                        String result = getLines(in);

                        Gson gson = new Gson();
                        final WeatherRequest weatherRequest = gson.fromJson(result, WeatherRequest.class);
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                displayWeather(weatherRequest);
                            }
                        });
                    } catch (Exception e) {
                        Log.e("TAG", "Fail connection", e);
                        e.printStackTrace();
                    } finally {
                        if (null != urlConnection) {
                            urlConnection.disconnect();
                        }
                    }
                }
            }).start();
        } catch (MalformedURLException e) {
            Log.e("TAG", "Fail URI", e);
            e.printStackTrace();
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private String getLines(BufferedReader in) {
        return in.lines().collect(Collectors.joining("\n"));
    }

    @SuppressLint("DefaultLocale")
    private void displayWeather(WeatherRequest weatherRequest){

        cityTemp.setText(String.format("%f2", weatherRequest.getMain().getTemp()));

    }






    public void chooseTheCity(View view) {
        Intent intent = new Intent(this, Cities.class);
        startActivity(intent);
    }

    public void goToSettings(View view) {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }

    private void initRecyclerView(String[] data){
        RecyclerView recyclerView = findViewById(R.id.recycler_view);


        recyclerView.setHasFixedSize(true);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        SocnetAdapter adapter = new SocnetAdapter(data);
        recyclerView.setAdapter(adapter);

        DividerItemDecoration itemDecoration = new DividerItemDecoration(this,  LinearLayoutManager.VERTICAL);
        itemDecoration.setDrawable(getDrawable(R.drawable.separator));
        recyclerView.addItemDecoration(itemDecoration);

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

