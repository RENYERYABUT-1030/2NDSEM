public class SortArray {
    public static void main(String[] args) {
        int[] numbers = {5, 1, 4, 2, 8};

        System.out.println("Original array: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println(); // Move to the next line

        int n = numbers.length;
        int temp = 0; // A temporary variable for swapping

        // Outer loop
        for (int i = 0; i < n; i++) {
            // Inner loop
            for (int j = 1; j < (n - i); j++) {

                // If the previous element is greater than the current one, swap them
                if (numbers[j - 1] > numbers[j]) {
                    // Swap logic
                    temp = numbers[j - 1];
                    numbers[j - 1] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }

        System.out.println("Array sorted in ascending order: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }
}