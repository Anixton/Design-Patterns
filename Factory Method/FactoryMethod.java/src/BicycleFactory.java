public class BicycleFactory implements VehicleFactory{
    
    @Override
    public Vehicle createVehicle(){
        Bicycle bicycle = new Bicycle("Red", "BMX", 30, true, true, true, false);
        return bicycle;
    }
}
