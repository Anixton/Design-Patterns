import java.util.HashMap;
import java.util.Map;

public class UserAuthenticationManager {
    
    private static UserAuthenticationManager instance;
    private Map<String,User> userDatabase;

    // Private constructor to prevent instantiation
    private UserAuthenticationManager() {
        userDatabase = new HashMap<>();
    }

    public static synchronized UserAuthenticationManager getInstance() {
        if (instance == null) {
            instance = new UserAuthenticationManager();
        }
        return instance;
    }

    public boolean loginUser(String username, String password) {
        if (userDatabase.containsKey(username) && !userDatabase.get(username).isLoggedIn()) {
            if (userDatabase.get(username).getPassword().equals(password)) {
                userDatabase.get(username).setLoggedIn(true);
                return true;
            }
        }
        return false;
    }

    public void logoutUser(String username) {
        if (userDatabase.containsKey(username) && userDatabase.get(username).isLoggedIn()) {
            userDatabase.get(username).setLoggedIn(false);
        }
        else {
            throw new IllegalArgumentException("User is not logged in");
        }
    }

    public boolean isAuthenticated(String username) {
        return userDatabase.containsKey(username)&& userDatabase.get(username).isLoggedIn();
    }

    public void addUser(User user) {
        userDatabase.put(user.getUsername(), user);
    }

    public boolean userExists(String username) {
        return userDatabase.containsKey(username);
    }
}
