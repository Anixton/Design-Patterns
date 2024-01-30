public class circle implements shape{

    private double radius;
    private final double PI = Math.PI;

    public circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        double area = PI * radius * radius;
        return area;
    }

    @Override
    public double getPerimeter() {
        double perimeter = 2 * PI * radius;
        return perimeter;
    }
    
    @Override
    public void display() {
        System.out.println("Circle Area: " + getArea());
        System.out.println("Circle Perimeter: " + getPerimeter());
    }

}
