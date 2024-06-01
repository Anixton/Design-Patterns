package com.example;

public class DrawCommand implements Command {
    private Shape shape;

    public DrawCommand(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void execute() {
        shape.draw();
    }

    @Override
    public void undo() {
        shape.undraw();
    }

    @Override
    public DrawCommand clone() {
        DrawCommand clonedCommand = DrawCommand(shape);
        clonedCommand.shape = shape.clone();
        return clonedCommand;
    }
}
