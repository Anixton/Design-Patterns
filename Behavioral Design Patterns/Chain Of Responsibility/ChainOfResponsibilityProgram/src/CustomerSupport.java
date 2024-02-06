public class CustomerSupport {
    private SupportHandler CEO;
    private SupportHandler director;
    private SupportHandler manager;
    private SupportHandler agent;
    
    private CustomerIssue issue;

    public CustomerSupport() {
        CEO = new CEO();
        director = new SupportDirector(CEO);
        manager = new SupportManager(director);
        agent = new SupportAgent(manager);
    }

    public void setIssue(String description, int complexityLevel) {
        issue = new CustomerIssue(description, complexityLevel);
    }

    public void setIssue(CustomerIssue issue) {
        this.issue = issue;
    }

    public CustomerIssue getIssue() {
        return issue;
    }

    public void handleIssue() {
        if (issue == null) {
            System.out.println("No issue to handle");
            return;
        }
        agent.handle(issue);
    }
}