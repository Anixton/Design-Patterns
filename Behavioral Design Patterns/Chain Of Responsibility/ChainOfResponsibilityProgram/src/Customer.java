public class Customer {
    private String name;
    private String email;
    private CustomerIssue issue;

    public Customer(String name, String email, CustomerIssue issue) {
        if (issue == null) {
            throw new IllegalArgumentException("Issue cannot be null");
        }
        
        this.name = name;
        this.email = email;
        this.issue = issue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setIssue(CustomerIssue issue) {
        this.issue = issue;
    }

    public CustomerIssue getIssue() {
        return issue;
    }

    public int getComplexityLevel() {
        return issue.getComplexityLevel();
    }


}
