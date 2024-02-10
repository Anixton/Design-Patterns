package com.example;

/**
 * The ForecastDisplay class displays a weather forecast.
 * It implements the Observer interface so it can receive updates from a WeatherData object.
 */
public class ForecastDisplay implements Observer{
    public void update(double temperature, double humidity, double pressure) {
        System.out.println("Forecast: Some weather forecast based on the received weather data.");
    }
}
