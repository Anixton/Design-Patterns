import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class SupportDirectorTest {
    @Test
    public void testHandleIssue() {
        CustomerIssue issue = new CustomerIssue("Account Block issue", 3);
        SupportDirector director = new SupportDirector(new CEO());
        director.handle(issue);

        assertEquals("Account Block issue", issue.getDescription());
        assertTrue("Issue should be handled", issue.isHandled());
        assertEquals("Issue should be handled by SupportDirector", "SupportDirector", issue.getIssueSolvedBy());
    }

    @Test
    public void testHandleNullIssue() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        SupportDirector director = new SupportDirector(new CEO());
        director.handle(null);

        assertEquals("SupportDirector: Could not handle null\r\n", outContent.toString());
    }

    @Test
    public void testSupportDirectorConstructorWithNull() {
        try {
            new SupportDirector(null);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Next handler cannot be null", e.getMessage());
        }
    }

    @Test
    public void testHandleIssueWithNextHandlerCEO() {
        CustomerIssue issue = new CustomerIssue("Account Block issue", 5);
        SupportDirector director = new SupportDirector(new CEO());
        director.handle(issue);

        assertEquals("Account Block issue", issue.getDescription());
        assertTrue("Issue should be handled", issue.isHandled());
        assertEquals("Issue should be handled by CEO", "CEO", issue.getIssueSolvedBy());
    }

}
