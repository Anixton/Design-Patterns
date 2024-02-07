// Receiver

import java.util.Stack;

public class Unit {
    private Position position;
    private Stack<Position> positionHistory;
    private Stack<Position> positionFuture;

    private Stack<Position> deepCopyStack(Stack<Position> original) {
        Stack<Position> copy = new Stack<>();
        for (Position position : original) {
            copy.push(new Position(position.getX(), position.getY()));
        }
        return copy;
    }

    private Stack<Position> reverseStack(Stack<Position> original) {
        Stack<Position> reversedStack = new Stack<>();
        while (!original.isEmpty()) {
            reversedStack.push(original.pop());
        }
        return reversedStack;
    }

    public Unit() {
        positionHistory = new Stack<>();
        positionFuture = new Stack<>();
        position = new Position(0, 0);
    }  
    
    public Unit(Position position) {
        this.position = position;
        positionHistory = new Stack<>();
        positionFuture = new Stack<>();
    }

    public void move(Position newPosition) {
        positionHistory.push(position);
        position = newPosition;
        System.out.println("Unit moved to " + newPosition);
    }

    public void moveBack() {
        positionFuture.push(position);
        position = positionHistory.pop();
        System.out.println("Unit moved back to previous position");
    }

    public void moveForward() {
        positionHistory.push(position);
        position = positionFuture.pop();
        System.out.println("Unit moved forward to next position");
    }

    public Position getPosition() {
        return position;
    }

    public Stack<Position> getPositionHistory() {
        return positionHistory;
    }

    public Stack<Position> getPositionFuture() {
        return positionFuture;
    }

    public void loadGame(Position position, Stack<Position> positionHistory, Stack<Position> positionFuture) {
        this.position = new Position(position.getX(), position.getY());
        this.positionHistory = deepCopyStack(positionHistory);
        this.positionFuture = deepCopyStack(positionFuture);
    }

    public void replay() {
        System.out.println("Replaying moves");
        Stack<Position> moveList = deepCopyStack(positionHistory);
        moveList = reverseStack(moveList);

        while (!moveList.isEmpty()) {
            System.out.println(moveList.pop().toString());
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        
        Unit unit = (Unit) obj;
        return position.equals(unit.position) && positionHistory.equals(unit.positionHistory) && positionFuture.equals(unit.positionFuture);
    }
}