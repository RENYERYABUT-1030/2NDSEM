// Import necessary libraries
import java.util.ArrayList;
import java.util.Scanner;

public class mongjopt {

    // Arrays to store account details
    static ArrayList<String> accnum = new ArrayList<>();   // Account Numbers
    static ArrayList<String> accnam = new ArrayList<>();   // Account Names
    static ArrayList<Double> balanc = new ArrayList<>();   // Account Balances
    static ArrayList<String> pinnum = new ArrayList<>();   // PIN Numbers
    static ArrayList<String> status = new ArrayList<>();   // Account Status (Active/Blocked)

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Preloaded accounts
        accnum.add("0123-4567-8901"); accnam.add("Roel Richard"); balanc.add(5000.00); pinnum.add("1111"); status.add("Active");
        accnum.add("2345-6789-0123"); accnam.add("Dorie Marie"); balanc.add(0.00); pinnum.add("2222"); status.add("Blocked");
        accnum.add("3456-7890-1234"); accnam.add("Railee Darrel"); balanc.add(10000.00); pinnum.add("3333"); status.add("Active");
        accnum.add("4567-8901-2345"); accnam.add("Railynne Dessirei"); balanc.add(2500.00); pinnum.add("4444"); status.add("Active");
        accnum.add("5678-9012-3456"); accnam.add("Raine Dessirei"); balanc.add(10000.00); pinnum.add("5555"); status.add("Active");

        Startmenu();
    }

    // Displays the start menu
    public static void Startmenu() {
        while (true) {
            MBC();
            System.out.println("        S -> Start Transaction     ");
            System.out.println("        Q -> Quit                  ");
            System.out.print("\n       Enter Your Choice: ");

            String choice = sc.nextLine().toUpperCase().trim();

            if (choice.equals("S")) {
                Login();
                return;
            } else if (choice.equals("Q")) {
                System.out.println("\n       Program Terminated.");
                return;
            } else {
                System.out.println("\nInvalid Choice, please try again.");
            }
        }
    }

    // Handles login process for both user and admin
    public static void Login() {
        MBC();
        System.out.println("               LOGIN               ");
        System.out.print("     Enter your account number:\n          ");
        String acnum = sc.nextLine().trim();
        int hehe = accnum.indexOf(acnum);

        // Admin login
        if (acnum.equals("0000-000-0000")) {
            System.out.print("       Enter Your PIN number:\n               ");
            String adminPin = sc.nextLine().trim();
            if (adminPin.equals("0000")) {
                System.out.println("Welcome Admin");
                adminMenu();
            } else {
                System.out.println("    Invalid Admin PIN. Returning to Main Menu.   ");
            }
        }

        // Account validation
        if (hehe == -1) {
            System.out.println("\n\t     Account Not Found!");
            Startmenu();
            return;
        } else if (status.get(hehe).equalsIgnoreCase("Blocked")) {
            System.out.println("\n\t     This Account is Blocked!");
            Startmenu();
            return;
        }

        // PIN attempts
        int attempt = 3;
        while (attempt > 0) {
            System.out.print("       Enter Your PIN number:\n               ");
            String pennum = sc.nextLine().trim();

            if (pinnum.get(hehe).equalsIgnoreCase(pennum)) {
                transactionMenu(hehe);
                return;
            }
            attempt--;
            System.out.println("   Incorrect PIN. Attempts Left: " + attempt);
        }
        System.out.println(" CARD CAPTURED.... PLEASE CALL CUSTOMER SERVICE 143-44");
        status.set(hehe, "Blocked");
    }

    // Transaction menu for customers
    public static void transactionMenu(int i) {
        while (true) {
            MBC();
            System.out.println("     SELECT TYPE OF TRANSACTION    \n");
            System.out.println("    B -> Balance Inquiry");
            System.out.println("    W -> Withdrawal");
            System.out.println("    D -> Deposit");
            System.out.println("    T -> Transfer Fund           ");
            System.out.println("    C -> Cancel\n");
            System.out.print("    Enter transaction type: ");
            String choice = sc.nextLine().toUpperCase().trim();

            if (choice.equals("B")) {
                balanceInq(i);
            } else if (choice.equals("W")) {
                withdrawal(i);
            } else if (choice.equals("D")) {
                deposit(i);
            } else if (choice.equals("T")) {
                transfer(i);
            } else if (choice.equals("C")) {
                Startmenu();
            }
        }
    }

    // Balance Inquiry
    public static void balanceInq(int i) {
        MBC();
        System.out.println("          BALANCE INQUIRY          \n");
        System.out.println("    Account #:      " + accnum.get(i));
        System.out.println("    Account Name:   " + accnam.get(i));
        System.out.println("    Balance:        ₱" + balanc.get(i));
        System.out.println("\n        Press X to Exit ");
        String x = sc.nextLine().trim();
    }

    // Withdrawal transaction
    public static void withdrawal(int i) {
        MBC();
        System.out.println("   Amount should not be lower than ₱100\n");
        System.out.println("            WITHDRAWAL              ");
        System.out.print("     Enter amount to be withdrawn\n         ");
        double with = sc.nextDouble();
        sc.nextLine();

        if (with < 100 || with % 100 != 0) {
            System.out.println("Invalid amount. Must be at least ₱100 and a multiple of 100.");
        } else if (balanc.get(i) < with) {
            System.out.println("Insufficient balance.");
        } else {
            double newBal = balanc.get(i) - with;
            balanc.set(i, newBal);
            System.out.println("₱" + with + " successfully withdrawn from your account.");
            System.out.println("Your new balance is: ₱" + newBal);
        }

        System.out.println("\n        Press X to Exit ");
        String x = sc.nextLine().trim();
    }

    // Deposit transaction
    public static void deposit(int i) {
        MBC();
        System.out.println("              DEPOSIT               \n");
        System.out.print("    Enter amount to be deposited\n          ");
        double depusit = sc.nextDouble();
        sc.nextLine();

        if (depusit < 100) {
            System.out.println("   Amount must be at least ₱100.");
        } else {
            double newBal = balanc.get(i) + depusit;
            balanc.set(i, newBal);
            System.out.println("₱" + depusit + " successfully deposited to your account.");
            System.out.println("Your new balance is: ₱" + newBal);
        }
        System.out.println("\n        Press X to Exit ");
        String x = sc.nextLine().trim();
    }

    // Transfer funds between accounts (customer transaction)
    public static void transfer(int i) {
        MBC();
        System.out.println("           TRANSFER FUND           \n");
        System.out.print("   Transfer to <enter account #>: \n          ");
        String transfer = sc.nextLine();

        int hehe = accnum.indexOf(transfer);
        if (hehe == -1) {
            System.out.println("   Account Not Found!");
            transactionMenu(i);
            return;
        } else if (status.get(hehe).equalsIgnoreCase("Blocked")) {
            System.out.println("    This Account is Blocked!");
            return;
        }

        System.out.print("    Enter amount to transfer (minimum ₱1000):  \n            ");
        double amount = sc.nextInt();
        sc.nextLine(); // consume newline

        if (amount < 1000) {
            System.out.println("   Invalid amount. Must be at least ₱1000.");
            return;
        } else if (balanc.get(i) < amount) {
            System.out.println("   Insufficient balance.");
            return;
        } else {
            int thousands = (int) (amount / 1000);
            double fee = 25 * thousands; // ₱25 fee per ₱1000 transferred
            double creditedAmount = amount - fee;

            // Deduct from sender
            balanc.set(i, balanc.get(i) - amount);
            // Credit to receiver
            balanc.set(hehe, balanc.get(hehe) + creditedAmount);

            System.out.println("   Successfully Transferred: ₱" + amount);
            System.out.println("   Transaction Fee Deducted: ₱" + fee);
            System.out.println("   Net Amount Credited: ₱" + creditedAmount);

            System.out.println("\n           Press X to Exit          ");
            String x = sc.nextLine().trim();
            return;
        }
    }

    // Admin menu for managing customer accounts
    public static void adminMenu() {
        while (true) {
            MBC();
            System.out.println("           ADMIN MENU\n");
            System.out.println("          ( 1 ) – View Customer Information");
            System.out.println("          ( 2 ) – Search Customer");
            System.out.println("          ( 3 ) – Add New Customer");
            System.out.println("          ( 4 ) – Edit Customer Information (Name only)");
            System.out.println("          ( 5 ) – Change Customer PIN Number");
            System.out.println("          ( 6 ) – Transfer Fund");
            System.out.println("          ( 7 ) – Activate/Block Account");
            System.out.println("          ( X ) – Exit\n");
            System.out.print("Enter your choice: ");
            String ch = sc.nextLine().toUpperCase().trim();

            switch (ch) {
                case "1":
                    ViewCustomer();
                    break;
                case "2":
                    searchCustomer();
                    break;
                case "3":
                    AddnewCustomer();
                    break;
                case "4":
                    EditCustomer();
                    break;
                case "5":
                    ChangePin();
                    break;
                case "6":
                    Transferfund();
                    break;
                case "7":
                    Status();
                    break;
                case "X":
                    Startmenu();
                    return;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }
    }

    // Displays all customer accounts
    public static void ViewCustomer() {
        MBC();
        System.out.println("                    ALL ACCOUNTS                  ");
        for (int i = 0; i < accnam.size(); i++) {
            System.out.println("-------------------------------------------------");
            System.out.println("       Account #:      " + accnum.get(i));
            System.out.println("       Account Name:   " + accnam.get(i));
            System.out.println("       Balance:        ₱" + balanc.get(i));
            System.out.println("       PIN:            " + pinnum.get(i));
            System.out.println("       Status:         " + status.get(i));
        }
        System.out.println("           Press X to Exit          ");
        String x = sc.nextLine().trim();
    }

    // Search for a specific customer by account number
    public static void searchCustomer() {
        MBC();
        System.out.println("                    SEARCH ACCOUNT               ");
        System.out.print("                   Account Number: \n            ");
        String choice = sc.nextLine();

        int hehe = accnum.indexOf(choice);
        if (hehe == -1) {
            System.out.println("Account Not Found!");
        } else {
            System.out.println("       Account #:      " + accnum.get(hehe));
            System.out.println("       Account Name:   " + accnam.get(hehe));
            System.out.println("       Balance:        ₱" + balanc.get(hehe));
            System.out.println("       PIN:            " + pinnum.get(hehe));
            System.out.println("       Status:         " + status.get(hehe));
        }

        System.out.println("                  Press X to Exit");
        String x = sc.nextLine();
    }

    // Add a new customer account
    public static void AddnewCustomer() {
        MBC();
        System.out.print("       Enter Account Number (XXXX-XXXX-XXXX): ");
        String n = sc.nextLine();
        if (accnum.contains(n)) {
            System.out.println("Account Number Already Exists!");
            return;
        }

        System.out.print("       Enter Account Name: ");
        String a = sc.nextLine();
        System.out.print("       Initial Balance: ");
        double b = sc.nextDouble();
        sc.nextLine();
        System.out.print("       Enter PIN Number (4 Digits): ");
        String p = sc.nextLine();

        if (p.length() != 4) {
            System.out.println("PIN must be exactly 4 digits.");
            return;
        }

        accnum.add(n);
        accnam.add(a);
        balanc.add(b);
        pinnum.add(p);
        status.add("Active");

        System.out.println("Successfully added new account!");
        System.out.println("Account is set to ACTIVE.");
        System.out.println("Press X to Exit");
        String x = sc.nextLine();
    }

    // Edit customer name by account number
    public static void EditCustomer() {
        MBC();
        System.out.println("            EDIT CUSTOMER NAME       ");
        System.out.print("            Enter Customer Number:   ");
        String num = sc.nextLine().trim();
        int endex = accnum.indexOf(num);

        if (endex == -1) {
            System.out.println("Account Not Found!");
            return;
        }

        System.out.println("        Old Name: " + accnam.get(endex));
        System.out.print("        Enter New Name: ");
        String newnam = sc.nextLine();
        accnam.set(endex, newnam);

        System.out.println("   Customer name successfully updated!");
        System.out.println("   Press X to Exit ");
        String x = sc.nextLine();
    }

    // Change customer PIN by account number
    public static void ChangePin() {
        MBC();
        System.out.println("            EDIT CUSTOMER PIN       ");
        System.out.print("            Enter Customer Number:   ");
        String num = sc.nextLine().trim();
        int endex = accnum.indexOf(num);

        if (endex == -1) {
            System.out.println("Account Not Found!");
            return;
        }

        System.out.println("        Old PIN: " + pinnum.get(endex));
        System.out.print("        Enter New PIN (4 Digits): ");
        String newPin = sc.nextLine();

        if (newPin.length() != 4) {
            System.out.println("PIN must be exactly 4 digits.");
            return;
        }

        pinnum.set(endex, newPin);
        System.out.println("   PIN successfully updated!");
        System.out.println("   Press X to Exit ");
        String x = sc.nextLine();
    }

    // Transfer funds between accounts (admin version)
    public static void Transferfund() {
        MBC();
        System.out.println("           ADMIN TRANSFER FUND           \n");
        System.out.print("   Transfer to <enter account #>: ");
        String transfer = sc.nextLine();
        int receiverIndex = accnum.indexOf(transfer);

        if (receiverIndex == -1) {
            System.out.println("Account Not Found!");
            return;
        } else if (status.get(receiverIndex).equalsIgnoreCase("Blocked")) {
            System.out.println("This Account is Blocked!");
            return;
        }

        System.out.print("   Deducted from <enter account #>: ");
        String deduct = sc.nextLine();
        int senderIndex = accnum.indexOf(deduct);

        if (senderIndex == -1) {
            System.out.println("Account Not Found!");
            return;
        } else if (status.get(senderIndex).equalsIgnoreCase("Blocked")) {
            System.out.println("This Account is Blocked!");
            return;
        }

        System.out.print("                Enter Amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();

        if (amount < 1000) {
            System.out.println("Amount must be at least ₱1000.");
            return;
        } else if (balanc.get(senderIndex) < amount) {
            System.out.println("Insufficient Balance.");
            return;
        } else {
            int thousands = (int) (amount / 1000);
            double fee = 25 * thousands;
            double creditedAmount = amount - fee;

            balanc.set(senderIndex, balanc.get(senderIndex) - amount);
            balanc.set(receiverIndex, balanc.get(receiverIndex) + creditedAmount);

            System.out.println("Successfully Transferred: ₱" + amount);
            System.out.println("Transaction Fee Deducted: ₱" + fee);
            System.out.println("Net Amount Credited: ₱" + creditedAmount);

            System.out.println("           Press X to Exit          ");
            String x = sc.nextLine();
        }
    }

    // Change account status (Active/Blocked)
    public static void Status() {
        MBC();
        System.out.println("            EDIT ACCOUNT STATUS");
        System.out.print("       Enter Customer Number:  ");
        String num = sc.nextLine().trim();

        int index = accnum.indexOf(num);

        if (index == -1) {
            System.out.println("Account Not Found!");
            return;
        }

        String current = status.get(index);
        System.out.println("    Current Status: " + current);
        System.out.println("      (1) Active");
        System.out.println("      (2) Blocked");
        System.out.print("         Enter New Status: ");

        String choice = sc.nextLine().trim();

        if (choice.equals("1")) {
            if (current.equals("Active")) {
                System.out.println("This account is already ACTIVE.");
            } else {
                status.set(index, "Active");
                System.out.println("Account successfully set to ACTIVE.");
            }
        } else if (choice.equals("2")) {
            if (current.equals("Blocked")) {
                System.out.println("This account is already BLOCKED.");
            } else {
                status.set(index, "Blocked");
                System.out.println("Account successfully set to BLOCKED.");
            }
        } else {
            System.out.println("Invalid choice!");
        }

        System.out.println("Press X to Exit");
        String x = sc.nextLine();
    }

    // Displays the bank header/banner for menus
    public static void MBC() {
        System.out.println("-------------------------------------------------");
        System.out.println("                     MBC                         ");
        System.out.println("         Mangkanor Banking Contractors           ");
        System.out.println("-------------------------------------------------\n");
    }
}
