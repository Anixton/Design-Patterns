import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Stack; 


public class UnitTest {
    @Test
    public void testDefaultConstructor() {
        Unit unit = new Unit();
        Position expectedPosition = new Position(0, 0);

        assertEquals(expectedPosition, unit.getPosition());
    }

    @Test
    public void testParameterizedConstructor() {
        Position position = new Position(13, 14);
        Unit unit = new Unit(position);

        assertEquals(position, unit.getPosition());
    }
    
    @Test
    public void testMove() {
        Unit unit = new Unit();
        Position newPosition = new Position(13, 14);
        unit.move(newPosition);

        assertEquals(newPosition, unit.getPosition());
    }
    
    @Test
    public void testMoveBack() {
        Unit unit = new Unit();
        Position firstPosition = new Position(13, 14);
        Position secondPosition = new Position(15, 16);

        unit.move(firstPosition);
        unit.move(secondPosition);
        unit.moveBack();

        assertEquals(firstPosition, unit.getPosition());
    }

    @Test
    public void testMoveForward() {
        Unit unit = new Unit();
        Position firstPosition = new Position(13, 14);
        Position secondPosition = new Position(15, 16);

        unit.move(firstPosition);
        unit.move(secondPosition);
        unit.moveBack();
        unit.moveForward();

        assertEquals(secondPosition, unit.getPosition());
    }

    @Test
    public void testPositionHistory() {
        Position firstPosition = new Position(13, 14);
        Position secondPosition = new Position(15, 16);
        Position thirdPosition = new Position(17, 18);
        Position fourthPosition = new Position(19, 20);

        Unit unit = new Unit(firstPosition);
        unit.move(secondPosition);
        unit.move(thirdPosition);
        unit.move(fourthPosition);

        Stack<Position> expectedPositionHistory = new Stack<>();
        expectedPositionHistory.push(firstPosition);
        expectedPositionHistory.push(secondPosition);
        expectedPositionHistory.push(thirdPosition);

        assertEquals(expectedPositionHistory, unit.getPositionHistory());
        assertEquals(fourthPosition, unit.getPosition());
    }

    @Test
    public void testPositionFuture() {
        Position firstPosition = new Position(13, 14);
        Position secondPosition = new Position(15, 16);
        Position thirdPosition = new Position(17, 18);
        Position fourthPosition = new Position(19, 20);

        Unit unit = new Unit(firstPosition);
        unit.move(secondPosition);
        unit.move(thirdPosition);
        unit.move(fourthPosition);
        unit.moveBack();
        unit.moveBack();
        unit.moveBack();    

        Stack<Position> expectedPositionFuture = new Stack<>();
        expectedPositionFuture.push(fourthPosition);
        expectedPositionFuture.push(thirdPosition);
        expectedPositionFuture.push(secondPosition);

        assertEquals(expectedPositionFuture, unit.getPositionFuture());
        assertEquals(firstPosition, unit.getPosition());
    }

    @Test
    public void testLoadGame() {
        Position firstPosition = new Position(13, 14);
        Position secondPosition = new Position(15, 16);
        Position thirdPosition = new Position(17, 18);
        Position fourthPosition = new Position(19, 20);

        Unit unit = new Unit(firstPosition);
        unit.move(secondPosition);
        unit.move(thirdPosition);
        unit.move(fourthPosition);
        
        Unit loadedUnit = new Unit();
        loadedUnit.loadGame(unit.getPosition(), unit.getPositionHistory(), unit.getPositionFuture());

        assertTrue(loadedUnit.getPosition().equals(unit.getPosition()));     
        assertEquals(unit.getPositionHistory(), loadedUnit.getPositionHistory());
        assertEquals(unit.getPositionFuture(), loadedUnit.getPositionFuture());
    }

    @Test
    public void testReplay() {
        Position firstPosition = new Position(13, 14);
        Position secondPosition = new Position(15, 16);
        Position thirdPosition = new Position(17, 18);
        Position fourthPosition = new Position(19, 20);

        Unit unit = new Unit(firstPosition);
        unit.move(secondPosition);
        unit.move(thirdPosition);
        unit.move(fourthPosition);
       
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        unit.replay();   

        String expectedOutput = "Replaying moves\r\n" +
                                "Position{x=13, y=14}\r\n" +
                                "Position{x=15, y=16}\r\n" +
                                "Position{x=17, y=18}\r\n";
                                
        assertEquals(expectedOutput, outContent.toString());
    }
}
