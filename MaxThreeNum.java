public class  MaxThreeNum {

    public static void main(String[] args) {
        // Test the method
        int maxNumber = findMax(30, 70, 50);
        System.out.println("The maximum number is: " + maxNumber);
    }

    /**
     * Method to find the largest of three integers.
     */
    public static int findMax(int num1, int num2, int num3) {
        // Assume the first number is the max to start
        int max = num1;

        // Check if the second number is bigger than our current max
        if (num2 > max) {
            max = num2; // If it is, update max
        }

        // Check if the third number is bigger than our current max
        if (num3 > max) {
            max = num3; // If it is, update max
        }

        // Return the final max value
        return max;
    }
}