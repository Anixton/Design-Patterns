 /**
 * The {@code SecuritySystem} class represents a simple security system. securitySystem objects in
 * SmartHomeController classes are implemented as instances of this class.
 * <p>
 * It has three private fields: {@code isArmed}, {@code isAlert}, and {@code alertMessage}.
 * 
 * <p> The {@code SecuritySystem} class has three private fields: {@code isArmed}, {@code isAlert}, {@code alertMessage}.
 * Their default values :
 * <blockquote><pre>
 *      isArmed = false;
 *isAlert = false;
 *alertMessage = "";
 * </pre></blockquote><p>
 * 
 * 
 * <p>The {@code SecuritySystem} class provides methods to arm and disarm the security system,
 * trigger and clear alerts, and display the system status. The class also includes getter methods
 * to retrieve the current state of the security system.
 *
 * @author  Hakan Gezginci
 * @see     SmartHomeApp
 * @since   1.0
 */
public class SecuritySystem {
    private boolean isArmed;

    private boolean isAlert;

    private String alertMessage;

    public SecuritySystem() {
        isArmed = false;
        isAlert = false;
        alertMessage = "";
    }

    public void armSystem() {
        if (!isArmed) {
            isArmed = true;
            alertMessage = "Security system is armed";
            System.out.println(alertMessage);
        } else {
            alertMessage = "Security system is already armed";
            System.out.println(alertMessage);
        }
    }

    public void disarmSystem() {
        if (isArmed) {
            isArmed = false;
            isAlert = false;
            alertMessage = "";
            System.out.println("Security system is disarmed");
        } else {
            System.out.println("Security system is already disarmed");
        }
    }

    /**
     * If the system is armed, it triggers an alert with the given reason.<br>
     * @param reason The reason for triggering the alert.
     */
    public void triggerAlert(String reason) {
        if (isArmed) {
            isAlert = true;
            alertMessage = "Alert triggered: " + reason;
            System.out.println(alertMessage);
        }
    }

    public void clearAlert() {
        if (isAlert) {
            isAlert = false;
            alertMessage = "";
            System.out.println("Security alert cleared");
        } else {
            System.out.println("No security alert to clear");
        }
    }

    public void displaySystemStatus() {
        System.out.println("Security system is " + (isArmed ? "armed" : "disarmed"));
        if (isAlert) {
            System.out.println("Security alert: " + alertMessage);
        }
    }

    public boolean isArmed() {
        return isArmed;
    }

    public boolean isAlert() {
        return isAlert;
    }

    public String getAlertMessage() {
        return alertMessage;
    }
}
