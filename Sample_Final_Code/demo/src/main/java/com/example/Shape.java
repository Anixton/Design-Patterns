package com.example;

public abstract class Shape {
    protected DrawingStrategy strategy;

    public void setDrawingStrategy(DrawingStrategy strategy) {
        this.strategy = strategy;
    }

    public void draw() {
        prepareDrawing();
        strategy.draw(this);
        finalizeDrawing();
    }

    protected void prepareDrawing() {
        System.out.println("Preparing to draw shape");
    }

    protected abstract void doDraw();

    protected void finalizeDrawing() {
        System.out.println("Finalizing drawing of shape");
    }

    public void undraw() {
        System.out.println("Erasing shape: " + this);
    }

}
