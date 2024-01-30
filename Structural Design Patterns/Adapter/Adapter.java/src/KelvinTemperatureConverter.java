public class KelvinTemperatureConverter implements TemperatureConverter{
    @Override
    public double convertToFahrenheit(double kelvin) {
        return (kelvin - 273.15) * 9 / 5 + 32;
    }

    @Override
    public double convertToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    @Override
    public double convertToKelvin(double kelvin) {
        return kelvin;
    }
}
