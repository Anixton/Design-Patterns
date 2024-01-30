public class ShapeFactory {
    shape shape;

    public shape getShape(String shapeType) {
        
        switch (shapeType) {
            case "triangle":
                shape = new triangle(3, 4, 5);
                break;
            case "circle":
                shape = new circle(5);
                break;
            case "rectangle":
                shape = new rectangle(3, 4);
                break;
            case "square":
                shape = new square(5);
                break;
            default:
                break;
        }
        return shape;
    }
}
