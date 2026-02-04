public class Vowels {

    public static void main(String[] args) {
        // Test the method
        String testString = "Hello World, how are you?";
        int vowelCount = countVowels(testString);
        System.out.println("The string has " + vowelCount + " vowels.");
    }

    /**
     * Method to count the number of vowels in a string.
     */
    public static int countVowels(String text) {
        // A variable to hold our count, starting at 0
        int count = 0;

        // Convert the whole string to lowercase so we don't
        // have to check for 'a' AND 'A'
        String lowerText = text.toLowerCase();

        // Loop through every character in the string
        for (int i = 0; i < lowerText.length(); i++) {
            // Get the character at the current position
            char ch = lowerText.charAt(i);

            // Check if the character is one of the vowels
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                // If it is, add 1 to our count
                count++;
            }
        }

        // Return the final count
        return count;
    }
}