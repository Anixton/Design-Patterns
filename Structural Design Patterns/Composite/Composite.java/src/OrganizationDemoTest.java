import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.*;

public class OrganizationDemoTest {
    @Test
    public void testDepartmentName() {
        Department engineeringDept = new Department("Engineering Department");
        assertEquals("Engineering Department", engineeringDept.getEmployeeName());
        assertEquals("Department", engineeringDept.getEmployeeRole());
    }

    @Test
    public void testDeveloperEmployeeDetails() {
        Developer dev = new Developer("John Doe", "Software Engineer", "Project Test");
        assertEquals("John Doe", dev.getEmployeeName());
        assertEquals("Software Engineer", dev.getEmployeeRole());
        assertEquals("Project Test", dev.getCurrentProject());    
    }

    @Test
    public void testSalesEmployeeDetails() {
        Sales sales = new Sales("Alice Johnson", "Sales Executive", 50000, 100000);
        assertEquals("Alice Johnson", sales.getEmployeeName());
        assertEquals("Sales Executive", sales.getEmployeeRole());
        assertEquals(50.0, sales.getRevenueAchieved(), 0.01);
        assertFalse(sales.hasMetTarget());
    }

    @Test
    public void testHumanResourcesDetails() {
        HumanResources hr = new HumanResources("Bob Miller", "HR Specialist");
        assertEquals("Bob Miller", hr.getEmployeeName());
        assertEquals("HR Specialist", hr.getEmployeeRole());
    }

    @Test
    public void testSalesPersonNotMeetingTarget() {
        Sales sales = new Sales("Alice Johnson", "Sales Executive", 50000, 100000);
        Department salesDept = new Department("Sales Department");
        Assert.assertFalse(salesDept.addEmployee(sales));
    }

    @Test
    public void testSalesPersonMeetingTarget() {
        Sales sales = new Sales("Alice Johnson", "Sales Executive", 100000, 100000);
        Department salesDept = new Department("Sales Department");
        Assert.assertTrue(salesDept.addEmployee(sales));
    }

    @Test
    public void testAddSameEmployeeTwice() {
        Employee dev = new Developer("John Doe", "Software Engineer", "Project Test");
        Department engineeringDept = new Department("Engineering Department");
        assertTrue(engineeringDept.addEmployee(dev));
        assertFalse(engineeringDept.addEmployee(dev)); 
    }

    @Test
    public void testRemoveEmployeeFromDepartment() {
        Employee dev = new Developer("John Doe", "Software Engineer", "Project Test");
        Department engineeringDept = new Department("Engineering Department");
        engineeringDept.addEmployee(dev);
        assertTrue(engineeringDept.removeEmployee(dev));
        assertFalse(engineeringDept.removeEmployee(dev));
    }

}
