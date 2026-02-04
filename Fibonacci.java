public class Fibonacci {

    public static void main(String[] args) {
        // Test the method. We want the first 10 terms.
        printFibonacci(10);
    }

    /**
     * Method to print the first n Fibonacci numbers.
     * This method doesn't return anything (void).
     */
    public static void printFibonacci(int n) {
        // The first two numbers of the series are always 0 and 1
        int num1 = 0;
        int num2 = 1;

        System.out.println("First " + n + " Fibonacci terms:");

        // Loop 'n' times to print 'n' terms
        for (int i = 0; i < n; i++) {
            // Print the first number (which starts at 0)
            System.out.print(num1 + " ");

            // Calculate the next number in the series
            int sum = num1 + num2;

            // "Shift" the numbers over for the next loop
            num1 = num2;      // num1 becomes what num2 was
            num2 = sum;       // num2 becomes the new sum
        }
    }
}