// Leaf Class

public class HumanResources implements Employee {
    private String name;
    private String role;

    public HumanResources(String name, String role) {
        this.name = name;
        this.role = role;
    }

    @Override
    public String getEmployeeName() {
        return name;
    }

    @Override
    public String getEmployeeRole() {
        return role;
    }

    @Override
    public void displayEmployeeDetails() {
        System.out.println("Human Resources: " + name + ", Role: " + role);
    }
}

