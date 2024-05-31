package com.example;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape rectangle = new Rectangle();

        DrawingStrategy colorStrategy = new ColorDrawingStrategy();
        DrawingStrategy patternStrategy = new PatternDrawingStrategy();

        circle.setDrawingStrategy(colorStrategy);
        rectangle.setDrawingStrategy(patternStrategy);

        Command drawCircle = new DrawCommand(circle);
        Command drawRectangle = new DrawCommand(rectangle);

        CommandInvoker invoker = new CommandInvoker();
        invoker.executeCommand(drawCircle);
        invoker.executeCommand(drawRectangle);

        invoker.undo();

        CompositeShape compositeShape = new CompositeShape();
        compositeShape.addShape(circle);
        compositeShape.addShape(rectangle);
        compositeShape.setDrawingStrategy(colorStrategy);

        compositeShape.draw();
    }
}
