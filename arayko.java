public class arayko {
    public static void main(String[] args) {
        // Arrays for 5 users
        String[] emails = {"user1@example.com", "user2@example.com", "user3@example.com", "user4@example.com", "user5@example.com"};
        String[] usernames = {"user1", "user2", "user3", "user4", "user5"};
        String[] passwords = {"pass1", "pass2", "pass3", "pass4", "pass5"};

        // Accessing the first user's information
        System.out.println("Email: " + emails[5]);
        System.out.println("Username: " + usernames[4]);
        System.out.println("Password: " + passwords[2]);

        // Loop through all users
        System.out.println("\nAll users:");
        for (int i = 0; i < emails.length; i++) {
            System.out.println("User " + (i+1) + ": " + emails[i] + ", " + usernames[i] + ", " + passwords[i]);
        }
    }
}
