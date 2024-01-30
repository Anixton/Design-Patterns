class TemperatureAdapter implements TemperatureConverter {
    private TemperatureConverter temperatureConverter;

    public TemperatureAdapter(TemperatureConverter temperatureConverter) {
        this.temperatureConverter = temperatureConverter;
    }

    @Override
    public double convertToFahrenheit(double currentValue) {
        return temperatureConverter.convertToFahrenheit(currentValue);
    }

    @Override
    public double convertToCelsius(double currentValue) {
        return temperatureConverter.convertToCelsius(currentValue);
    }

    @Override
    public double convertToKelvin(double currentValue) {
        return temperatureConverter.convertToKelvin(currentValue);
    }
}
