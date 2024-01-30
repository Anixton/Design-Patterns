public class CelsiusTemperatureConverter implements TemperatureConverter {
    @Override
    public double convertToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    @Override
    public double convertToCelsius(double celsius) {
        return celsius;
    }

    @Override
    public double convertToKelvin(double celsius) {
        return celsius + 273.15;
    }
}
