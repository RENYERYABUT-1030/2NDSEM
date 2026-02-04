import java.util.Scanner;

public class Dsc {
    public static void main(String[] args) {


        // do while


        Scanner sc = new Scanner(System.in);
        int num; // variable to store user input

        do {
            System.out.print("Enter a number (0 to stop): ");
            num = sc.nextInt(); // user input

            System.out.println("You entered: " + num);

        } while (num != 0); // loop continues until user types 0

        System.out.println("Program ended.");
        sc.close();
    }
}
