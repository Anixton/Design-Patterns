package com.example;

public interface DrawingStrategy extends Cloneable {
    public void draw(Shape shape);

    public DrawingStrategy clone();
}
