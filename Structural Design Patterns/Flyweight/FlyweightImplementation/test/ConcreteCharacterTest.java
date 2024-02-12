import org.junit.Test;
import static org.junit.Assert.*;
import java.awt.GridBagConstraints;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import javax.swing.JPanel;

public class ConcreteCharacterTest {
    @Test
    public void testDisplay() {
        JPanel panel = new JPanel();
        GridBagConstraints constraints = new GridBagConstraints();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        ConcreteCharacter concreteCharacter = new ConcreteCharacter('a');
        concreteCharacter.display(panel, constraints);
        assertEquals("a", outContent.toString());
        System.setOut(System.out);
    }
}
