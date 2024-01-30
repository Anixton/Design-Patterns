public class triangle implements shape{
    private double firstSide;
    private double secondSide;
    private double thirdSide;

    private void validateTriangle(double first, double second, double third) {
        if (first + second <= third || first + third <= second || second + third <= first) {
            throw new IllegalArgumentException("Invalid Triangle Lengths");
        }
    }

    public triangle(double firstSide, double secondSide, double thirdSide) {
        validateTriangle(firstSide, secondSide, thirdSide);
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.thirdSide = thirdSide;
    }

    @Override
    public double getArea() {
        double semiPerimeter = (firstSide + secondSide + thirdSide) / 2;
        double area = Math.sqrt(semiPerimeter * (semiPerimeter - firstSide) * 
                               (semiPerimeter - secondSide) * (semiPerimeter - thirdSide));
        return area;
    }

    @Override
    public double getPerimeter() {
        return (firstSide + secondSide + thirdSide);
    }
    
    @Override
    public void display() {
        System.out.println("Triangle Area: " + getArea());
        System.out.println("Triangle Perimeter: " + getPerimeter());
    }
}
