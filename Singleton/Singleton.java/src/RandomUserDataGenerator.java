import java.security.SecureRandom;

public class RandomUserDataGenerator {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int DEFAULT_USERNAME_LENGTH = 8;
    private static final int DEFAULT_PASSWORD_LENGTH = 10;

    private final SecureRandom random;

    public RandomUserDataGenerator() {
        this.random = new SecureRandom();
        createRandomUsers(100);
        
        // Extra 1 user to test the login functionality
        User user = new User("MHG", "1?hi3/j4#");
        UserAuthenticationManager.getInstance().addUser(user);
    }

    private String generateRandomUsername() {
        return generateRandomString(DEFAULT_USERNAME_LENGTH);
    }

    private String generateRandomPassword() {
        return generateRandomString(DEFAULT_PASSWORD_LENGTH);
    }

    private String generateRandomUsername(int length) {
        return generateRandomString(length);
    }

    private String generateRandomPassword(int length) {
        return generateRandomString(length);
    }

    private String generateRandomString(int length) {
        StringBuilder randomString = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            randomString.append(CHARACTERS.charAt(randomIndex));
        }
        return randomString.toString();
    }

    private void createRandomUsers(int numberOfUsers) {
        for (int i = 0; i < numberOfUsers; i++) {
            String randomUsername = generateRandomUsername();
            String randomPassword = generateRandomPassword();
            User user = new User(randomUsername, randomPassword);
            UserAuthenticationManager.getInstance().addUser(user);
        }
    }
}
