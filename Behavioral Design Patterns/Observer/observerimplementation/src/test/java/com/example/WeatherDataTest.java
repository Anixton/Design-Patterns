package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import org.junit.Test;

/**
 * Unit test for WeatherData class.
 */
public class WeatherDataTest {
    /**
     * Test to verify that WeatherData updates its observers correctly.
     */
    @Test
    public void testWeatherDataUpdates() {
       Observer mockObserver = mock(Observer.class);
       WeatherData weatherData = new WeatherData();

       weatherData.registerObserver(mockObserver);
       weatherData.setMeasurements(70, 50, 950);
       verify(mockObserver).update(70, 50, 950);


       weatherData.removeObserver(mockObserver);
       weatherData.setMeasurements(80, 60, 960);
       verifyNoMoreInteractions(mockObserver);
    }
}
