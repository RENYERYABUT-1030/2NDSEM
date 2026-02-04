import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
public class JPCODENYA {

    static ArrayList<String> accnum = new ArrayList<>();
    static ArrayList<String> accnam = new ArrayList<>();
    static ArrayList<Double> balanc = new ArrayList<>();
    static ArrayList<String> pinnum = new ArrayList<>();
    static ArrayList<String> status = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {


        accnum.add("0123-4567-8901");
        accnam.add("Roel Richard");
        balanc.add(5000.0);
        pinnum.add("1111");
        status.add("Active");

        accnum.add("2345-6789-0123");
        accnam.add("Dorie Marie");
        balanc.add(0.00);
        pinnum.add("2222");
        status.add("Blocked");

        accnum.add("3456-7890-1234");
        accnam.add("Railee Darrel");
        balanc.add(10000.0);
        pinnum.add("3333");
        status.add("Active");

        accnum.add("4567-8901-2345");
        accnam.add("Railynne Dessirei");
        balanc.add(2500.0);
        pinnum.add("4444");
        status.add("Active");

        accnum.add("5678-9012-3456");
        accnam.add("Raine Dessirei");
        balanc.add(10000.0);
        pinnum.add("5555");
        status.add("Active");

        Startmenu();
    }

    public static void Startmenu() {
        while (true) {
            MBC();
            System.out.println("        S -> Start Transaction     ");
            System.out.println("        Q -> Quit                  ");
            System.out.print("\n       Enter Your Choice: ");

            String choice = sc.nextLine().toUpperCase();

            if (choice.equals("S")) {
                Login();
                return;
            } else if (choice.equals("Q")) {
                System.out.println("\n       Ayaw mo? Tapon ko to");
                return;
            } else {
                System.out.println("\t\tParang mali");
            }
        }
    }

    public static void Login() {
        MBC();
        System.out.println("               LOGIN               ");
        System.out.print("     Enter your account number:\n          ");
        String acnum = sc.nextLine();
        int hehe = accnum.indexOf(acnum);

        if (acnum.equals("0000-000-0000")) {
            System.out.print("       Enter Your pin number:\n               ");
            String adminPin = sc.nextLine().trim();
            if (adminPin.equals("0000")) {
                System.out.println("Welcome Admin");
                adminMenu();
            } else {
                System.out.println("    Invalid Admin PIN. Return to Main Menu.   ");
            }
        }
        if (hehe == -1) {
            System.out.println("Account Not Found!");
            Startmenu();
            return;
        } else if (status.get(hehe).equalsIgnoreCase("Blocked")) {
            System.out.println("    This Account is Blocked!");
            Startmenu();
            return;
        }
        int attempt = 3;
        while (attempt > 0) {
            System.out.print("       Enter Your pin number:\n               ");
            String pennum = sc.nextLine();

            if (pinnum.get(hehe).equalsIgnoreCase(pennum)) {
                transactionMenu(hehe);
                return;
            }
            attempt--;
            System.out.println("   Incorrect PIN. Attempt Left : " + attempt);
        }
        System.out.println("CAPTURED CARD.... PLEASE CALL 143-44");
        status.set(hehe, "Blocked");
    }

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
            String choice = sc.nextLine().toUpperCase();

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
            } else {
                System.out.println("Invalid Input");
            }
        }
    }

    public static void balanceInq(int i) {
        MBC();
        System.out.println("          BALANCE INQUIRY          \n");
        System.out.println("    Account #:      " + accnum.get(i));
        System.out.println("    Account Name:   " + accnam.get(i));
        System.out.println("    Balance:        " + balanc.get(i));
        System.out.println("\n        Press X to Exit ");
        System.out.println(">");
        String x = sc.nextLine();
    }

    public static void withdrawal(int i) {
        MBC();
        System.out.println("   Amount should not be lower than ₱100\n");
        System.out.println("            Withdrawal              ");
        System.out.print("     Enter amount to be withdrawn\n         ");
        double with = sc.nextInt();
        double amount = (with);
        if (amount <= 100 || amount % 100 != 0) {
            System.out.println("kelangan 100 pataas tas walang decimal 100 petot dapat gap");
            return;
        } else if (balanc.get(i) < amount) {
            System.out.println("Insuficient balance tanga");
        } else {
            double newBal = (balanc.get(i)) - amount;
            balanc.set(i, newBal);
            System.out.println(amount + "Succesfully Deducted from your Account");
            System.out.println("Your new balance is: " + newBal);
        }
        System.out.println("          Press X to Exit      ");
        String x = sc.nextLine();
    }

    public static void deposit(int i) {
        MBC();
        System.out.println("              DEPOSIT               \n");
        System.out.print("    Enter amount to be deposited\n          ");
        double depusit = sc.nextInt();
        double amount = (depusit);

        if (amount <= 100) {
            System.out.println("kelangan 100 pataas ");
            return;
        } else {
            double newBal = (balanc.get(i)) + amount;
            balanc.set(i, newBal);
            System.out.println(amount + "Succesfully Added from your Account");
            System.out.println("Your new balance is: " + newBal);
        }
        System.out.println("          Press X to Exit      ");
        String x = sc.nextLine();
    }

    public static void transfer(int i) {
        MBC();
        System.out.println("           TRANSFER FUND           \n");
        System.out.print("   Transfer to <enter account #>: \n          ");
        String transfer = sc.nextLine();
        int hehe = accnum.indexOf(transfer);
        if (hehe == -1) {
            System.out.println("Account Not Found!");
            transactionMenu(i);
            return;
        } else if (status.get(hehe).equalsIgnoreCase("Blocked")) {
            System.out.println("    This Account is Blocked!");
            return;
        }
        System.out.print("                Amount:  \n            ");
        double amount = sc.nextInt();
        double newamount = (amount);

        if (amount < 1000) {
            System.out.println("kelangan 1000 pataas");
            return;
        } else if (balanc.get(i) < newamount) {
            System.out.println("Insufficiet Balance bobo");
            return;
        } else {
            int thousands = (int) (newamount / 1000);
            double fee = 25 * thousands;
            double current = newamount - fee;
            balanc.set(i, balanc.get(i) - newamount);
            balanc.set(hehe, balanc.get(hehe) + current);
            System.out.println("Succesfully Transfered: " + newamount);
            System.out.println("Deducted from Account: " + fee);
            System.out.println("           Press X to Exit          ");
            String x = sc.nextLine();
            return;
        }
    }

    public static void adminMenu() {
        while (true) {
            MBC();
            System.out.println("           What would you like to do?\n");
            System.out.println("          ( 1 ) – View Customer Information");
            System.out.println("          ( 2 ) – Search Customer");
            System.out.println("          ( 3 ) – Add New Customer");
            System.out.println("          ( 4 ) – Edit Customer Information (Name only)");
            System.out.println("          ( 5 ) – Change Customer Pin Number");
            System.out.println("          ( 6 ) – Transfer Fund");
            System.out.println("          ( 7 ) – Activate/Block Account");
            System.out.println("          ( X ) – Exit\n");
            System.out.print("Enter your choice: ");
            String ch = sc.nextLine().toUpperCase();

            switch (ch) {
                case ("1"):
                    ViewCustomer();
                    break;
                case ("2"):
                    searchCustomer();
                    break;
                case ("3"):
                    AddnewCustomer();
                    break;
                case ("4"):
                    EditCustomer();
                    break;
                case ("5"):
                    ChangePin();
                    break;
                case ("6"):
                    Transferfund();
                    break;
                case ("7"):
                    Status();
                case ("X"):
                    Startmenu();
                default:
                    System.out.println("Wrong Input. Try Again ");
            }
        }
    }

    public static void ViewCustomer() {
        MBC();
        System.out.println("                    All Accounts                  ");
        for (int i = 0; i < accnam.size(); i++) {
            System.out.println("-------------------------------------------------");
            System.out.println("       Account #:      " + accnum.get(i));
            System.out.println("       Account Name:   " + accnam.get(i));
            System.out.println("       Balance:        " + balanc.get(i));
            System.out.println("       Pin:            " + pinnum.get(i));
            System.out.println("       Status:         " + status.get(i));
        }
        System.out.println("           Press X to Exit          ");
        String x = sc.nextLine();
        return;

    }

    public static void searchCustomer() {
        MBC();
        System.out.println("                    Search Account               ");
        System.out.println("                   Account Number: \n            ");
        String choice = sc.nextLine();
        int hehe = accnum.indexOf(choice);
        System.out.println("       Account #:      " + accnum.get(hehe));
        System.out.println("       Account Name:   " + accnam.get(hehe));
        System.out.println("       Balance:        " + balanc.get(hehe));
        System.out.println("       Pin:            " + pinnum.get(hehe));
        System.out.println("       Status:         " + status.get(hehe));
        System.out.println("                  X to Exit");
        String x = sc.nextLine();
    }

    public static void AddnewCustomer() {
        MBC();
        System.out.println("       Enter Account Number (XXXX-XXXX-XXXX) :         ");
        String n = sc.nextLine();
        if (accnum.contains(n)) {
            System.out.println("Account Number Already Exist! ");
        }
        System.out.println("       Enter Account Name:        ");
        String a = sc.nextLine();
        System.out.println("       Initial Balance:             ");
        double b = sc.nextInt();
        sc.nextLine();
        System.out.println("       Enter Pin Number(4) Digits:\n          ");
        String p = sc.nextLine();


        if (p.length() != 4) {
            System.out.println("maling pin");
            return;
        } else if (p.length() == 0) {
            System.out.println("Need Pin");
            return;
        }
        accnum.add(n);
        accnam.add(a);
        balanc.add(b);
        pinnum.add(p);
        status.add("Active");

        System.out.println("Succesfully added Account!");
        System.out.println("Account Is Active");
        System.out.println(" X To Exit ");
        String x = sc.nextLine();
        return;

    }

    public static void EditCustomer() {
        MBC();
        System.out.println("            Edit Customer Name       ");
        System.out.println("            Enter Customer Number:   ");
        String num = sc.nextLine().trim();
        int endex = accnum.indexOf(num);
        if (accnum.contains(num)) {
            System.out.println("        Old Name: " + accnam.get(endex));
            System.out.println("        Enter New Name: \n        ");
            String newnam = sc.nextLine();
            accnam.set(endex, newnam);
            System.out.println("Successfully Replaced! ");
            System.out.println(" X To Exit ");
            String x = sc.nextLine();
            return;
        }
    }

    public static void ChangePin() {
        MBC();
        System.out.println("            Edit Customer Pin       ");
        System.out.println("            Enter Customer Number:   ");
        String num = sc.nextLine().trim();
        int endex = accnum.indexOf(num);
        if (accnum.contains(num)) {
            System.out.println("        Old Pin: " + pinnum.get(endex));
            System.out.println("        Enter New Pin: \n        ");
            String newPin = sc.nextLine();
            pinnum.set(endex, newPin);
            System.out.println("Successfully Replaced! ");
            System.out.println(" X To Exit ");
            String x = sc.nextLine();
            return;
        }
    }

    public static void Transferfund() {
        MBC();
        System.out.println("           TRANSFER FUND           \n");
        System.out.print("   Transfer to <enter account #>: \n          ");
        String transfer = sc.nextLine();
        int hehe = accnum.indexOf(transfer);
        if (hehe == -1) {
            System.out.println("Account Not Found!");
            adminMenu();
            return;
        } else if (status.get(hehe).equalsIgnoreCase("Blocked")) {
            System.out.println("    This Account is Blocked!");
            return;
        }
        System.out.print("   Deducted to <enter account #>: \n          ");
        String deduct = sc.nextLine();
        int heh = accnum.indexOf(deduct);
        if (hehe == -1) {
            System.out.println("Account Not Found!");
            adminMenu();
            return;
        } else if (status.get(hehe).equalsIgnoreCase("Blocked")) {
            System.out.println("    This Account is Blocked!");
            return;
        }
        System.out.print("                Amount:  \n            ");
        double amount = sc.nextInt();
        double newamount = (amount);

        if (amount < 1000) {
            System.out.println("kelangan 1000 pataas");
            return;
        } else if (balanc.get(hehe) < newamount) {
            System.out.println("Insufficiet Balance bobo");
            return;
        } else {
            int thousands = (int) (newamount / 1000);
            double fee = 25 * thousands;
            double current = newamount - fee;
            balanc.set(hehe, balanc.get(hehe) - newamount);
            balanc.set(heh, balanc.get(heh) + current);
            System.out.println("Succesfully Transfered: " + newamount);
            System.out.println("Deducted from Account: " + fee);
            System.out.println("           Press X to Exit          ");
            String x = sc.nextLine();
            return;
        }
    }

    public static void Status() {
        MBC();
        System.out.println("            Edit Status");
        System.out.println("       Enter Customer Number:  ");
        String num = sc.nextLine().trim();

        int index = accnum.indexOf(num);

        if (index == -1) {
            System.out.println("Account Not Found!");
            sc.nextLine();
            return;
        }

        String current = status.get(index);
        System.out.println("    Current Status: " + current);
        System.out.println("      (1) Active");
        System.out.println("      (2) Blocked");
        System.out.print("         Status: ");

        String choice = sc.nextLine().trim();

        if (choice.equals("1")) {
            if (current.equals("Active")) {
                System.out.println("This account is already ACTIVE.");
                adminMenu();
            } else {
                status.set(index, "Active");
                System.out.println("Account successfully set to ACTIVE.");
                System.out.println("Press X to exit");
                sc.nextLine();
                adminMenu();
            }
        }
        else if (choice.equals("2")) {
            if (current.equals("Blocked")) {
                System.out.println("This account is already BLOCKED.");
                adminMenu();
            } else {
                status.set(index, "Blocked");
                System.out.println("Account successfully set to BLOCKED.");
                System.out.println("Press X to exit");
                sc.nextLine();
                adminMenu();
            }
        }
        else {
            System.out.println("Invalid choice!");
            adminMenu();
        }

        System.out.println("Press X to exit");
        sc.nextLine();
        adminMenu();
    }



    public static void MBC() {
        System.out.println("-------------------------------------------------");
        System.out.println("                         MBC                     ");
        System.out.println("             Mangkanor Banking Corruption        ");
        System.out.println("-------------------------------------------------\n");

    }
}
