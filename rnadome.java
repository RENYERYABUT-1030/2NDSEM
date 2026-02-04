import java.io.Console;

public class rnadome {
    public static void main(String[] args) {

        Console con = System.console();

        if (con == null) {
            System.out.println("Console not available. Run this in CMD or Terminal.");
            return;   // <-- close the program if Console is null
        } // <-- missing closing brace for the if

        // Ask user to type password (typing hidden)
        char[] typedArr = con.readPassword("Enter your password: ");
        String password = new String(typedArr);

        // For testing: just print a message (not the password)
        System.out.println("You typed your password (hidden) successfully!");
    }
}
