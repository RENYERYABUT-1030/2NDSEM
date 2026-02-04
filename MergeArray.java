public class MergeArray {
    public static void main(String[] args) {
        int[] arrayA = {1, 2, 3};
        int[] arrayB = {4, 5, 6};

        int lengthA = arrayA.length;
        int lengthB = arrayB.length;

        // Create a new array with the combined length
        int[] mergedArray = new int[lengthA + lengthB];

        // Copy elements from arrayA
        for (int i = 0; i < lengthA; i++) {
            mergedArray[i] = arrayA[i];
        }

        // Copy elements from arrayB
        // Notice we start placing them at index 'lengthA'
        for (int i = 0; i < lengthB; i++) {
            mergedArray[lengthA + i] = arrayB[i];
        }

        System.out.println("Merged array: ");
        for (int num : mergedArray) {
            System.out.print(num + " ");
        }
    }
}