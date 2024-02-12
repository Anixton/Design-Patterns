// Define the CPU class
public class CPU {
    // Instance variables to represent CPU characteristics
    private String brand;
    private int cores;
    private double clockSpeed;

    // Constructor to initialize CPU with brand, number of cores, and clock speed
    public CPU(String brand, int cores, double clockSpeed) {
        this.brand = brand;
        this.cores = cores;
        this.clockSpeed = clockSpeed;
    }

    // Method to display CPU information
    public void displayInfo() {
        System.out.println("CPU Brand: " + brand);
        System.out.println("Number of Cores: " + cores);
        System.out.println("Clock Speed: " + clockSpeed + " GHz");
    }
}
