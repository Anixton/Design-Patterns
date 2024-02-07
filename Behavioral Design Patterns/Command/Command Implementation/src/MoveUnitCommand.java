// Concrete Command

public class MoveUnitCommand implements Command {
    private Unit unit;
    private Position destination;

    public MoveUnitCommand(Unit unit, Position destination) {
        this.unit = unit;
        this.destination = destination;
    }

    public void execute() {
        unit.move(destination);
    }

    public void undo() {
        unit.moveBack();
    }

    public void redo() {
        unit.moveForward();
    }

    public Position getDestination() {
        return destination;
    }

    public Unit getUnit() {
        return unit;
    }
}
