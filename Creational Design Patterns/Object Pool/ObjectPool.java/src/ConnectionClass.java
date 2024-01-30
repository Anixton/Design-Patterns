import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionClass {
    private final String USER = "MHG";
    private final String PASSWORD = "g!d-h6#_sa?sp";
    private final String URL = "jdbc:mysql://localhost:3306/designPatterns?user=MHG&password=g!d-h6#_sa?sp";

    private Connection createConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void executeQuery(String query) {
        /*try (Connection connection = createConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String columnName = resultSet.getString("column_name");
                System.out.println("Column Value: " + columnName);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }*/
    }
}
