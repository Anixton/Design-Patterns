public class TemperatureController {
    private int temperature;
    private boolean isOn;

    public TemperatureController() {
        isOn = false;
        temperature = 21;
    }

    public void turnOn() {
        isOn = true;
        System.out.println("Temperature controller is on");
    }

    public void setTemperature(int temperature) {
        if (isOn) {
            this.temperature = temperature;
            System.out.println("Temperature set to " + temperature);
        } else {
            System.out.println("Temperature controller is off");
        }
    }

    public int getTemperature() {
        return temperature;
    }

    public void turnOff() {
        isOn = false;
        System.out.println("Temperature controller is off");
    }

    public void displayTemperatureDetails() {
        System.out.println("Temperature: " + temperature);
        System.out.println("Temperature controller is " + (isOn ? "on" : "off"));
    }

    public boolean isOn() {
        return isOn;
    }
}
