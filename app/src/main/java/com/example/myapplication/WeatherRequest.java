package com.example.myapplication;
public class WeatherRequest {

    private Weather[] weather;

    private String name;
    private Main main;


    public Weather[] getWeather() {
        return weather;
    }

    public void setWeather(Weather[] weather) {
        this.weather = weather;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }
//
//    public Wind getWind() {
//        return wind;
//    }
//
//    public void setWind(Wind wind) {
//        this.wind = wind;
//    }
//
//    public Clouds getClouds() {
//        return clouds;
//    }
//
//    public void setClouds(Clouds clouds) {
//        this.clouds = clouds;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
