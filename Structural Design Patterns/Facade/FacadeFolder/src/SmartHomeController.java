public class SmartHomeController {
    private LightSystem lightSystem;
    private TemperatureController temperatureController;
    private SecuritySystem securitySystem;

    public SmartHomeController() {
        lightSystem = new LightSystem();
        temperatureController = new TemperatureController();
        securitySystem = new SecuritySystem();
    }

    public void activateHome() {
        turnOnLightSystem();
        turnOnTemperatureController();
        turnOnSecuritySystem();
    }

    public void deactivateHome() {
        turnOffLightSystem();
        turnOffTemperatureController();
        turnOffSecuritySystem();
    }

    public void displaySmartHomeDetails() {
        lightSystem.displayLightDetails();
        temperatureController.displayTemperatureDetails();
        securitySystem.displaySystemStatus();
    }


    
    public void turnOnLightSystem() {
        lightSystem.turnOn();
    }

    public void turnOffLightSystem() {
        lightSystem.turnOff();
    }

    public void setLightBrightness(int brightnessPercentage) {
        lightSystem.setBrightness(brightnessPercentage);
    }

    public void setLightColor(int lightColor) {
        lightSystem.setLightColor(lightColor);
    }

    public void displayLightDetails() {
        lightSystem.displayLightDetails();
    }

    public boolean isLightSystemOn() {
        return lightSystem.isOn();
    }

    public int getLightBrightness() {
        return lightSystem.getBrightness();
    }

    public int getLightColor() {
        return lightSystem.getColorTemperature();
    }


    public void turnOnTemperatureController() {
        temperatureController.turnOn();
    }

    public void turnOffTemperatureController() {
        temperatureController.turnOff();
    }

    public void setTemperature(int temperature) {
        temperatureController.setTemperature(temperature);
    }

    public void displayTemperatureDetails() {
        temperatureController.displayTemperatureDetails();
    }

    public boolean isTemperatureControllerOn() {
        return temperatureController.isOn();
    }

    public int getTemperature() {
        return temperatureController.getTemperature();
    }



    public void turnOnSecuritySystem() {
        securitySystem.armSystem();
    }

    public void turnOffSecuritySystem() {
        securitySystem.disarmSystem();
    }   

    public void triggerSecurityAlert(String reason) {
        securitySystem.triggerAlert(reason);
    }

    public void clearSecurityAlert() {
        securitySystem.clearAlert();
    }

    public void displaySecuritySystemStatus() {
        securitySystem.displaySystemStatus();
    }

    public boolean isSecuritySystemOn() {
        return securitySystem.isArmed();
    }
}
