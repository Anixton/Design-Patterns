public class CarDirector {
    void construct(CarBuilder carBuilder) {
        carBuilder.buildModel();
        carBuilder.buildColor();
        carBuilder.buildYear();
        carBuilder.buildFuelType();
    }
}
