// Composite Class
// Only Adding employees who met our target
 
import java.util.List;
import java.util.ArrayList;

public class Department implements Employee{
    private String name;    
    private List<Employee> employees = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    public boolean addEmployee(Employee employee) {
        if(employees.contains(employee)) {
            return false;
        }
        else if (employee instanceof Sales) {
            Sales salesperson = (Sales) employee;
            if (salesperson.hasMetTarget()) {
                employees.add(employee);
                return true;
            }
            return false;
        }
        else {
            employees.add(employee);
            return true;
        }
    }

    public boolean removeEmployee(Employee employee) {
        if (employees.contains(employee) == false) {
            return false;
        }

        employees.remove(employee);
        return true;
    }

    @Override
    public String getEmployeeName() {
        return name;
    }

    @Override  
    public String getEmployeeRole() {
        return "Department";
    }

    @Override
    public void displayEmployeeDetails() {
        System.out.println("Department: "+ name);
        System.out.println("Employees: ");
        
        for (Employee employee : employees) {
            employee.displayEmployeeDetails();
        }
    }

}
