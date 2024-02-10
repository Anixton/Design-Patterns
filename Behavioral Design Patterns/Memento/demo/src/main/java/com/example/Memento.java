import java.util.Map;
import java.util.HashMap;

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
