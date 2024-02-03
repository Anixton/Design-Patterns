// Leaf Class

public class Sales implements Employee {
    private String name;
    private String role;
    private int currentRevenue;
    private int revenueTarget;

    public Sales(String name, String role, int currentRevenue, int revenueTarget) {
        this.name = name;
        this.role = role;
        this.currentRevenue = currentRevenue;
        this.revenueTarget = revenueTarget;
    }

    public double getRevenueAchieved() {
        return (double) currentRevenue / revenueTarget * 100;
    }

    public boolean hasMetTarget() {
        return getRevenueAchieved() >= 75;
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
        System.out.println("Sales: " + name + ", Role: " + role + ", Revenue Target: " + getRevenueAchieved());
    }
}
