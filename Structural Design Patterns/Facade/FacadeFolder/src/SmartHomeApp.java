//*******************************************************************************************
//*  Hakan Gezginci
//* 
//*  This application demonstrates the Facade design pattern, which provides a simplified
//*  interface to a complex system of classes, libraries, or APIs. The primary components
//*  of the application include a facade class (SmartHomeController) and a client class
//*  (SmartHomeApp). The SmartHomeController class acts as a facade, providing a unified
//*  interface to the various subsystems of a smart home, such as security, lighting, and
//*  climate control. The SmartHomeApp class serves as the client code, demonstrating the
//*  usage of the facade to interact with the smart home system.
//*******************************************************************************************

/**
* 
*  Smart Home Application
* 
*  The SmartHomeController class acts as a facade, providing a simplified interface to the
*  complex subsystems of a smart home, including security, lighting, and climate control.
*  The facade encapsulates the interactions with the individual subsystems, allowing the
*  client code to access the smart home functionalities through a single interface.
*
*  The SmartHomeApp class serves as the client code, demonstrating the usage of the facade
*  to interact with the smart home system. The application showcases the ability to activate
*  and deactivate the smart home, set the brightness and color of the lights, and display
*  the details of the smart home system.
*   
*  The facade pattern provides a convenient and simplified interface for the client code,
*  allowing the smart home functionalities to be accessed without the need to understand
*  the complexities of the underlying subsystems. This promotes ease of use and reduces
*  the dependencies between the client code and the subsystems, resulting in a more
*  maintainable and scalable system.
*
*  Components:
*  - Facade: SmartHomeController
*  - Client Code: SmartHomeApp
*  - Subsystems: SecuritySystem, LightingSystem, ClimateControlSystem
*  - Tests: SmartHomeControllerTest, TemperatureControllerTest, SecuritySystemTest, LightSystemTest
*  
*  The application demonstrates the benefits of using the facade pattern to provide a
*  simplified interface to a complex system, promoting ease of use and reducing the
*  dependencies between the client code and the subsystems. The facade pattern also
*  enhances the maintainability and scalability of the smart home system.
*/



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
