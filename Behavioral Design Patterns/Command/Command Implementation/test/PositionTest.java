import org.junit.Test;
import static org.junit.Assert.*; 


public class PositionTest {
    @Test
    public void testPositionConstructor() {
        Position position = new Position(15, 13);

        assertEquals(position.getX(), 15);
        assertEquals(position.getY(), 13);

        position.setX(22);
        position.setY(72);

        assertEquals(position.getX(), 22);
        assertEquals(position.getY(), 72);
    }

    @Test
    public void testPositionCopyConstructor() {
        Position position = new Position(15, 13);
        Position copy = new Position(position);

        assertEquals(copy.getX(), 15);
        assertEquals(copy.getY(), 13);
    }

    @Test
    public void testPositionDefaultConstructor() {
        Position position = new Position();

        assertEquals(position.getX(), 0);
        assertEquals(position.getY(), 0);
    }

    @Test
    public void testPositionToString() {
        Position position = new Position(15, 13);
        assertEquals(position.toString(), "Position{x=15, y=13}");
    }

    @Test
    public void testEquals() {
        Position position1 = new Position(1, 2);
        Position position2 = new Position(1, 2);
        Position position3 = new Position(3, 4);

        assertTrue(position1.equals(position1));
        assertTrue(position1.equals(position2));
        assertFalse(position1.equals(null));
        assertFalse(position1.equals("not a Position"));
        assertFalse(position1.equals(position3));
    }
}
