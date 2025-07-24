package com.example.weatherforecastapp;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class WeatherApp extends Application {

    private Label temperatureLabel = new Label();
    private Label descriptionLabel = new Label();
    private ImageView weatherIcon = new ImageView();

    @Override
    public void start(Stage primaryStage) {
        TextField cityInput = new TextField();
        cityInput.setPromptText("Enter city name");
        Button searchButton = new Button("Get Weather");

        searchButton.setOnAction(e -> {
            String city = cityInput.getText();
            WeatherData data = WeatherService.getWeather(city);
            if (data != null) {
                temperatureLabel.setText("Temperature: " + data.getTemp() + " °C");
                descriptionLabel.setText("Condition: " + data.getDescription());
                weatherIcon.setImage(new Image(data.getIconUrl()));
            } else {
                temperatureLabel.setText("Error: City not found.");
                descriptionLabel.setText("");
                Image image = new Image(getClass().getResource("weather-app.png").toExternalForm());
                weatherIcon.setImage(image);

            }
        });

        VBox root = new VBox(10, cityInput, searchButton, temperatureLabel, descriptionLabel, weatherIcon);
        root.setPadding(new Insets(15));
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.setTitle("Weather App");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

