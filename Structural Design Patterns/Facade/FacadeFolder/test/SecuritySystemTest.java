import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class SecuritySystemTest {
    @Test
    public void testArmSecuritySystem() {
        SecuritySystem securitySystem = new SecuritySystem();
        securitySystem.armSystem();
        
        Assert.assertTrue("Security system should be armed", securitySystem.isArmed());
    }

    @Test
    public void testDisarmSecuritySystem() {
        SecuritySystem securitySystem = new SecuritySystem();
        securitySystem.armSystem();
        securitySystem.disarmSystem();
        
        Assert.assertFalse("Security system should be disarmed", securitySystem.isArmed());
    }

    @Test
    public void testTriggerAlert() {
        SecuritySystem securitySystem = new SecuritySystem();
        securitySystem.armSystem();
        securitySystem.triggerAlert("Intruder detected");
        
        Assert.assertTrue("Security system should be alerted", securitySystem.isAlert());
    }

    @Test
    public void testClearAlert() {
        SecuritySystem securitySystem = new SecuritySystem();
        securitySystem.armSystem();
        securitySystem.triggerAlert("Intruder detected");
        securitySystem.clearAlert();
        
        Assert.assertFalse("Security system should be alerted", securitySystem.isAlert());
    }

    @Test
    public void testArmedDisplaySystemStatus() {
        SecuritySystem securitySystem = new SecuritySystem();
        securitySystem.armSystem();
        securitySystem.triggerAlert("Intruder detected");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        securitySystem.displaySystemStatus();
        System.setOut(System.out);

        String expectedOutput = "Security system is armed\r\n" +
                                "Security alert: Alert triggered: Intruder detected";
                                
        assertEquals("Incorrect output for displayLightDetails", expectedOutput, outputStream.toString().trim());
    }
    
    @Test
    public void testDisarmedDisplaySystemStatus() {
        SecuritySystem securitySystem = new SecuritySystem();
        securitySystem.disarmSystem();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        securitySystem.displaySystemStatus();
        System.setOut(System.out);

        String expectedOutput = "Security system is disarmed";
                                
        assertEquals("Incorrect output for displayLightDetails", expectedOutput, outputStream.toString().trim());
    }
}
