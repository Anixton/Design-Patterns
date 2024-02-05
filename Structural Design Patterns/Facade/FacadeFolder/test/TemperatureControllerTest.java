import org.junit.Test;
import static org.junit.Assert.*;

public class TemperatureControllerTest {
    @Test
    public void testTemperatureController() {
        TemperatureController temperatureController = new TemperatureController();
        temperatureController.turnOn();

        assertTrue("Temperature Controller should be turned on", temperatureController.isOn());
    }

    @Test
    public void testTemperatureControllerOff() {
        TemperatureController temperatureController = new TemperatureController();
        temperatureController.turnOn();
        temperatureController.turnOff();    

        assertFalse("Temperature Controller should be turned off", temperatureController.isOn());
    }

    @Test
    public void testSetTemperature() {
        TemperatureController temperatureController = new TemperatureController();
        temperatureController.turnOn();
        temperatureController.setTemperature(25);
        assertEquals("Temperature should be 25", 25, temperatureController.getTemperature());
    }

}
