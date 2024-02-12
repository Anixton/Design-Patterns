package com.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * WeatherData class is the subject 
 */
public class WeatherData {
    private double temperature;
    private double humidity;
    private double pressure;
    List<Observer> observers;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature, humidity, pressure);
        }
    }
    
    public void measurementsChanged() {
        notifyObservers();
    }

    public void setMeasurements(double temperature, double humidity, double pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public void simulateWeatherData() {
        Random random = new Random();
        while (true) {
            double temperature = 70 + random.nextDouble() * 10; // range: 60°F to 100°F
            double humidity = 50 + random.nextDouble() * 20; // range: 40% to 80%
            double pressure = 950 + random.nextDouble() * 100; // range: 950Pa to 1050Pa
            setMeasurements(temperature, humidity, pressure);
            try {
                Thread.sleep(5000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
