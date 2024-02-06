import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class CustomerTest {
    @Test
    public void testCustomerGetMethods() {
        Customer customer = new Customer("John", 
                                        "john.king@ogrenci.ege.edu.tr", 
                                        new CustomerIssue("Password issue", 1));
        
        assertEquals("Name should be John", "John", customer.getName());
        assertEquals("Emails should be same","john.king@ogrenci.ege.edu.tr", customer.getEmail());  
        assertEquals("Complexity level should be 1", 1, customer.getComplexityLevel());
    }

    @Test
    public void testCustomerSetMethods() {
        Customer customer = new Customer("John", 
                                        "john.king@ogrenci.ege.edu.tr", 
                                        new CustomerIssue("Password issue", 1));
        
        customer.setName("John2"); 
        assertEquals("Name should be John2", "John2", customer.getName());

        customer.setEmail("hakangezginci35@gmail.com");
        assertEquals("Emails should be same","hakangezginci35@gmail.com", customer.getEmail());  

        CustomerIssue issue = new CustomerIssue("Password issue", 1);
        customer.setIssue(issue);

        assertEquals("Complexity level should be 1", 1, customer.getComplexityLevel());
        assertEquals("Issue should be same", issue, customer.getIssue());
    }

    @Test
    public void testNullValues() {
       try {
           new Customer(null,null,null);
           fail("Expected an IllegalArgumentException to be thrown"); 
        } catch (IllegalArgumentException e) {
            assertEquals("Issue cannot be null", e.getMessage()); 
        }
    }
}
