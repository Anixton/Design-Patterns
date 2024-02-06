import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;



public class CEOTest {
    @Test
    public void testHandleIssue() {
        CEO ceo = new CEO();
        CustomerIssue issue = new CustomerIssue("CEO issue", Integer.MAX_VALUE);
        ceo.handle(issue);

        assertEquals("CEO issue", issue.getDescription());
        assertTrue("Issue should be handled", issue.isHandled());
        assertEquals("Issue should be handled by CEO", "CEO", issue.getIssueSolvedBy());
    }

    @Test
    public void testHandleNullIssue() {

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        CEO ceo = new CEO();
        ceo.handle(null);

        assertEquals("CEO: Could not handle null\r\n", outContent.toString());
    }


}
