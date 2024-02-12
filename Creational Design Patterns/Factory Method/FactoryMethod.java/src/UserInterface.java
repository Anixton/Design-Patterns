import java.util.Scanner;

/*
 * The UserInterface class serves as the main entry point for the application. It interacts with the user, providing a menu to select a vehicle type (Car, Motorcycle, or Bicycle).
 * Based on the user's selection, it leverages the Factory Method design pattern to instantiate the appropriate Vehicle object.
 * The VehicleFactory interface is utilized to create specific vehicle objects, encapsulating the instantiation process and allowing for flexibility in the types of vehicles that can be created.
 * Once the vehicle object is created, the application calculates and displays the safety score of the selected vehicle, providing valuable information to the user.
 */
public class UserInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Choose the type of vehicle to see safety levels:");
            System.out.println("1. Car");
            System.out.println("2. Motorcycle");
            System.out.println("3. Bicycle");

            int choice = scanner.nextInt();

            VehicleFactory vehicleFactory = null;

            switch (choice) {
                case 1:
                    vehicleFactory = new CarFactory();
                    break;

                case 2:
                    vehicleFactory = new MotorcycleFactory();
                    break;

                case 3:
                    vehicleFactory = new BicycleFactory();
                    break;

                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
                    break;
            }

            if (vehicleFactory != null) {
                Vehicle vehicleToResearchSafety = vehicleFactory.createVehicle();
                System.out.println("\nVehicle Safety Score:");
                System.out.println("Score: " + vehicleToResearchSafety.calculateSafetyRating());
            }
        } 
        catch (Exception e) {
            System.out.println("Error: Invalid input. Please enter a valid integer.");
        } 
        finally {
            scanner.close();
        }
    }
}
