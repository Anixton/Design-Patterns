public class LightSystem {
    private boolean isOn;
    private int brightnessPercentage;
    private int colorTemperature;

    private final int MIN_BRIGHTNESS = 0;
    private final int MAX_BRIGHTNESS = 100;
    private final int DEFAULT_BRIGHTNESS = 50;

    private final int MIN_TEMPERATURE = 2700;
    private final int MAX_TEMPERATURE = 5000;
    private final int WARM_TEMPERATURE_LIMIT = 3000;
    private final int NEUTRAL_TEMPERATURE_LIMIT = 4000;
    private final int DEFAULT_TEMPERATURE = 3500;

    public LightSystem() {
        isOn = false;
        brightnessPercentage = DEFAULT_BRIGHTNESS;
        colorTemperature = DEFAULT_TEMPERATURE;
    }
    
    public void turnOn() {
        isOn = true;
        System.out.println("Light system is on");
    }

    public void setBrightness(int brightnessPercentage) {
        if(!isOn) {
            System.out.println("Light system is off");
            return;
        } 

        brightnessPercentage = Math.max(MIN_BRIGHTNESS, Math.min(brightnessPercentage, MAX_BRIGHTNESS));
        this.brightnessPercentage = brightnessPercentage;
        System.out.println("Brightness set to " + brightnessPercentage);
    }

    public void setLightColor(int lightColor) {
        if(!isOn) {
            System.out.println("Light system is off");
            return;
        }   

        lightColor = Math.max(MIN_TEMPERATURE, Math.min(lightColor, MAX_TEMPERATURE));
        this.colorTemperature = lightColor;
        System.out.println("Light color set to " + lightColor);
    }

    public void turnOff() {
        isOn = false;
        System.out.println("Light system is off");
    }

    public void displayLightDetails() {
        if(!isOn) {
            System.out.println("Light system is off");
            return;
        }

        System.out.println("Light system is on");
        System.out.println("Brightness: " + brightnessPercentage);
        System.out.println("Color temperature: " + getColorTemperatureDetails());
    }

    private String getColorTemperatureDetails() {
        if(colorTemperature <= WARM_TEMPERATURE_LIMIT) {
            return "Warm";
        } else if(colorTemperature <= NEUTRAL_TEMPERATURE_LIMIT) {
            return "Neutral";
        } else {
            return "Cool";
        }
    }
}
