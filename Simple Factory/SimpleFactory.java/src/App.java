import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        ShapeFactory[] shapeFactoryArray = new ShapeFactory[10];
        String[] shapeList = {"triangle", "circle", "rectangle", "square"};
        Random random = new Random();
        
        for (int i = 0; i < shapeFactoryArray.length; i++) {
            shapeFactoryArray[i] = new ShapeFactory();
            shapeFactoryArray[i].getShape(shapeList[random.nextInt(4)]).display();
        }
    }
}
