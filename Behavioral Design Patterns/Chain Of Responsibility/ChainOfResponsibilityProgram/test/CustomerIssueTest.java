import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class CustomerIssueTest {
    @Test
    public void testCustomerIssueGetMethod() {
        CustomerIssue issue = new CustomerIssue("Password Issue", 5);

        assertEquals("Issue Description should be Password Issue","Password Issue", issue.getDescription());
        assertEquals("Complexity level should be 5",5, issue.getComplexityLevel());
        assertFalse("Issue not solved yet",issue.isHandled());

        issue.handleIssue(new CEO());
        assertTrue("Issue should be sovled",issue.isHandled());
        assertTrue("Issue should be handled by CEO",issue.getIssueSolvedBy() == "CEO");
    }

    @Test
    public void testCustomerIssueSetMethod() {
        CustomerIssue issue = new CustomerIssue("Password Issue", 5);
        issue.setDescription("Billing Issue");
        issue.setComplexityLevel(3);

        assertEquals("Issue Description should be Billing Issue","Billing Issue", issue.getDescription());
        assertEquals("Complexity level should be 3",3, issue.getComplexityLevel());
        assertFalse("Issue not solved yet",issue.isHandled());
    }
}
