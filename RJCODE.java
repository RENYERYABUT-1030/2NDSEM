package finalsCaseStudyDraft;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RJCODE {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<String[]> accounts = new ArrayList<>(Arrays.asList(
            new String[]{"0123-4567-8901", "Roel Richard", "5000.00", "1111", "Active"},
            new String[]{"2345-6789-0123", "Dorie Marie", "0.00", "2222", "Blocked"},
            new String[]{"3456-7890-1234", "Railee Darrel", "10000.00", "3333", "Active"},
            new String[]{"4567-8901-2345", "Railynne Dessirei", "2500.00", "4444", "Active"},
            new String[]{"5678-9012-3456", "Raine Dessirei", "10000.00", "5555", "Active"}
            //admin account:
            //  number = 0000-000-0000  pass = 0000
    ));

    public static void main(String[] args) {
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("S > Start Transaction");
            System.out.print("Q > Quit\nEnter your choice: ");
            String choice = scanner.next().toUpperCase();
            scanner.nextLine();
            System.out.println();

            if (choice.equals("S")) {
                loginAndProcess();
            } else if (choice.equals("Q")) {
                System.out.println("Thanks for using Richard Gwapo Banking Corporation!");
                isRunning = false;
            } else {
                System.out.println("Invalid input. Try again.\n");
            }
        }
    }

    static void loginAndProcess() {
        System.out.println("LOGIN");
        System.out.println("Enter your account number: ");
        String accountNumber = scanner.nextLine();


        String[] userAccount = null;
        for (String[] account : accounts) {
            if (account[0].equals(accountNumber)) {
                userAccount = account;
                break;
            }
        }

        if (accountNumber.equals("0000-000-0000")){
            System.out.println("Enter admin password");
            int adminPass = scanner.nextInt();
            scanner.nextLine();
            if (adminPass == 0000){
                adminMenu(userAccount);

            }
            else {
                System.out.println("Invalid password");
            }
            return;
        }

        else if (userAccount == null) {
            System.out.println("Account number " + accountNumber + " not found.\n");
            return;
        }

        if (userAccount[4].equalsIgnoreCase("Blocked")) {
            System.out.println("This account is BLOCKED. Please contact the Administrator.\n");
            return;
        }



        int attempts = 0;
        while (attempts < 3) {
            System.out.print("Enter your PIN: ");
            String pin = scanner.nextLine();
            if (userAccount[3].equals(pin)) {
                transactionMenu(userAccount);
                return;
            } else {
                attempts++;
                System.out.println("Invalid PIN. Please try again.\n");
            }
        }

        System.out.println("Too many failed attempts. Account locked.");
        userAccount[4] = "Blocked"; // block after failed tries
    }

    static void transactionMenu(String[] account) {
        boolean transactionRunning = true;

        while (transactionRunning) {
            System.out.println();
            System.out.println("    SELECT TYPE OF TRANSACTION");
            System.out.println("B -> Balance Inquiry");
            System.out.println("W -> Withdrawal");
            System.out.println("D -> Deposit");
            System.out.println("T -> Transfer Fund");
            System.out.println("C -> Cancel");
            System.out.print("Enter the mode: ");
            String choice = scanner.nextLine().toUpperCase();

            switch (choice) {
                case "B" -> showBalance(account);
                case "W" -> withdraw(account);
                case "D" -> deposit(account);
                case "T" -> transfer(account);
                case "C" -> {
                    System.out.println("Transaction has been cancelled.");
                    System.out.println("Thanks for using Richard Gwapo Banking Corporation!");
                    transactionRunning = false;
                }
                default -> System.out.println("Invalid input.");
            }
        }
    }

    static void showBalance(String[] account) {
        System.out.println("\n--- BALANCE INQUIRY ---");
        System.out.println("Account #: " + account[0]);
        System.out.println("Account Name: " + account[1]);
        System.out.println("Balance: ₱" + account[2]);
        System.out.println("Press x to exit");
        scanner.nextLine();
    }
    static void withdraw(String[] account) {
        double balance = Double.parseDouble(account[2]);
        System.out.println("\n--- WITHDRAWAL ---");
        System.out.println("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        if (amount < 100 || amount % 100 != 0) {
            System.out.println("Invalid amount. Must be a multiple of ₱100.");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient funds. Your current balance is ₱" + balance);
            return;
        }

        balance -= amount;
        account[2] = String.format("%.2f", balance);
        System.out.printf("Successfully withdrew ₱%.2f\nNew balance: ₱%.2f\n", amount, balance);
        System.out.println("Press x to exit");
        scanner.nextLine();
    }
    static void deposit(String[] account) {
        double balance = Double.parseDouble(account[2]);
        System.out.println("\n--- DEPOSIT ---");
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        if (amount < 100) {
            System.out.println("Deposit must be at least ₱100.");
            return;
        }

        balance += amount;
        account[2] = String.format("%.2f", balance);
        System.out.printf("Successfully deposited ₱%.2f\nNew balance: ₱%.2f\n", amount, balance);
        System.out.println("Press x to exit");
        scanner.nextLine();
    }
    static void transfer(String[] sender) {
        double senderBalance = Double.parseDouble(sender[2]);
        System.out.println("\n--- TRANSFER ---");
        System.out.print("Enter target account number: ");
        String targetAccNum = scanner.nextLine();

        if (targetAccNum.equals(sender[0])) {
            System.out.println("You cannot transfer to your own account.");
            return;
        }

        String[] receiver = null;
        for (String[] acc : accounts) {
            if (acc[0].equals(targetAccNum)) {
                receiver = acc;
                break;
            }
        }

        if (receiver == null) {
            System.out.println("Target account not found.");
            return;
        }

        if (receiver[4].equalsIgnoreCase("Blocked")) {
            System.out.println("Target account is BLOCKED.");
            return;
        }

        System.out.print("Enter amount to transfer: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        if (amount <= 0) {
            System.out.println("Invalid transfer amount.");
            return;
        }
        if (amount > senderBalance) {
            System.out.println("Insufficient balance. Your current balance: ₱" + senderBalance);
            return;
        }

        double fee = (amount / 1000) * 25;
        if (amount > 1000){
            senderBalance -= fee;
        }
        senderBalance -= amount;
        double receiverBalance = Double.parseDouble(receiver[2]) + amount;

        sender[2] = String.format("%.2f", senderBalance);
        receiver[2] = String.format("%.2f", receiverBalance);

        System.out.printf("Successfully transferred ₱%.2f to %s (%s)\n",
                amount, receiver[1], receiver[0]);
        System.out.println("Deducted fee: " + fee);
        System.out.printf("Your new balance: ₱%.2f\n", senderBalance);
        System.out.println("Press X to exit...");
        scanner.nextLine();
    }
    static void adminMenu(String[] account){
        //output #5: Administrator Viewing Only

        boolean adminRunning = true;
        while(adminRunning) {

            System.out.println("What would you like to do?");
            System.out.println();
            System.out.println("( 1 ) – View Customer Information");
            System.out.println("( 2 ) – Search Customer");
            System.out.println("( 3 ) – Add New Customer");
            System.out.println("( 4 ) – Edit Customer Information");
            System.out.println("( 5 ) – Change Customer Pin Number");
            System.out.println("( 6 ) – Transfer Fund");
            System.out.println("( 7 ) – Activate/Block Account");
            System.out.println("( x ) – Exit");
            System.out.print("\nEnter your choice: ");
            String choice = scanner.nextLine();


            switch (choice) {
                case "1" -> viewCostumerInfo(account);
                case "2" -> System.out.println("Search Customer");
                case "3" -> addNewCostumer(account);
                case "4" -> editCostumerInfo(account);
                case "5" -> changeCostumerPin(account);
                case "6" -> transferFund(account);
                case "7" -> accountActivation(account);
                case "X" -> adminRunning = false;
                default -> {
                    return;
                }
            }
        }

    }
    static void viewCostumerInfo(String[] account){
        System.out.println("Enter the costumer number:");
        String costumerNUm = scanner.nextLine();
        for (String[] acc:accounts){
            if (acc[0].equals(costumerNUm)) {
                System.out.printf("Account #: %s | Name: %s | Balance: %s | pin: %s | Status: %s\n",
                        acc[0], acc[1], acc[2], acc[3], acc[4]);
                System.out.println("\nPress x to exit");
                scanner.nextLine();
                return;
            }
        }
        System.out.println("Costumer not found\n");
    }
    static void addNewCostumer(String[] account){
        System.out.println("    ADD NEW COSTUMER");
        System.out.println("\nEnter account number:");
        String accNum = scanner.nextLine();
        System.out.println("Enter account name:");
        String name = scanner.nextLine();
        System.out.println("Enter account balance:");
        String balance = scanner.nextLine();
        System.out.println("Enter account pin:");
        String pin = scanner.nextLine();
        System.out.println("Enter account Status:");
        String status = scanner.nextLine();

        accounts.add(new String[]{accNum, name, balance, pin, status});
        System.out.println("costumer added to the data base!");
        System.out.println("Press x to exit");
        scanner.nextLine();
    }
    static void editCostumerInfo(String[] account){
        System.out.println("\n  EDIT COSTUMER INFORMATION");
        System.out.println("Enter targer account number");
        String targetAccNum = scanner.nextLine();

        String[] costumer = null;
        for (String[] acc : accounts){
            if (acc[0].equals(targetAccNum)){
                costumer = acc;
                break;
            }
        }
        if (costumer == null){
            System.out.println("Target account not found.");
            return;
        }
        if (costumer[4].equalsIgnoreCase("Blocked")){
            System.out.println("Target account is BLOCKED.");
            return;
        }


        System.out.println("\n  what would you like to edit\n");
        System.out.println("( 1 ) - Costumer number");
        System.out.println("( 2 ) - Costumer name");
        System.out.println("( x ) - Exit");
        System.out.print("\nEnter your choice: ");
        String choice = scanner.nextLine();


        if (choice.equals("1")){
            System.out.print("Enter new costumer number: ");
            String newAccNum = scanner.nextLine();
            costumer[0] = newAccNum;
            System.out.println("ACCOUNT NUMBER HAS BEED UPDATED IN THE DATA BASE SUCCESSFULLY");
        }
        else if (choice.equals("2")) {
            System.out.print("Enter new costumer name: ");
            String newName = scanner.nextLine();
            costumer[1] = newName;
            System.out.println("ACCOUNT NAME HAS BEED UPDATED IN THE DATA BASE SUCCESSFULLY");
        }
        else {
            System.out.println("Invalid choice");
        }
    }
    static void changeCostumerPin(String[] account) {
        System.out.println("    CHANGE COSTUMER PIN");
        System.out.println("Enter targer account number");
        String targetAccNum = scanner.nextLine();

        String[] costumer = null;
        for (String[] acc : accounts) {
            if (acc[0].equals(targetAccNum)) {
                costumer = acc;
                break;
            }
        }
        if (costumer == null) {
            System.out.println("Target account not found.");
            return;
        }
        if (costumer[4].equalsIgnoreCase("Blocked")) {
            System.out.println("Target account is BLOCKED.");
            return;
        }

        String newPin;
        do {
            System.out.print("Enter new 4-digit pin for customer: ");
            newPin = scanner.nextLine();

            if (newPin.length() != 4) {
                System.out.println("Invalid PIN. Please enter exactly 4 digits.");
            }
        } while (newPin.length() != 4);

        costumer[3] = newPin;
        System.out.println("PIN HAS SUCCESSFULLY UPDATED!\n");
    }
    static void transferFund(String[] account){


        System.out.println("    TRANSFER FUND");
        System.out.print("Enter costumer1 account number: ");
        String costumer1AccNum = scanner.nextLine();

        String[] costumer1 = null;
        for (String[] acc1 : accounts) {
            if (acc1[0].equals(costumer1AccNum)) {
                costumer1 = acc1;
                break;
            }
        }
        if (costumer1 == null) {
            System.out.println("Target account not found.");
            return;
        }
        if (costumer1[4].equalsIgnoreCase("Blocked")) {
            System.out.println("Target account is BLOCKED.");
            return;
        }


        System.out.print("Enter costumer2 account number: ");
        String costumer2AccNum = scanner.nextLine();
        String[] costumer2 = null;
        for (String[] acc2 : accounts) {
            if (acc2[0].equals(costumer2AccNum)) {
                costumer2 = acc2;
                break;
            }
        }
        if (costumer2 == null) {
            System.out.println("Target account not found.");
            return;
        }
        if (costumer2[4].equalsIgnoreCase("Blocked")) {
            System.out.println("Target account is BLOCKED.");
            return;
        }

        double costumer1Balance =  Double.parseDouble(costumer1[2]);
        double costumer2Balance =  Double.parseDouble(costumer1[2]);

        System.out.println("Enter an amount to transfer from costumer1 to costumer2");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        if (amount <= 0) {
            System.out.println("Invalid transfer amount.");
            return;
        }
        if (amount > costumer1Balance) {
            System.out.println("Insufficient balance. Your current balance: ₱" + costumer1Balance);
            return;
        }

        costumer1Balance -= amount;
        costumer2Balance += amount;
        costumer1[2] = String.format("%.2f", costumer1Balance);
        costumer2[2] = String.format("%.2f", costumer2Balance);

        System.out.println("ACCOUNT BALANCE FOR BOTH ACCOUNT HAS BEEN UPDATES SUCCESSFULLY!");
    }
    static void accountActivation(String[] account){
        System.out.println("    ACCOUNT ACTIVATION/BLOCK");
        System.out.print("Enter an account number: ");
        String accNUm= scanner.nextLine();

        String[] target = null;
        for (String[] acc : accounts){
            if( acc[0].equals(accNUm)){
                target = acc;
                break;
            }
        }
        if (target == null) {
            System.out.println("Target account not found.");
            return;
        }

        if (target[4].equalsIgnoreCase("Blocked")) {
            System.out.println("Target account is BLOCKED.");
            return;
        }

        System.out.println("( 1 ) - Block the account");
        System.out.println("( 2 ) - Activate the account");
        System.out.print("\nEnter your choice: ");
        int choice = scanner.nextInt();


        if (choice == 1){
            target[4] = "Blocked";
        } else if (choice == 2) {
            target[4] = "Active";
        }
        else {
            System.out.println("Invalid choice.");
            return;
        }
        System.out.println("ACCOUNT STATUS HAS BEEN SUCCESSFULLY UPDATED");

    }
}