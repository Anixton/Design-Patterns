package com.example;

/**
 * The CurrentConditionsDisplay class displays the current weather conditions.
 * It implements the Observer interface so it can receive updates from a WeatherData object.
 */
public class CurrentConditionsDisplay implements Observer{
    public void update(double temperature, double humidity, double pressure) {
        System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
    }
}
