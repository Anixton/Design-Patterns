class FahrenheitTemperatureConverter implements TemperatureConverter {
    @Override
    public double convertToFahrenheit(double fahrenheit) {
        return fahrenheit;
    }

    @Override
    public double convertToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    @Override
    public double convertToKelvin(double fahrenheit) {
        return (fahrenheit + 459.67) * 5 / 9;
    }
}
