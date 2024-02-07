import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Stack;

public class MoveUnitCommandTest {
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
        game.undoLastCommand();
        game.redoLastCommand();

        assertEquals(secondPosition, unit.getPosition());
    }

    @Test
    public void testDisplayPosition() {
        Game game = new Game();
        Unit unit = game.getUnit();
        Position expectedPosition = new Position(13, 14);
        Command moveUnitCommand = new MoveUnitCommand(unit, expectedPosition);
        game.executeCommand(moveUnitCommand);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        game.displayPosition();
        assertEquals(expectedPosition.toString() + "\n", outContent.toString());
    }

    @Test
    public void testDisplayReplay() {
        Game game = new Game();
        Unit unit = game.getUnit();
        Position firstPosition = new Position(13, 14);
        Position secondPosition = new Position(15, 16);
        Position thirdPosition = new Position(17, 18);
        Position fourthPosition = new Position(19, 20);
        Command moveUnitCommand = new MoveUnitCommand(unit, firstPosition);
        game.executeCommand(moveUnitCommand);
        moveUnitCommand = new MoveUnitCommand(unit, secondPosition);
        game.executeCommand(moveUnitCommand);
        moveUnitCommand = new MoveUnitCommand(unit, thirdPosition);
        game.executeCommand(moveUnitCommand);
        moveUnitCommand = new MoveUnitCommand(unit, fourthPosition);
        game.executeCommand(moveUnitCommand);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        game.displayReplay();
        assertEquals("Replaying moves\n" + fourthPosition.toString() + "\n" + thirdPosition.toString() + "\n" + secondPosition.toString() + "\n" + firstPosition.toString() + "\n", outContent.toString());
    }


    
}
