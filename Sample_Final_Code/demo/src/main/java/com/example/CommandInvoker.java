package com.example;

import java.util.Stack;

public class CommandInvoker implements Cloneable {
    private Stack<Command> commandStack = new Stack<>();

    public void executeCommand(Command command) {
        command.execute();
        commandStack.push(command);
    }

    public void undo() {
        if (!commandStack.isEmpty()) {
            Command command = commandStack.pop();
            command.undo();
        }
    }

    @Override
    public CommandInvoker clone() {
        CommandInvoker clonedInvoker = new CommandInvoker();
        for (Command command : commandStack) {
            clonedInvoker.commandStack.push(command.clone());
        }
        return clonedInvoker;
    }
}
