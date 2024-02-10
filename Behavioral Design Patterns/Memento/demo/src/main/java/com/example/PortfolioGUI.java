import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The PortfolioGUI class provides a graphical user interface for a Portfolio object.
 * It contains a text area to display the portfolio, text fields to input the stock name and quantity,
 * and buttons to buy and sell stocks and to revert to previous states of the portfolio.
 */
public class PortfolioGUI {
    private Portfolio portfolio;
    private JTextArea portfolioArea;
    private JButton buyButton;
    private JButton sellButton;
    private JButton previousStateButton; 
    private JButton nextStateButton;
    private JTextField stockField;
    private JTextField quantityField;
    private JTextField stateCountField;

    public PortfolioGUI(Portfolio portfolio) {
        this.portfolio = portfolio;

        JFrame frame = new JFrame("Portfolio");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 400);

        portfolioArea = new JTextArea();
        portfolioArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(portfolioArea);

        buyButton = new JButton("Buy");
        sellButton = new JButton("Sell");
        previousStateButton = new JButton("Previous State");
        nextStateButton = new JButton("Next State");

        stockField = new JTextField(5);
        quantityField = new JTextField(5);
        stateCountField = new JTextField(5);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Stock:"));
        panel.add(stockField);
        panel.add(new JLabel("Quantity:"));
        panel.add(quantityField);
        panel.add(buyButton);
        panel.add(sellButton);
        panel.add(new JLabel("State Count:"));
        panel.add(stateCountField);
        panel.add(previousStateButton);
        panel.add(nextStateButton);

        frame.getContentPane().add(BorderLayout.CENTER, scrollPane);
        frame.getContentPane().add(BorderLayout.SOUTH, panel);

        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String stock = stockField.getText();
                int quantity = Integer.parseInt(quantityField.getText());
                portfolio.buy(stock, quantity);
                updatePortfolioArea();
            }
        });

        sellButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String stock = stockField.getText();
                int quantity = Integer.parseInt(quantityField.getText());
                portfolio.sell(stock, quantity);
                updatePortfolioArea();
            }
        });

        previousStateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int revertToPreviousCount = Integer.parseInt(stateCountField.getText());
                portfolio.revertToPreviousState(revertToPreviousCount);
                updatePortfolioArea();
            }
        });

        nextStateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int revertToFutureCount = Integer.parseInt(stateCountField.getText());
                portfolio.revertToFutureState(revertToFutureCount);
                updatePortfolioArea();
            }
        });

        frame.setVisible(true);
    }

    private void updatePortfolioArea() {
        portfolioArea.setText(portfolio.toString());
    }
}