// Leaf Class

public class Developer implements Employee {
    private String name;
    private String role;
    private String currentProject;

    public Developer(String name, String role, String currentProject) {
        this.name = name;
        this.role = role;
        this.currentProject = currentProject;
    }

    @Override
    public String getEmployeeName() {
        return name;
    }

    @Override
    public String getEmployeeRole() {
        return role;
    }

    public String getCurrentProject() {
        return currentProject;
    }

    @Override
    public void displayEmployeeDetails() {
        System.out.println("Developer: " + name + ", Role: " + role + ", Current Project: " + currentProject);
    }
}

