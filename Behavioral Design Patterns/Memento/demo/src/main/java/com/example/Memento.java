import java.util.Map;
/**
 * The Memento class is used to save the state of a Portfolio object.
 * It contains a map of stocks, where the key is the stock name and the value is the quantity.
 * It provides methods to get the saved state and to display the state.
 */
public class Memento {
    private Map<String,Integer> stocks;

    public Memento(Map<String,Integer> stocks) {
        this.stocks = stocks;
    }

    public Map<String, Integer> getSavedState() {
        return stocks;
    }

    public void displayMemento() {
        System.out.println(stocks);
    }
}
