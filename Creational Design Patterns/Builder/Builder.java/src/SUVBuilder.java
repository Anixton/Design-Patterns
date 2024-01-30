public class SUVBuilder implements CarBuilder{
    
    private Car SUVCar;

    public void buildModel() {
        SUVCar = new Car();
        SUVCar.setModel("Lamborghini Urus");
    }

    public void buildColor() {
        SUVCar.setColor("Yellow");
    }

    public void buildYear() {
        SUVCar.setYear(2022);
    }

    public void buildFuelType() {
        SUVCar.setFuelType("Hybrid");
    }

    public Car getCar() {
        return this.SUVCar;
    }
}
