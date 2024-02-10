public  class CarFactory implements VehicleFactory{
    
    @Override
    public Vehicle createVehicle() {
        Car car = new Car("Red", "Ferrari Laferrari Aperta", 349, 1585, 1.1, true, true, true, true, true);
        return car;
    }

}
