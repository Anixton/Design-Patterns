public  class rectangle implements shape{
    private double length;
    private double width;

    public rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double getArea() {
        return length * width;
    }

    @Override
    public double getPerimeter() {
        return 2 * (length + width);
    }

    @Override
    public void display() {
        System.out.println("Rectangle Area: " + getArea());
        System.out.println("Rectangle Perimeter: " + getPerimeter());
    }
}
