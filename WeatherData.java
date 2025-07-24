package com.example.weatherforecastapp;

public class WeatherData {
    private double temp;
    private String description;
    private String iconUrl;

    public WeatherData(double temp, String description, String iconUrl) {
        this.temp = temp;
        this.description = description;
        this.iconUrl = iconUrl;
    }

    public double getTemp() {
        return temp;
    }

    public String getDescription() {
        return description;
    }

    public String getIconUrl() {
        return iconUrl;
    }
}

