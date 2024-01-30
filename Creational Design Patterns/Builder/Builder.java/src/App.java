public class App {
    public static void main(String[] args) throws Exception {
        CarDirector director = new CarDirector();
        CarBuilder sportsCarBuilder = new SportsCarBuilder();

        director.construct(sportsCarBuilder);
        Car sportsCar = sportsCarBuilder.getCar();
        
        System.out.println("Constructed Sports Car: " + sportsCar.toString());

        CarBuilder SUVBuilder = new SUVBuilder();
        
        director.construct(SUVBuilder);
        Car SUV = SUVBuilder.getCar();

        System.out.println("Constructed SUV: " + SUV.toString());
    }
}
