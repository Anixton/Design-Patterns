//*********************************************************************************
//*  Hakan Gezginci
//* 
//*  This program uses the adapter design pattern to facilitate temperature conversions.
//*  The adapter pattern enables the program to extend functionality by adding new temperature
//*  scales without modifying the existing code, promoting flexibility and maintainability.
//*********************************************************************************

/**
 * This is the main client code for the Temperature Conversion System.
 * It showcases the usage of the adapter pattern to seamlessly convert temperatures
 * between Celsius, Fahrenheit, and Kelvin.
 *
 * The program includes the following components:
 * - TemperatureConverter interface: Defines the common interface for temperature converters.
 * - CelsiusTemperatureConverter, FahrenheitTemperatureConverter, KelvinTemperatureConverter:
 *   Implement the TemperatureConverter interface, providing specific conversion logic for
 *   Celsius, Fahrenheit, and Kelvin scales.
 * - TemperatureAdapter: Acts as an adapter, allowing different temperature converters to be
 *   used interchangeably by conforming to the TemperatureConverter interface.
 *
 * The client code creates instances of temperature converters and uses them directly,
 * demonstrating the flexibility of the adapter pattern. It also employs adapters to
 * showcase interchangeability between different temperature scales.
 *
 * Note: Please ensure that the TemperatureConverter, CelsiusTemperatureConverter,
 * FahrenheitTemperatureConverter, KelvinTemperatureConverter, and TemperatureAdapter classes
 * are appropriately implemented as per the provided design.
 */


public class TemperatureConverterClient {
    public static void main(String[] args) {
        TemperatureConverter celsiusConverter = new CelsiusTemperatureConverter();
        TemperatureConverter fahrenheitConverter = new FahrenheitTemperatureConverter();
        TemperatureConverter kelvinConverter = new KelvinTemperatureConverter();

        System.out.println("32 Celsius to Fahrenheit: " + celsiusConverter.convertToFahrenheit(32));
        System.out.println("100 Fahrenheit to Celsius: " + fahrenheitConverter.convertToCelsius(100));
        System.out.println("300 Kelvin to Celsius: " + kelvinConverter.convertToCelsius(300));

        TemperatureConverter adapterCelsiusToFahrenheit = new TemperatureAdapter(celsiusConverter);
        TemperatureConverter adapterFahrenheitToCelsius = new TemperatureAdapter(fahrenheitConverter);
        TemperatureConverter adapterKelvinToCelsius = new TemperatureAdapter(kelvinConverter);


        System.out.println("25 Celsius to Fahrenheit using Adapter: " + adapterCelsiusToFahrenheit.convertToFahrenheit(25));
        System.out.println("75 Fahrenheit to Celsius using Adapter: " + adapterFahrenheitToCelsius.convertToCelsius(75));
        System.out.println("500 Kelvin to Celsius using Adapter: " + adapterKelvinToCelsius.convertToCelsius(500));
    }
}
