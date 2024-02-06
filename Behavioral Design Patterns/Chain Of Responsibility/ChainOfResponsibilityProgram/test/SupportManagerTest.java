import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class SupportManagerTest {
    @Test
    public void testHandle() {
        CustomerIssue issue = new CustomerIssue("Issue 147", 1);
        SupportManager supportManager = new SupportManager(new SupportDirector(new CEO()));
        supportManager.handle(issue);

        assertEquals("Issue 147", issue.getDescription());
        assertTrue("Issue should be handled", issue.isHandled());
        assertEquals("Issue should be handled by SupportManager", "SupportManager", issue.getIssueSolvedBy());
    }

    @Test
    public void testHandleNullIssue() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        SupportManager supportManager = new SupportManager(new SupportDirector(new CEO()));
        supportManager.handle(null);

        assertEquals("SupportManager: Could not handle null\r\n", outContent.toString());
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
    public void testHandleIssueWithNextHandlerDirector() {
        CustomerIssue issue = new CustomerIssue("Account Block issue", 3);
        SupportManager supportManager = new SupportManager(new SupportDirector(new CEO()));
        supportManager.handle(issue);

        assertEquals("Account Block issue", issue.getDescription());
        assertTrue("Issue should be handled", issue.isHandled());
        assertEquals("Issue should be handled by SupportDirector", "SupportDirector", issue.getIssueSolvedBy());
    }

    @Test
    public void testHandleIssueWithNextHandlerCEO() {
        CustomerIssue issue = new CustomerIssue("Account Block issue", 5);
        SupportManager supportManager = new SupportManager(new SupportDirector(new CEO()));
        supportManager.handle(issue);

        assertEquals("Account Block issue", issue.getDescription());
        assertTrue("Issue should be handled", issue.isHandled());
        assertEquals("Issue should be handled by CEO", "CEO", issue.getIssueSolvedBy());
    }
}
