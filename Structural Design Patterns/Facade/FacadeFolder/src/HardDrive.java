// Define the HardDrive class
public class HardDrive {
    // Instance variables to represent HardDrive characteristics
    private String brand;
    private int capacityGB;
    private String type;

    // Constructor to initialize HardDrive with brand, capacity in GB, and type (e.g., SSD, HDD)
    public HardDrive(String brand, int capacityGB, String type) {
        this.brand = brand;
        this.capacityGB = capacityGB;
        this.type = type;
    }

    // Method to display HardDrive information
    public void displayInfo() {
        System.out.println("HardDrive Brand: " + brand);
        System.out.println("Capacity: " + capacityGB + " GB");
        System.out.println("Type: " + type);
    }
}
