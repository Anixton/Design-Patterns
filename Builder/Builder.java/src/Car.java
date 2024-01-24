public class Car {

    private String model;
    private String color;
    private int year;
    private String fuelType;

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getModel() {
        return this.model;
    }

    public String getColor() {
        return this.color;
    }

    public int getYear() {
        return this.year;
    }

    public String getFuelType() {
        return this.fuelType;
    }

    @Override
    public String toString() {
        return "Car [model = " + model + ", year = " + year +
            ", color = " + color + ", fuelType = " + fuelType + "]";
    }

}
