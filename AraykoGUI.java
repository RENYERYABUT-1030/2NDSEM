import javax.swing.*;

public class AraykoGUI {

    // User class (like JSON object)
    static class User {
        String email;
        String username;
        String password;

        User(String email, String username, String password) {
            this.email = email;
            this.username = username;
            this.password = password;
        }
    }

    public static void main(String[] args) {
        // Create users
        User[] users = new User[5];
        users[0] = new User("user1@example.com", "user1", "pass1");
        users[1] = new User("user2@example.com", "user2", "pass2");
        users[2] = new User("user3@example.com", "user3", "pass3");
        users[3] = new User("user4@example.com", "user4", "pass4");
        users[4] = new User("user5@example.com", "user5", "pass5");

        String[] options = {"Show User", "Show All Users", "Login", "Exit"};
        int choice;

        do {
            choice = JOptionPane.showOptionDialog(
                    null,
                    "Select an option",
                    "User Management Menu",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            switch (choice) {
                case 0:
                    showSpecificUser(users);
                    break;
                case 1:
                    showAllUsers(users);
                    break;
                case 2:
                    loginUser(users); // Keep prompting until correct or cancel
                    break;
                default:
                    choice = 3; // Exit
                    break;
            }
        } while (choice != 3);

        JOptionPane.showMessageDialog(null, "Exiting program. Goodbye!");
    }

    // Show a specific user
    public static void showSpecificUser(User[] users) {
        String input = JOptionPane.showInputDialog("Enter user number (1-5):");
        if (input != null) {
            try {
                int index = Integer.parseInt(input) - 1;
                if (index >= 0 && index < users.length) {
                    JOptionPane.showMessageDialog(null,
                            "Email: " + users[index].email +
                                    "\nUsername: " + users[index].username +
                                    "\nPassword: " + users[index].password);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid user number!");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number!");
            }
        }
    }

    // Show all users
    public static void showAllUsers(User[] users) {
        StringBuilder allUsers = new StringBuilder();
        for (int i = 0; i < users.length; i++) {
            allUsers.append("User ").append(i + 1).append(": ")
                    .append(users[i].email).append(", ")
                    .append(users[i].username).append(", ")
                    .append(users[i].password).append("\n");
        }
        JOptionPane.showMessageDialog(null, allUsers.toString());
    }

    // Login with hidden password and repeat until success or cancel
    public static void loginUser(User[] users) {
        while (true) {
            String usernameInput = JOptionPane.showInputDialog("Enter username:");
            if (usernameInput == null) return; // User clicked Cancel

            // Password input using JPasswordField
            JPasswordField passwordField = new JPasswordField();
            int action = JOptionPane.showConfirmDialog(null, passwordField, "Enter password:",
                    JOptionPane.OK_CANCEL_OPTION);
            if (action != JOptionPane.OK_OPTION) return; // Cancel pressed

            String passwordInput = new String(passwordField.getPassword());

            boolean success = false;
            for (User u : users) {
                if (u.username.equals(usernameInput) && u.password.equals(passwordInput)) {
                    JOptionPane.showMessageDialog(null, "Login successful! Welcome " + u.username);
                    success = true;
                    break;
                }
            }

            if (success) break; // Exit the loop if login successful
            else {
                JOptionPane.showMessageDialog(null, "Invalid username or password. Try again.");
            }
        }
    }
}
