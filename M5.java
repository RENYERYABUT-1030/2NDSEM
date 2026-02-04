public class M5 {
    public static void main(String[] args) {
        //square(25);
        System.out.println(square(6));
        //greet("Tanggol");
        System.out.println(greet("StaGento"));
    }

 /*public static void square(int n) {
  int square = n * n;
  System.out.println(square);
 }*/

    static int square(int n) {
        int square = n * n;
        return square;


    }

 /*public static void greet(String name) {
  System.out.println("Hello " + name);
 }*/

    static String greet(String name) {
        return "Hello " + name;
    }

}
