/**
 * Add GUI for showing the portfolio and buttons for buy and sell
 *
 */

 public class App {
    public static void main(String[] args) {
        Portfolio portfolio = new Portfolio();
        portfolio.buy("AAPL", 10); // {AAPL=10}
        portfolio.buy("GOOG", 15); // {AAPL=10, GOOG=15}
        portfolio.buy("MSFT", 20); // {AAPL=10, GOOG=15, MSFT=20}
        portfolio.buy("AMZN", 5); // {AAPL=10, GOOG=15, MSFT=20, AMZN=5}
        portfolio.buy("TSLA", 8); // {AAPL=10, GOOG=15, MSFT=20, AMZN=5, TSLA=8}
        portfolio.sell("AAPL", 5); // {AAPL=5, GOOG=15, MSFT=20, AMZN=5, TSLA=8}
        portfolio.sell("MSFT", 10); // {AAPL=5, GOOG=15, MSFT=10, AMZN=5, TSLA=8}

        portfolio.printPortfolio();
        portfolio.revertToPreviousState(1); 
        portfolio.printPortfolio(); 


        portfolio.revertToPreviousState(1);
        portfolio.printPortfolio(); 

        portfolio.revertToFutureState(1);
        portfolio.printPortfolio();

        portfolio.revertToFutureState(1);
        portfolio.printPortfolio();
    }
}
