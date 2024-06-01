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

    @Override
    public CompositeShape clone() {
        CompositeShape clonedShape = new CompositeShape();
        for (Shape shape : shapes) {
            clonedShape.addShape(shape.clone());
        }
        return clonedShape;
    }
}
