public class SportsCarBuilder implements CarBuilder {
    private Car SportsCar;

    public void buildModel() {
        SportsCar = new Car();
        SportsCar.setModel("Ferrari 458 Italia");
    }

    public void buildColor() {
        SportsCar.setColor("Red");
    }

    public void buildYear() {
        SportsCar.setYear(2012);
    }

    public void buildFuelType() {
        SportsCar.setFuelType("Gasoline");
    }

    public Car getCar() {
        return this.SportsCar;
    }

}
