import javax.swing.*;

public class CustomerSupportGUI {
    private CustomerSupport support;
    private JTextArea agentArea, managerArea, directorArea, ceoArea;
    private JTextField descriptionField, complexityField;
    private CustomerIssue issue;

    public CustomerSupportGUI() {
        support = new CustomerSupport();
        setJTextArea();

        descriptionField = new JTextField(10);
        complexityField = new JTextField(10);

        JButton handleButton = new JButton("Handle Issue");
        handleButton.addActionListener(e -> {
            String description = descriptionField.getText();
            try {
                int complexity = Integer.parseInt(complexityField.getText());
                issue = new CustomerIssue(description, complexity);
                support.setIssue(issue);
                support.handleIssue();
                updateHandlerAreas();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number for the complexity level.");
            }
        });
        
        JFrame frame = new JFrame("Customer Support System");
        setFrame(frame);

        JPanel panel = new JPanel();
        setPanel(panel, handleButton);
        
        frame.add(panel);
    }

    private void setJTextArea() {
        agentArea = new JTextArea();
        managerArea = new JTextArea();
        directorArea = new JTextArea();
        ceoArea = new JTextArea();
    }

    private void updateHandlerAreas() {
        
        if(issue.isHandled()) {
            if(issue.getIssueSolvedBy() == "CEO") {
                problemSolvedByCeo();
            } else if(issue.getIssueSolvedBy() == "SupportDirector") {
                problemSolvedByDirector();
            } else if(issue.getIssueSolvedBy() == "SupportManager") {
                problemSolvedByManager();
            } else if(issue.getIssueSolvedBy() == "SupportAgent") {
                problemSolvedByAgent();
            }
        } else {
            agentArea.setText("Error handling problem");
            managerArea.setText("Error handling problem");
            directorArea.setText("Error handling problem");
            ceoArea.setText("Error handling problem");
        }
    }

    private void problemSolvedByCeo() {
        agentArea.setText("Sent "+ issue.getDescription() +" to my Manager");
        managerArea.setText("Sent "+ issue.getDescription() +" to my Director");
        directorArea.setText("Sent "+ issue.getDescription() +" to CEO");
        ceoArea.setText("I solved the "+issue.getDescription()+ "!");
    }

    private void problemSolvedByDirector() {
        agentArea.setText("Sent "+ issue.getDescription() +" to my Manager");
        managerArea.setText("Sent "+ issue.getDescription() +" to my Director");
        directorArea.setText("I solved the "+issue.getDescription()+ "!");
        ceoArea.setText("");
    }

    private void problemSolvedByManager() {
        agentArea.setText("Sent "+ issue.getDescription() +" to my Manager");
        managerArea.setText("I solved the " + issue.getDescription()+ "!");
        directorArea.setText("");
        ceoArea.setText("");
    }

    private void problemSolvedByAgent() {
        agentArea.setText("I solved the "+issue.getDescription()+ "!");
        managerArea.setText("");
        directorArea.setText("");
        ceoArea.setText("");
    }

    private void setFrame(JFrame frame) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 800);
        frame.setVisible(true);
    }

    private void setPanel(JPanel panel, JButton handleButton) {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Problem Description:"));
        panel.add(descriptionField);
        panel.add(new JLabel("Problem Complexity:"));
        panel.add(complexityField);
        panel.add(new JLabel("Agent:"));
        panel.add(agentArea);
        panel.add(new JLabel("Manager:"));
        panel.add(managerArea);
        panel.add(new JLabel("Director:"));
        panel.add(directorArea);
        panel.add(new JLabel("CEO:"));
        panel.add(ceoArea);
        panel.add(handleButton);
    }
}

// sent ActualProblemName to my manager
// not sent problem to my manger