import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class SupportAgentTest {
    @Test
    public void testHandle() {
        CustomerIssue issue = new CustomerIssue("Issue 147", 1);
        SupportAgent supportAgent = new SupportAgent(new SupportManager(new SupportDirector(new CEO())));
        supportAgent.handle(issue);

        assertEquals("Issue 147", issue.getDescription());
        assertTrue("Issue should be handled", issue.isHandled());
        assertEquals("Issue should be handled by SupportAgent", "SupportAgent", issue.getIssueSolvedBy());
    }

    @Test
    public void testHandleNullIssue() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        SupportAgent supportAgent = new SupportAgent(new SupportManager(new SupportDirector(new CEO())));
        supportAgent.handle(null);

        assertEquals("SupportAgent: Could not handle null\r\n", outContent.toString());
    }

    @Test
    public void testSupportAgentConstructorWithNull() {
        try {
            new SupportDirector(null);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Next handler cannot be null", e.getMessage());
        }
    }

    @Test
    public void testHandleIssueWithNextHandlerManager() {
        CustomerIssue issue = new CustomerIssue("Account Block issue", 2);
        SupportAgent supportAgent = new SupportAgent(new SupportManager(new SupportDirector(new CEO())));
        supportAgent.handle(issue);

        assertEquals("Account Block issue", issue.getDescription());
        assertTrue("Issue should be handled", issue.isHandled());
        assertEquals("Issue should be handled by SupportManager", "SupportManager", issue.getIssueSolvedBy());
    }

    @Test
    public void testHandleIssueWithNextHandlerDirector() {
        CustomerIssue issue = new CustomerIssue("Account Block issue", 3);
        SupportAgent supportAgent = new SupportAgent(new SupportManager(new SupportDirector(new CEO())));
        supportAgent.handle(issue);

        assertEquals("Account Block issue", issue.getDescription());
        assertTrue("Issue should be handled", issue.isHandled());
        assertEquals("Issue should be handled by SupportDirector", "SupportDirector", issue.getIssueSolvedBy());
    }

    @Test
    public void testHandleIssueWithNextHandlerCEO() {
        CustomerIssue issue = new CustomerIssue("Account Block issue", 4);
        SupportAgent supportAgent = new SupportAgent(new SupportManager(new SupportDirector(new CEO())));
        supportAgent.handle(issue);

        assertEquals("Account Block issue", issue.getDescription());
        assertTrue("Issue should be handled", issue.isHandled());
        assertEquals("Issue should be handled by CEO", "CEO", issue.getIssueSolvedBy());
    }
}
