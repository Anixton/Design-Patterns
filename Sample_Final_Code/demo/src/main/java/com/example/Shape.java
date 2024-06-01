package com.example;

public abstract class Shape implements Cloneable {
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

    @Override
    public Shape clone() {
        try {
            Shape cloned = (Shape) super.clone();
            if (strategy != null) {
                cloned.strategy = (DrawingStrategy) strategy.clone();
            }
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
