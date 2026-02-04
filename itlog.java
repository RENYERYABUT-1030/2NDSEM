public class itlog {
    public static void main(String[] args) {
        int num = 0;

        for (int i = 5; i <= 5; i++) {       // runs once with i = 4
            for (int j = 2; j <= i; j++) {   // j = 2 to 4
                for (int b = 1; b <= 5; b++) { // b = 2 to 5
                    System.out.print(num + " ");
                    num++;
                }
                System.out.println();
            }
        }
    }
}
