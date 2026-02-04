public class PalindromeCheckerMethod {

    // This is the main method that runs when you execute the file
    public static void main(String[] args) {
        // Test our method with two different strings
        System.out.println("Is 'madam' a palindrome? " + isPalindrome("madam"));
        System.out.println("Is 'hello' a palindrome? " + isPalindrome("hello"));
    }

    /**
     * Method to check if a string is a palindrome.
     * It returns true if it is, and false if it is not.
     */
    public static boolean isPalindrome(String text) {
        // We'll build the reversed version of the string here
        String reversedText = "";

        // We make the text lowercase to handle cases like "Racecar"
        String cleanText = text.toLowerCase();

        // Loop through the string from the LAST character to the FIRST
        for (int i = cleanText.length() - 1; i >= 0; i--) {
            // Add each character to our new 'reversedText' string
            reversedText = reversedText + cleanText.charAt(i);
        }

        // Check if the original (clean) text is equal to the reversed text
        return cleanText.equals(reversedText);
    }
}