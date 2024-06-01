package com.example;

public class ColorDrawingStrategy implements DrawingStrategy {
    @Override
    public void draw(Shape shape) {
        System.out.println("Drawing shape in color: " + shape);
    }

    @Override
    public ColorDrawingStrategy clone() {
        return new ColorDrawingStrategy();
    }
}
