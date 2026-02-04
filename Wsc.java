import java.util.Scanner;

public class Wsc {
    public static void main(String[] args) {



        // while pero my scanner

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt(); // user input

        int i = 1; // starting value

        while (i <= num) { // loop repeats while i is less than or equal to num
            System.out.println(i);
            i++; // increase i by 1 each time
        }

        sc.close();
    }
}
