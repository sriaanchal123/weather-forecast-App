package com.example.weatherforecastapp;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class WeatherAppController {

    @FXML
    private TextField cityInput;

    @FXML
    private Label temperatureLabel;

    @FXML
    private Label descriptionLabel;

    @FXML
    private ImageView weatherIcon;

    @FXML
    private void handleGetWeather() {
        String city = cityInput.getText();
        WeatherData data = WeatherService.getWeather(city);

        if (data != null) {
            temperatureLabel.setText("Temperature: " + data.getTemp() + " °C");
            descriptionLabel.setText("Condition: " + data.getDescription());
            weatherIcon.setImage(new Image(data.getIconUrl()));
        } else {
            temperatureLabel.setText("Error: City not found.");
            descriptionLabel.setText("");
            // Fallback image from local resources
            Image image = new Image(getClass().getResource("weather-app.png").toExternalForm());
            weatherIcon.setImage(image);

        }
    }
}
