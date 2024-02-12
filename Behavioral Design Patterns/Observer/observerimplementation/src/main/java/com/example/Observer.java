package com.example;

/**
 * The Observer interface is part of the Observer design pattern.
 * It is implemented by classes that need to be updated 
 * whenever the state of a WeatherData object changes.
 */
public interface Observer {
    abstract void update(double temperature, double humidity, double pressure);
}
