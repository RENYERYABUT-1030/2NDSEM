import java.util.Scanner;

public class Minigrocerry{

    public static void main(String[] args) {
        // 1. SETUP DATA (2D Array with mixed Text and Numbers)
        // Format: { "Name", "Price", "Code", "Stock" }
        String[][] inventory = {
                {"Apple", "35", "APL001", "50"},
                {"Milk", "75", "MLK002", "30"},
                {"Bread", "55", "BRD003", "25"},
                {"Eggs", "120", "EGG004", "100"},
                {"Rice", "950", "RCE005", "10"}
        };

        // 2. CALL METHODS
        displayTable(inventory);
        displayStats(inventory);
        searchItem(inventory);
    }

    // --- METHOD 1: Display the Table (Matches Output Sample) ---
    public static void displayTable(String[][] data) {
        System.out.println("-------------------------------------------------");
        System.out.printf("%-10s | %-7s | %-8s | %-5s%n", "Item", "Price", "Code", "Stock");
        System.out.println("-----------|---------|----------|-------");

        for (int i = 0; i < data.length; i++) {
            System.out.printf("%-10s | %-7s | %-8s | %-5s%n",
                    data[i][0], // Name
                    data[i][1], // Price
                    data[i][2], // Code
                    data[i][3]  // Stock
            );
        }
        System.out.println("-------------------------------------------------");
    }

    // --- METHOD 2: Show Statistics (Total, High Stock, Low Price) ---
    public static void displayStats(String[][] data) {
        int totalStock = 0;
        int highestStock = -1;
        String highestStockName = "";
        int lowestPrice = 999999;
        String lowestPriceName = "";

        for (int i = 0; i < data.length; i++) {
            // Convert String to Int for math
            int price = Integer.parseInt(data[i][1]);
            int stock = Integer.parseInt(data[i][3]);

            // 1. Add to Total
            totalStock += stock;

            // 2. Check Highest Stock
            if (stock > highestStock) {
                highestStock = stock;
                highestStockName = data[i][0];
            }

            // 3. Check Lowest Price
            if (price < lowestPrice) {
                lowestPrice = price;
                lowestPriceName = data[i][0];
            }
        }

        System.out.println("Total items in stock: " + totalStock);
        System.out.println("Product with highest stock: " + highestStockName + " (" + highestStock + ")");
        System.out.println("Product with lowest price:  " + lowestPriceName + " (" + lowestPrice + ")");
        System.out.println("-------------------------------------------------");
    }

    // --- METHOD 3: Search with IGNORE CASE ---
    public static void searchItem(String[][] data) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter product name or code to search: ");
        String input = sc.nextLine();

        boolean found = false;

        for (int i = 0; i < data.length; i++) {
            // HERE IS THE IGNORE CASE LOGIC:
            // checks Name (index 0) OR Code (index 2)
            if (data[i][0].equalsIgnoreCase(input) || data[i][2].equalsIgnoreCase(input)) {

                System.out.println("\n>> ITEM FOUND <<");
                System.out.println("Item:  " + data[i][0]);
                System.out.println("Price: " + data[i][1]);
                System.out.println("Code:  " + data[i][2]);
                System.out.println("Stock: " + data[i][3]);

                found = true;
                break; // Stop looking once found
            }
        }

        if (found == false) {
            System.out.println("Product not found.");
        }
    }
}