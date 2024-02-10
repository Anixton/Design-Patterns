package com.example;

/**
 * The WeatherStation class is the entry point for the weather station application.
 * It creates a WeatherData object and several display objects, registers the displays as observers of the WeatherData,
 * and then starts simulating weather data.
 */
public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        Observer currentDisplay = new CurrentConditionsDisplay();
        Observer statisticsDisplay = new StatisticsDisplay();
        Observer forecastDisplay = new ForecastDisplay();
        Observer secondCurrentDisplay = new CurrentConditionsDisplay();

        weatherData.registerObserver(currentDisplay);
        weatherData.registerObserver(statisticsDisplay);
        weatherData.registerObserver(forecastDisplay);
        weatherData.registerObserver(secondCurrentDisplay);

        weatherData.simulateWeatherData();
    }
}
