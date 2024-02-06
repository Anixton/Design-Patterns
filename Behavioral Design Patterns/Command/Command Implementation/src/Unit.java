// Receiver
import java.util.Stack;

public class Unit {
    private Position position;
    Stack<Position> positionHistory = new Stack<>();

    public void move(Position newPosition) {
        position = newPosition;
        System.out.println("Unit moved to " + newPosition);
    }

    public void moveBack() {
        System.out.println("Unit moved back to previous position");
        position = positionHistory.pop();
    }
}