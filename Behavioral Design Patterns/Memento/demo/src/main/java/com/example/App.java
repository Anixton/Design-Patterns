/**
 * This is the main class for the Stock Portfolio application.
 * It creates a Portfolio object and a PortfolioGUI object to interact with it.
 * The application allows the user to buy and sell stocks, and to revert to previous 
 * states of the portfolio.
 */
 public class App {
    public static void main(String[] args) {
        Portfolio portfolio = new Portfolio();
        new PortfolioGUI(portfolio);
    }
}
