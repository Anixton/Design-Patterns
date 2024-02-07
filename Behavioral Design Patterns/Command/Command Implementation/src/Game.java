import java.util.Stack;

public class Game {
    private Unit unit;

    public Game() {
        unit = new Unit();
    }

    public void loadGame(Stack<Position> positionHistory, Stack<Position> positionFuture, 
                        Position currentPosition) {
        unit.loadGame(currentPosition, positionHistory, positionFuture);
    }

    public Position getPosition() {
        return unit.getPosition();
    }

    public Unit getUnit() {
        return unit;
    }

    public Stack<Position> getPositionHistory() {
        return unit.getPositionHistory();
    }

    public Stack<Position> getPositionFuture() {
        return unit.getPositionFuture();
    }

    public void executeCommand(Command command) {
        command.execute();
    }

    // public void undoLastCommand() {
    //     unit.moveBack();   
    //     this.displayPosition(); 
    // }

    // public void redoLastCommand() {
    //     unit.moveForward();
    //     this.displayPosition();
    // }

    public void displayPosition() {
        System.err.println(unit.getPosition().toString());
    }

    public void displayReplay() {
        unit.replay();
    }
}
