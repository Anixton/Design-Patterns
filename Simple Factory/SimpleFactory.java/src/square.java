public class square implements shape{
    double length;

    square(double length) {
        this.length = length;
    }

    @Override
    public double getArea() {
        return length * length;
    }

    @Override
    public double getPerimeter() {
        return 4 * length;
    }

    @Override
    public void display() {
        System.out.println("Square Area: " + getArea());
        System.out.println("Square Perimeter: " + getPerimeter());
    }
}
