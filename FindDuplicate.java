public class FindDuplicate {
    public static void main(String[] args) {
        // Here's our sample array
        int[] numbers = {1, 2, 5, 5, 6, 6, 7, 2,7,10,20,10,20,30,30};

        System.out.println("Finding duplicate elements...");

        // Outer loop: picks an element
        for (int i = 0; i < numbers.length; i++) {

            // Inner loop: compares the picked element (numbers[i]) with the rest
            // We start j from i + 1 so we don't compare an element with itself
            for (int j = i + 1; j < numbers.length; j++) {

                // If a match is found
                if (numbers[i] == numbers[j]) {
                    System.out.println("Duplicate found: " + numbers[j]);
                }
            }
        }
    }
}