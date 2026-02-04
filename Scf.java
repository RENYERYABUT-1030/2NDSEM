import java.util.Scanner;

public class Scf {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        System.out.print("ENTER NUMBER: ");
        int num = sc.nextInt(); // user inputs a number

        System.out.println("You entered: " + num);
// FOR LOOP SCANNER
        // Example: print numbers from 1 up to your input
        for (int i = 1; i <= num; i++) {
            System.out.println(i);
        }

        sc.close();
    }
}
