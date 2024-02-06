public class CustomerIssue {
    private String description;
    private int complexityLevel;
    private boolean isHandled;

    private SupportHandler issueSolvedBy;

    public CustomerIssue(String description, int complexityLevel) {
        this.description = description;
        this.complexityLevel = complexityLevel;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setComplexityLevel(int complexityLevel) {
        this.complexityLevel = complexityLevel;
    }

    public int getComplexityLevel() {
        return complexityLevel;
    }

    public void handleIssue(SupportHandler problemSolver) {
        isHandled = true;
        issueSolvedBy = problemSolver;
    }

    public String getIssueSolvedBy() {
        return isHandled ? issueSolvedBy.getClass().getSimpleName() : null;
    }

    public boolean isHandled() {
        return isHandled;
    }
}
