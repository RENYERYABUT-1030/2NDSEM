import java.util.Scanner;

public class jgh  {
    public static void main(String[] args) {
       //

        Scanner sc = new Scanner(System.in);

        System.out.print("Start at: ");
        int start = sc.nextInt();

        System.out.print("End at: ");
        int end = sc.nextInt();

        for (int i = start; i <= end; i++) {
            System.out.print(i);
            if (i < end) {
                System.out.print(", ");
            }
        }

        sc.close();
    }
}
