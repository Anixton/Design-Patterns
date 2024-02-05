import org.junit.Test;
import static org.junit.Assert.*;


public class SmartHomeControllerTest {
    @Test
    public void testActivateSmartHome() {
        SmartHomeController smartHomeController = new SmartHomeController();
        smartHomeController.activateHome();

        assertTrue("Lights should be turned on", smartHomeController.isLightSystemOn());
        assertTrue("Temperature Controller should be turned on", smartHomeController.isTemperatureControllerOn());
        assertTrue("Security System should be turned on", smartHomeController.isSecuritySystemOn());
    }

    @Test
    public void testDeactivateSmartHome() {
        SmartHomeController smartHomeController = new SmartHomeController();
        smartHomeController.deactivateHome();
        
        assertFalse("Lights should be turned off", smartHomeController.isLightSystemOn());
        assertFalse("Temperature Controller should be turned off", smartHomeController.isTemperatureControllerOn());
        assertFalse("Security System should be turned off", smartHomeController.isSecuritySystemOn());
    }

    @Test
    public void testSmartHomeLightSystem() {
        SmartHomeController smartHomeController = new SmartHomeController();
        smartHomeController.activateHome();
        smartHomeController.turnOffLightSystem();

        assertFalse("Security System should be turned off", smartHomeController.isLightSystemOn());

        smartHomeController.turnOnLightSystem();
        smartHomeController.setLightBrightness(50);
        smartHomeController.setLightColor(4000);

        assertEquals("Brightness should be 50", 50, smartHomeController.getLightBrightness());
        assertEquals("Color should be 4000", 4000, smartHomeController.getLightColor());
    }

    @Test
    public void testSmartHomeTemperatureController() {
        SmartHomeController smartHomeController = new SmartHomeController();
        smartHomeController.activateHome();
        smartHomeController.turnOffTemperatureController();

        assertFalse("Temperature Controller should be turned off", smartHomeController.isTemperatureControllerOn());

        smartHomeController.turnOnTemperatureController();
        smartHomeController.setTemperature(25);

        assertEquals("Temperature should be 25", 25, smartHomeController.getTemperature());
    }

    @Test
    public void testSmartHomeSecuritySystem() {
        SmartHomeController smartHomeController = new SmartHomeController();
        smartHomeController.activateHome();
        smartHomeController.turnOffSecuritySystem();

        assertFalse("Security System should be turned off", smartHomeController.isSecuritySystemOn());

        smartHomeController.turnOnSecuritySystem();
        
        assertTrue("Security System should be turned on", smartHomeController.isSecuritySystemOn());
    }
}
