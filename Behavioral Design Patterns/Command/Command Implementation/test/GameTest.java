import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class GameTest {
    @Test
    public void testConstructor() {
        Game game = new Game();
        assertNotNull(game.getUnit());
    }

    @Test
    public void testGetPosition() {
        Game game = new Game();
        assertEquals(new Position(0, 0), game.getPosition());
    }

    @Test
    public void testDisplayPosition() {
        Game game = new Game();
        String expected = "Position{x=0, y=0}\r\n";
        
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        game.displayPosition();
        assertEquals(expected, outContent.toString());
    }

    @Test  
    public void testExecuteCommand() {
        Game game = new Game();
        game.executeCommand(new MoveUnitCommand(game.getUnit(), new Position(1, 1)));
        game.executeCommand(new MoveUnitCommand(game.getUnit(), new Position(2, 2)));
        game.executeCommand(new MoveUnitCommand(game.getUnit(), new Position(3, 3)));
        
        assertEquals(new Position(3, 3), game.getPosition());
    } 
    
    @Test
    public void testUndoLastCommand() {
        Game game = new Game();
        game.executeCommand(new MoveUnitCommand(game.getUnit(), new Position(1, 1)));
        game.executeCommand(new MoveUnitCommand(game.getUnit(), new Position(2, 2)));
        game.executeCommand(new MoveUnitCommand(game.getUnit(), new Position(3, 3)));
        
        game.undoLastCommand();
        assertEquals(new Position(2, 2), game.getPosition());
    }

    @Test
    public void testRedoLastCommand() {
        Game game = new Game();
        game.executeCommand(new MoveUnitCommand(game.getUnit(), new Position(1, 1)));
        game.executeCommand(new MoveUnitCommand(game.getUnit(), new Position(2, 2)));
        game.executeCommand(new MoveUnitCommand(game.getUnit(), new Position(3, 3)));
        
        game.undoLastCommand();
        game.redoLastCommand();
        assertEquals(new Position(3, 3), game.getPosition());
    }

    @Test
    public void testLoadGame() {
        Game game = new Game();
        game.executeCommand(new MoveUnitCommand(game.getUnit(), new Position(1, 1)));
        game.executeCommand(new MoveUnitCommand(game.getUnit(), new Position(2, 2)));
        game.executeCommand(new MoveUnitCommand(game.getUnit(), new Position(3, 3)));
        
        Game game2 = new Game();
        game2.loadGame(game.getPositionHistory(), game.getPositionFuture(), game.getPosition());
        
        assertEquals(game.getPosition(), game2.getPosition());
        assertEquals(game.getPositionHistory(), game2.getPositionHistory());
        assertEquals(game.getPositionFuture(), game2.getPositionFuture());
    }

    @Test
    public void testDisplayReplay() {
        Game game = new Game();
        game.executeCommand(new MoveUnitCommand(game.getUnit(), new Position(1, 1)));
        game.executeCommand(new MoveUnitCommand(game.getUnit(), new Position(2, 2)));
        game.executeCommand(new MoveUnitCommand(game.getUnit(), new Position(3, 3)));
        
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        game.displayReplay();
        
        String expectedOutput = "Replaying moves\r\n" +
                                "Position{x=0, y=0}\r\n" +
                                "Position{x=1, y=1}\r\n" +
                                "Position{x=2, y=2}\r\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}
