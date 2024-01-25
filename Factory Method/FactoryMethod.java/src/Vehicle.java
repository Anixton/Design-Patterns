public abstract class Vehicle {

    private String color;
    private String model;
    private int maxSpeed;
    private double weight;
    private double height;

    public void setVehicleAttributes(String color, String model, int maxSpeed) {
        this.color = color;
        this.model = model;
        this.maxSpeed = maxSpeed;
    }
    
    public void setVehicleAttributes(String color, String model, int maxSpeed, double weight, double height) {
        this.color = color;
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.weight = weight;
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    public String getModel() {
        return model;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }
    
    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    abstract double calculateSafetyRating();
    abstract void safetyInformation();
}
