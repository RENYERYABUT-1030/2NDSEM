public class SecondLarge {
    public static void main(String[] args) {
        int[] numbers = {10, 5, 8, 20, 15};

        // Initialize largest and secondLargest to the smallest possible integer value
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        // Loop through the array
        for (int i = 0; i < numbers.length; i++) {
            int currentNumber = numbers[i];

            // If the current number is bigger than the largest
            if (currentNumber > largest) {
                // The old largest becomes the new secondLargest
                secondLargest = largest;
                // The current number is the new largest
                largest = currentNumber;
            }
            // Else if the current number is between largest and secondLargest
            else if (currentNumber > secondLargest && currentNumber != largest) {
                secondLargest = currentNumber;
            }
        }

        if (secondLargest == Integer.MIN_VALUE) {
            System.out.println("There is no second largest element.");
        } else {
            System.out.println("The second largest element is: " + secondLargest);
        }
    }
}public class SecondLargest {
    public static void main(String[] args) {
        int[] numbers = {10, 5, 8, 20, 15};

        // Initialize largest and secondLargest to the smallest possible integer value
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        // Loop through the array
        for (int i = 0; i < numbers.length; i++) {
            int currentNumber = numbers[i];

            // If the current number is bigger than the largest
            if (currentNumber > largest) {
                // The old largest becomes the new secondLargest
                secondLargest = largest;
                // The current number is the new largest
                largest = currentNumber;
            }
            // Else if the current number is between largest and secondLargest
            else if (currentNumber > secondLargest && currentNumber != largest) {
                secondLargest = currentNumber;
            }
        }

        if (secondLargest == Integer.MIN_VALUE) {
            System.out.println("There is no second largest element.");
        } else {
            System.out.println("The second largest element is: " + secondLargest);
        }
    }
}