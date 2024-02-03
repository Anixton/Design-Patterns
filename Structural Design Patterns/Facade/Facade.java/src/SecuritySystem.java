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
}
