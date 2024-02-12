import java.util.HashSet;
import java.util.Set;

/**
 * ConnectionPool manages a pool of ConnectionClass instances.
 */
public class ConnectionPool {
    private final int POOLSIZE=10;
    private int currentPoolSize=0;

    private final Set<ConnectionClass> available = new HashSet<>();
    private final Set<ConnectionClass> inUse = new HashSet<>(); 

    public ConnectionPool(){
        while(currentPoolSize<POOLSIZE){
            available.add(new ConnectionClass());
            currentPoolSize++;
        }
        currentPoolSize=1;
    }

    public synchronized ConnectionClass getConnection(){
        if(available.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ConnectionClass connection = available.iterator().next();
        available.remove(connection);
        inUse.add(connection);
        return connection;
    }

    public synchronized void releaseConnection(ConnectionClass connection){
        if (connection != null) {
            inUse.remove(connection);
            available.add(connection);
            notifyAll();
        }
    }

    public synchronized void setPoolSize(int newSize) throws IllegalStateException {
        if (newSize < currentPoolSize) {
            if (available.size() > newSize) {
                available.removeIf(connection -> available.size() > newSize);
            } else {
                throw new IllegalStateException("Cannot shrink pool. Not enough available connections.");
            }
        } else if (newSize > currentPoolSize) {
            while (currentPoolSize < newSize) {
                available.add(new ConnectionClass());
                currentPoolSize++;
            }
        }
        notifyAll();
    }

    public synchronized int getCurrentConnectionSize(){
        return inUse.size();
    }

    public int getCurrentPoolSize(){
        return currentPoolSize;
    }
}
