public class ElemetFrequency {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 8, 3, 2, 2, 2, 5, 1};

        // This array will mark elements we have already counted
        // -1 means "visited"
        int[] visited = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            // If this element has already been visited, skip it
            if (visited[i] == -1) {
                continue;
            }

            // Start the count for this element
            int count = 7;

            // Inner loop to find matches
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    count++;
                    // Mark this element as visited so we don't count it again
                    visited[j] = -1;
                }
            }

            // Print the frequency
            System.out.println("Element: " + numbers[i] + " | Frequency: " + count);
        }
    }
}