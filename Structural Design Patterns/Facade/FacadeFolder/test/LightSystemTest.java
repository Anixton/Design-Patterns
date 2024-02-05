import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class LightSystemTest {
    @Test
    public void testDefaultValues() {
        LightSystem lightSystem = new LightSystem();
        assertFalse("Light System should be turned off by default", lightSystem.isOn());
        assertEquals("Default brightness should be 50", 50, lightSystem.getBrightness());
        assertEquals("Default color temperature should be 3500", 3500, lightSystem.getColorTemperature());
    }

    @Test
    public void testLightSystem() {
        LightSystem lightSystem = new LightSystem();
        lightSystem.turnOn();

        assertTrue("Light System should be turned on", lightSystem.isOn());
    }

    @Test
    public void testLightSystemOff() {
        LightSystem lightSystem = new LightSystem();
        lightSystem.turnOn();
        lightSystem.turnOff();    

        assertFalse("Light System should be turned off", lightSystem.isOn());
    }

    @Test
    public void testSetBrightness() {
        LightSystem lightSystem = new LightSystem();
        lightSystem.turnOn();
        lightSystem.setBrightness(50);

        assertEquals("Brightness should be 50", 50, lightSystem.getBrightness());
    }

    @Test
    public void testLowerLimitBrightness() {
        LightSystem lightSystem = new LightSystem();
        lightSystem.turnOn();
        lightSystem.setBrightness(-50);

        assertEquals("Brightness should be 0", 0, lightSystem.getBrightness());
    }

    @Test
    public void testHigherLimitBrightness() {
        LightSystem lightSystem = new LightSystem();
        lightSystem.turnOn();
        lightSystem.setBrightness(150);

        assertEquals("Brightness should be 100", 100, lightSystem.getBrightness());
    }

    @Test
    public void testSetBrightnessWhenOff() {
        LightSystem lightSystem = new LightSystem();
        lightSystem.turnOn();
        lightSystem.setBrightness(75);
        lightSystem.setLightColor(4000);
        lightSystem.turnOff();
        lightSystem.setBrightness(50);
        lightSystem.setLightColor(3000);

        assertEquals("Brightness should be 75", 75, lightSystem.getBrightness());
        assertEquals("Color should be 4000", 4000, lightSystem.getColorTemperature());
    }

    @Test
    public void testSetColor() {
        LightSystem lightSystem = new LightSystem();
        lightSystem.turnOn();
        lightSystem.setLightColor(4000);

        assertEquals("Color should be 4000", 4000, lightSystem.getColorTemperature());
    }

    @Test
    public void testLowerLimitColor() {
        LightSystem lightSystem = new LightSystem();
        lightSystem.turnOn();
        lightSystem.setLightColor(1500);

        assertEquals("Color should be 2700", 2700, lightSystem.getColorTemperature());
    }

    @Test
    public void testHigherLimitColor() {
        LightSystem lightSystem = new LightSystem();
        lightSystem.turnOn();
        lightSystem.setLightColor(6500);

        assertEquals("Color should be 5000", 5000, lightSystem.getColorTemperature());
    }

    @Test
    public void testSetColorWhenOff() {
        LightSystem lightSystem = new LightSystem();
        lightSystem.turnOn();
        lightSystem.setLightColor(4000);
        lightSystem.turnOff();
        lightSystem.setLightColor(3000);

        assertEquals("Color should be 4000", 4000, lightSystem.getColorTemperature());
    }

    @Test
    public void testWarmTemperature() {
        LightSystem lightSystem = new LightSystem();
        lightSystem.turnOn();
        lightSystem.setLightColor(3000);

        assertEquals("Temperature should be called warm", "Warm", lightSystem.getColorTemperatureDetails());
    }

    @Test
    public void testNeutralTemperature() {
        LightSystem lightSystem = new LightSystem();
        lightSystem.turnOn();
        lightSystem.setLightColor(4000);

        assertEquals("Temperature should be called neutral", "Neutral", lightSystem.getColorTemperatureDetails());
    }

    @Test
    public void testCoolLightDetails() {
        LightSystem lightSystem = new LightSystem();
        lightSystem.turnOn();
        lightSystem.setLightColor(5000);
        
        assertEquals("Temperature should be called cool", "Cool", lightSystem.getColorTemperatureDetails());
    }

    @Test
    public void testDisplayLightDetails() {
        LightSystem lightSystem = new LightSystem();
        lightSystem.turnOn();
        lightSystem.setBrightness(75);
        lightSystem.setLightColor(4000);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        lightSystem.displayLightDetails();
        System.setOut(System.out);

        String expectedOutput = "Light system is on\r\n" +
                                "Brightness: 75\r\n" +
                                "Color temperature: Neutral";

                                
        assertEquals("Incorrect output for displayLightDetails", expectedOutput, outputStream.toString().trim());
    }
}
