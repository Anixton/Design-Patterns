package com.example;

import java.util.*;

public class CompositeShape extends Shape {
    private List<Shape> shapes = new ArrayList<>();

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    @Override
    protected void doDraw() {
        for (Shape shape : shapes) {
            shape.draw();
        }
    }
}
