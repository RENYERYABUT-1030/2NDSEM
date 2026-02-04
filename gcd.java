public class gcd {

    public static void main(String[] args) {
        // Test the method. The GCD of 50 and 15 is 5.
        int gcd = findGCD(50, 15);
        System.out.println("The GCD is: " + gcd);
    }

    /**
     * Method to find the Greatest Common Divisor (GCD) of two numbers.
     */
    public static int findGCD(int a, int b) {
        // We will loop from 1 up to the smaller of the two numbers
        int smallerNumber = 0;
        if (a < b) {
            smallerNumber = a;
        } else {
            smallerNumber = b;
        }

        // We need a variable to store the GCD. 1 is always a divisor.
        int gcd = 1;

        // Loop from 1 up to the smaller number
        for (int i = 1; i <= smallerNumber; i++) {

            // Check if 'i' divides BOTH 'a' AND 'b' with no remainder
            if (a % i == 0 && b % i == 0) {
                // If it does, it's a common divisor.
                // We update 'gcd' to this new, larger number.
                gcd = i;
            }
        }

        // After the loop, 'gcd' will hold the largest number
        // that divided both, which is the GCD.
        return gcd;
    }
}