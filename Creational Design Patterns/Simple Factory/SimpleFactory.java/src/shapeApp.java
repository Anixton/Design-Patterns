import java.util.Random;

/*
 * This program is a demonstration of the simple factory design pattern.
 * It generates 10 random shapes and displays their details.
 * The ShapeFactory class can create four types of shapes: triangle, circle, rectangle, and square.
 * Each of these shapes implements the Shape interface, ensuring a consistent API for all shapes.
 * The ShapeFactory class is responsible for the creation of the shapes, abstracting the instantiation process.
 * This makes the program more flexible and easier to manage, as new types of shapes can be added with minimal changes to the existing code.
 */
public class shapeApp {
    public static void main(String[] args) throws Exception {
        final int AMOUNT = 10;
        ShapeFactory shapeFactory = new ShapeFactory();
        String[] shapeList = {"triangle", "circle", "rectangle", "square"};
        Random random = new Random();
        
        
        for (int i = 0; i < AMOUNT; i++) {
            shapeFactory.getShape(shapeList[random.nextInt(4)]).display();
        }
    }
}
