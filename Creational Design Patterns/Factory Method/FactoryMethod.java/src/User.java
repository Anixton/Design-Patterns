import java.util.Scanner;

public class User {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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
                System.out.println("Invalid choice");
                System.exit(0);
        }

        if (vehicleFactory != null) {
            Vehicle vehicleToResearchSafety = vehicleFactory.createVehicle();
            System.out.println("\nVehicle Safety Score:");
            System.out.println("Score: " + vehicleToResearchSafety.calculateSafetyRating());
        }
    }
}