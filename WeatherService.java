package com.example.weatherforecastapp;

import com.google.gson.*;
import java.io.*;
import java.net.*;

public class WeatherService {
    private static final String API_KEY = "fb680868d81a53151a6cb0c8d9666465";

    public static WeatherData getWeather(String city) {
        try {
            String urlStr = "https://api.openweathermap.org/data/2.5/weather?q=" +
                    URLEncoder.encode(city, "UTF-8") +
                    "&appid=" + API_KEY + "&units=metric";
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            JsonObject json = JsonParser.parseReader(reader).getAsJsonObject();

            double temp = json.getAsJsonObject("main").get("temp").getAsDouble();
            String description = json.getAsJsonArray("weather")
                    .get(0).getAsJsonObject()
                    .get("description").getAsString();
            String icon = json.getAsJsonArray("weather")
                    .get(0).getAsJsonObject()
                    .get("icon").getAsString();
            return new WeatherData(temp, description, "https://openweathermap.org/img/wn/" + icon + "@2x.png");
        } catch (Exception e) {
            return null;
        }
    }
}
