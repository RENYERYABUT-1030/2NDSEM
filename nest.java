import java.util.Scanner;

public class nest{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter row #: ");
        int r = scan.nextInt();
        System.out.print("Enter col #: ");

        int c = scan.nextInt();

        for(int x=1; x<=r; x++) {
            for(int y=1; y<=c; y++) {
                System.out.print(y*x + "\t");
            }
            System.out.println();
        }
    }
}