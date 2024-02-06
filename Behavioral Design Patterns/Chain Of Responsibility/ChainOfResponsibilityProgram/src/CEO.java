public class CEO implements SupportHandler{
    private final int SOLVABLE_COMPLEXITY_LEVEL = Integer.MAX_VALUE;
    @Override
    public void handle(CustomerIssue issue) {
        if (issue == null) {
            System.out.println("CEO: Could not handle null");
        } else if (issue.getComplexityLevel() <= SOLVABLE_COMPLEXITY_LEVEL) {
            System.out.println("CEO: Handled the " + issue.getDescription());
            issue.handleIssue(this);
        } else {
            throw new RuntimeException("CEO: Could not handle " + issue.getDescription());
        }
    }
}
