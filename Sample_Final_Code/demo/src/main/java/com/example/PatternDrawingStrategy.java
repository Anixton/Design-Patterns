package com.example;

public class PatternDrawingStrategy implements DrawingStrategy {
    @Override
    public void draw(Shape shape) {
        System.out.println("Drawing shape with pattern: " + shape);
    }

    @Override
    public PatternDrawingStrategy clone() {
        return new PatternDrawingStrategy();
    }
}
