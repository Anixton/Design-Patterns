package com.example;

/**
 * The StatisticsDisplay class displays weather statistics.
 * It implements the Observer interface so it can receive updates from a WeatherData object.
 */
public class StatisticsDisplay implements Observer{
    public void update(double temperature, double humidity, double pressure) {
        System.out.println("Statistics: Some statistics based on the received weather data.");
    }
}
