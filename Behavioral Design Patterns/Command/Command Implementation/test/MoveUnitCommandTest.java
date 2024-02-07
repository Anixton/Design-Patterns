import org.junit.Test;
import static org.junit.Assert.*;


public class MoveUnitCommandTest {
    @Test
    public void testConstructor() {
        Unit unit = new Unit();
        Position expectedPosition = new Position(13, 14);
        MoveUnitCommand moveUnitCommand = new MoveUnitCommand(unit, expectedPosition);

        assertTrue(unit.equals(moveUnitCommand.getUnit()));
        assertEquals(expectedPosition, moveUnitCommand.getDestination());
    }

    @Test
    public void testExecute() {
        Game game = new Game();
        Unit unit = game.getUnit();
        Position expectedPosition = new Position(13, 14);
        Command moveUnitCommand = new MoveUnitCommand(unit, expectedPosition);
        game.executeCommand(moveUnitCommand);

        assertEquals(expectedPosition, unit.getPosition());
    }

    @Test
    public void testUndo() {
        Game game = new Game();
        Unit unit = game.getUnit();
        Position firstPosition = new Position(13, 14);
        Position secondPosition = new Position(15, 16);
        Command moveUnitCommand = new MoveUnitCommand(unit, firstPosition);

        game.executeCommand(moveUnitCommand);
        moveUnitCommand = new MoveUnitCommand(unit, secondPosition);
        game.executeCommand(moveUnitCommand);
        moveUnitCommand.undo();

        assertEquals(firstPosition, unit.getPosition());
    }

    @Test
    public void testRedo() {
        Game game = new Game();
        Unit unit = game.getUnit();
        Position firstPosition = new Position(13, 14);
        Position secondPosition = new Position(15, 16);
        Command moveUnitCommand = new MoveUnitCommand(unit, firstPosition);

        game.executeCommand(moveUnitCommand);
        moveUnitCommand = new MoveUnitCommand(unit, secondPosition);
        game.executeCommand(moveUnitCommand);
        moveUnitCommand.undo();
        moveUnitCommand.redo();

        assertEquals(secondPosition, unit.getPosition());
    }
}
