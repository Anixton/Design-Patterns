public class SupportManager implements SupportHandler {
    private SupportHandler nextHandler;
    private final int SOLVABLE_COMPLEXITY_LEVEL = 2;

    public SupportManager(SupportHandler nextHandler) {
        if (nextHandler == null) {
            throw new IllegalArgumentException("Next handler cannot be null");
        }
        this.nextHandler = nextHandler;
    }

    @Override
    public void handle(CustomerIssue issue) {
        if (issue == null) {
            System.out.println("SupportManager: Could not handle null");
        } else if (issue.getComplexityLevel() <= SOLVABLE_COMPLEXITY_LEVEL) {
            System.out.println("SupportManager: Handled the " + issue.getDescription());
            issue.handleIssue(this);
        } else if (nextHandler != null) {
            nextHandler.handle(issue);
        } else {
            System.out.println("SupportManager: Could not handle the " + issue.getDescription());
        }
    }
}