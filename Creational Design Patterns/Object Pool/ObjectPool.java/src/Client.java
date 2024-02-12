/**
 * This program demonstrates a simple Connection Pooling system using the Object Pool design pattern.
 *
 * Program Flow:
 * - The main class, Client, creates an instance of ConnectionPool.
 * - It spawns 5 threads to simulate multiple clients acquiring and releasing connections concurrently.
 * - Each thread obtains a connection from the pool, executes a SELECT query, and then releases the connection.
 * - The program prints the current connection size and pool size before and after the thread execution.
 * - A brief delay is introduced to allow threads to execute.
 * - Finally, the program prints the updated connection size and pool size after the delay.
 *
 * Components:
 * - ConnectionPool: Manages a pool of ConnectionClass instances.
 * - ConnectionClass: Represents a connection to a database and executes a query.
 *
 */

/**
 * Client class that simulates multiple clients acquiring and releasing connections concurrently.
 */
public class Client {
    public static void main(String[] args) {
        ConnectionPool connectionPool = new ConnectionPool();

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                ConnectionClass connection = connectionPool.getConnection();

                connection.executeQuery("SELECT * FROM your_table_name");

                connectionPool.releaseConnection(connection);
            }).start();
        }

        System.out.println("Current Connection Size: " + connectionPool.getCurrentConnectionSize());
        System.out.println("Current Pool Size: " + connectionPool.getCurrentPoolSize());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Current Connection Size: " + connectionPool.getCurrentConnectionSize());
        System.out.println("Current Pool Size: " + connectionPool.getCurrentPoolSize());
    }
}
