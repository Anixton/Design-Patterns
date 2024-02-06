import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class CustomerSupportTest {
    @Test
    public void testGetIssue() {
        CustomerIssue issue = new CustomerIssue("Password issue", 1);
        CustomerSupport support = new CustomerSupport();
        support.setIssue(issue.getDescription(), issue.getComplexityLevel());

        assertEquals("Complexity level should be 1","Password issue", support.getIssue().getDescription());
        assertEquals("Complexity level should be 1",1, support.getIssue().getComplexityLevel());
        assertFalse("Issue not solved yet",support.getIssue().isHandled());
    }

    @Test
    public void testIssue() {
        CustomerSupport support = new CustomerSupport();
        support.setIssue("Billing issue", 3);

        assertEquals("Complexity level should be 3",3, support.getIssue().getComplexityLevel());
        assertFalse("Issue not solved yet",support.getIssue().isHandled());

        support.handleIssue();
        
        assertTrue("Issue should be solved",support.getIssue().isHandled());
    }

    @Test
    public void testCustomer() {
        CustomerSupport support = new CustomerSupport();
        support.setIssue("Password issue", Integer.MAX_VALUE); 
        support.handleIssue();

        assertTrue("Issue should be solved",support.getIssue().isHandled()); 
    }

    @Test
    public void testIssueHandledBySupportAgent() {
        CustomerSupport support = new CustomerSupport();
        support.setIssue("Simple issue", 1); 
        support.handleIssue();

        assertTrue("Issue should be solved", support.getIssue().isHandled());
        assertEquals("Issue should be handled by SupportAgent", "SupportAgent", support.getIssue().getIssueSolvedBy());
    }

    @Test
    public void testIssueHandledByManager() {
        CustomerSupport support = new CustomerSupport();
        support.setIssue("Complex issue", 2); 
        support.handleIssue();

        assertTrue("Issue should be solved", support.getIssue().isHandled());
        assertEquals("Issue should be handled by SupportManager", "SupportManager", support.getIssue().getIssueSolvedBy());
    }

    @Test
    public void testIssueHandledByDirector() {
        CustomerSupport support = new CustomerSupport();
        support.setIssue("Complex issue", 3); 
        support.handleIssue();

        assertTrue("Issue should be solved", support.getIssue().isHandled());
        assertEquals("Issue should be handled by SupportDirector", "SupportDirector", support.getIssue().getIssueSolvedBy());
    }

    @Test
    public void testIssueHandledByCEO() {
        CustomerSupport support = new CustomerSupport();
        support.setIssue("Complex issue", Integer.MAX_VALUE); 
        support.handleIssue();

        assertTrue("Issue should be solved", support.getIssue().isHandled());
        assertEquals("Issue should be handled by CEO", "CEO", support.getIssue().getIssueSolvedBy());
    }                                       

    @Test
    public void testHandleNullIssue() {
        CustomerSupport support = new CustomerSupport();
        support.handleIssue();

        assertNull("Issue should be null", support.getIssue());
    }

    @Test
    public void testReuseCustomerSupportInstance() {
        CustomerSupport support = new CustomerSupport();

        support.setIssue("Simple issue", 1);
        support.handleIssue();

        assertTrue("First issue should be solved", support.getIssue().isHandled());
        assertEquals("First issue should be handled by SupportAgent", "SupportAgent", support.getIssue().getIssueSolvedBy());


        support.setIssue("Complex issue", Integer.MAX_VALUE);
        support.handleIssue();
        
        assertTrue("Second issue should be solved", support.getIssue().isHandled());
        assertEquals("Second issue should be handled by CEO", "CEO", support.getIssue().getIssueSolvedBy());
    }
}
