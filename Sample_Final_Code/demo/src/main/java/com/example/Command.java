package com.example;

public interface Command extends Cloneable {
    public void execute();

    public void undo();

    public Command clone();
}
