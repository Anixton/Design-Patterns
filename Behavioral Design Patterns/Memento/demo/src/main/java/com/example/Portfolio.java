import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


public class Portfolio {
    private Map<String, Integer> stocks = new HashMap<>();
    private Stack<Memento> mementos = new Stack<>();
    private Stack<Memento> futurMementos = new Stack<>();

    public void buy(String stock, int quantity) {
        stocks.put(stock, stocks.getOrDefault(stock, 0) + quantity);
        saveState();
    }

    public void sell(String stock, int quantity) {
        if (stocks.containsKey(stock) && stocks.get(stock) >= quantity) {
            stocks.put(stock, stocks.get(stock) - quantity);
            saveState();
        } else {
            System.out.println("Not enough stock to sell");
        }
    }

    public void revertToPreviousState(int n) {
        if (mementos.size() < n) {
            System.out.println("Not enough states to revert to");
            return;
        }
        for (int i = 0; i < n; i++) {
            futurMementos.push(mementos.pop());
        }
        Map<String, Integer> savedState = mementos.peek().getSavedState();
        stocks = new HashMap<>(savedState);
    }

    public void revertToFutureState(int n) {
        if (futurMementos.size() < n) {
            System.out.println("Not enough states to revert to");
            return;
        }
        for (int i = 0; i < n; i++) {
            mementos.push(futurMementos.pop());
        }
        Map<String, Integer> savedState = mementos.peek().getSavedState();
        stocks = new HashMap<>(savedState);
    }

    public void saveState() {
        Map<String, Integer> newMap = new HashMap<>(stocks);
        mementos.push(new Memento(newMap));
    }

    public void printPortfolio() {
        System.out.println(stocks);
    }
}
