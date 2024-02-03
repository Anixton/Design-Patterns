// Hakan Gezginci

// This package contains the implementation of a Smart Home application.
// The main class in this package is SmartHomeApp, which serves as the entry point of the application.

// SmartHomeController is a class that controls the smart home devices and provides a simplified interface for the application.
// It encapsulates the complexity of interacting with various devices and subsystems.

// The design pattern used in this package is the Facade pattern.
// The Facade pattern provides a unified interface to a set of interfaces in a subsystem.
// In this case, the SmartHomeController acts as a facade, providing a simplified interface for controlling the smart home devices.

// Other classes and interfaces in this package are not mentioned in the code snippet.
// They might include classes representing different smart home devices, interfaces for interacting with those devices, and utility classes.



public class SmartHomeApp {
    public static void main(String[] args) throws Exception {
        SmartHomeController smartHomeController = new SmartHomeController();
        smartHomeController.activateHome();
        smartHomeController.displaySmartHomeDetails();
        smartHomeController.setLightBrightness(50);
        smartHomeController.setLightColor(4000);
        smartHomeController.deactivateHome();
    }
}
