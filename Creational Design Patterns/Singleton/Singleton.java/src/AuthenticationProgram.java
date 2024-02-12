/**
 * This program demonstrates a simple User Authentication System using the Singleton and
 * Factory design patterns. It manages user authentication, login, logout, and user existence.
 *
 * Components and Classes:
 * - UserAuthenticationManager: Singleton class managing user authentication actions such as login,
 *   logout, and checking user existence. It uses a Map to store user data.
 *
 * - User: Represents a user with a username, password, and login status. It provides methods to
 *   get and set login status.
 *
 * - RandomUserDataGenerator: Generates random usernames and passwords, creating instances of
 *   User and adding them to the UserAuthenticationManager. It includes a predefined user
 *   ("MHG") for testing the login functionality.
 *
 * - AuthenticationProgram: The main class for testing the authentication system. It takes user
 *   input for a username and password, checks user existence, attempts to log in the user,
 *   checks authentication status, logs out the user, and checks authentication status again.
 *
 * Design Patterns Used:
 * - Singleton: Ensures a single instance of UserAuthenticationManager throughout the program.
 * - Factory: RandomUserDataGenerator acts as a factory, creating instances of User and adding them
 *   to the authentication manager.
 *
 * The program can be expanded to include additional features like account creation, password
 * encryption, and more sophisticated user authentication mechanisms.
 * 
 */



import java.util.Scanner;

public class AuthenticationProgram {
    public static void main(String[] args) {
        UserAuthenticationManager authenticationManager = UserAuthenticationManager.getInstance();
        RandomUserDataGenerator userDataGenerator = new RandomUserDataGenerator();
        Scanner scanner = new Scanner(System.in);

        // Predefined user for testing the login functionality
        // Username: MHG
        // Password: 1?hi3/j4#
        System.out.print("Enter your Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your Password: ");
        String password = scanner.nextLine();

        if (!authenticationManager.userExists(username)){
            throw new IllegalArgumentException("User does not exist");
        }

        if (authenticationManager.loginUser(username, password)) {
            System.out.println("User " + username + " logged in successfully");
        }else {
            System.out.println("User " + username + " failed to log in");
        }

        if (authenticationManager.isAuthenticated(username)) {
            System.out.println("User is currently authenticated.");
        } else {
            System.out.println("User is not authenticated.");
        }

        authenticationManager.logoutUser(username);

        if (authenticationManager.isAuthenticated(username)) {
            System.out.println("User is currently authenticated.");
        } else {
            System.out.println("User is not authenticated.");
        }
    }
}
