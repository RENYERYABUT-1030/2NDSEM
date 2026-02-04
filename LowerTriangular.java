public class LowerTriangular {
    public static void main(String[] args) {
        // A 3x3 square array (matrix)
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Lower Triangular Matrix:");

        // Loop through rows
        for (int i = 0; i < matrix.length; i++) {
            // Loop through columns
            for (int j = 0; j < matrix[i].length; j++) {

                // Print the element if it's on or below the main diagonal (i >= j)
                if (i >= j) {
                    System.out.print(matrix[i][j] + "\t"); // \t is a tab
                } else {
                    System.out.print(" \t"); // Print a blank space
                }
            }
            System.out.println(); // New line after each row
        }
    }
}