public class MotorcycleFactory implements VehicleFactory{
    
    @Override
    public Vehicle createVehicle(){
        Motorcycle motorcycle = new Motorcycle("Red", "Ducati Panigale V4", 299, 214, 1.1, true, true, true, true, true);
        return motorcycle; 
    }
}
