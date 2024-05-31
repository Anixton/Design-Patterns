/**
* Creates a new Vehicle object.
* Additional logic can be implemented in the concrete factories to customize the creation process.
* @return A new Vehicle object.
*/
public interface VehicleFactory {
    Vehicle createVehicle();
}
