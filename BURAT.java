import java.util.Scanner;

public class BURAT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//print your name repeatedly.
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        for (int i = 1; i <= num; i++) {
            System.out.println("Renyer ");
        }

        sc.close();
    }
}
