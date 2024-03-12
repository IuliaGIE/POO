package org.example;

public class UserFactory {

    public static User<?> createUser(String userType, String email, String password) {
        Credentials credentials = new Credentials(email, password);
        User.Information information = new User.Information();
        information.setCredentials(email, password);

        switch (userType.toLowerCase()) {
            case "admin":
                return new Admin<>(information, AccountType.Admin);
            case "regular":
                return new Regular<>(information, AccountType.Regular);
            case "contributor":
                return new Contributor<>(information, AccountType.Contributor);
            default:
                throw new IllegalArgumentException("Invalid user type: " + userType);
        }
    }
}
