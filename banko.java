import java.util.*;

public class banko {

    static class Account {
        String accNo, name, status;
        double balance;
        int pin;

        Account(String accNo, String name, double balance, int pin, String status) {
            this.accNo = accNo;
            this.name = name;
            this.balance = balance;
            this.pin = pin;
            this.status = status;
        }
    }

    static ArrayList<Account> accounts = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        initializeAccounts();
        mainMenu();
    }

    static void initializeAccounts() {
        accounts.add(new Account("0123-4567-8901", "Roel Richard", 5000.00, 1111, "Active"));
        accounts.add(new Account("2345-6789-0123", "Dorie Marie", 0.00, 2222, "Blocked"));
        accounts.add(new Account("3456-7890-1234", "Railee Darrel", 10000, 3333, "Active"));
        accounts.add(new Account("4567-8901-2345", "Railynne Dessirei", 2500, 4444, "Active"));
        accounts.add(new Account("5678-9012-3456", "Raine Dessirei", 10000, 5555, "Active"));
    }

    static void mainMenu() {
        while (true) {
            System.out.println("\nRGBC");
            System.out.println("Richard Gwapo Banking Corporation\n");
            System.out.println("S -> Start Transaction");
            System.out.println("Q -> Quit");
            System.out.print("\nEnter your choice: ");
            String choice = sc.nextLine().toUpperCase();

            switch (choice) {
                case "S":
                    login();
                    break;
                case "Q":
                    System.out.println("System closed. Goodbye.");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    static void login() {
        System.out.println("\nLOGIN");
        System.out.print("Enter your account number: ");
        String accNo = sc.nextLine();
        System.out.print("Enter your pin number: ");
        int pin = sc.nextInt();
        sc.nextLine();

        if (accNo.equals("0000-000-0000") && pin == 0000) {
            adminMenu();
            return;
        }

        Account acc = findAccount(accNo);
        if (acc == null) {
            System.out.println("Account not found.");
            return;
        }

        if (acc.status.equalsIgnoreCase("Blocked")) {
            System.out.println("Account is blocked. Please contact the bank.");
            return;
        }

        int attempts = 1;
        while (acc.pin != pin) {
            if (attempts == 3) {
                System.out.println("CAPTURED CARD…. PLEASE CALL 143-44");
                acc.status = "Blocked";
                return;
            }
            System.out.print("Incorrect PIN. Try again: ");
            pin = sc.nextInt();
            sc.nextLine();
            attempts++;
        }

        transactionMenu(acc);
    }

    static Account findAccount(String accNo) {
        for (Account a : accounts) {
            if (a.accNo.equals(accNo)) return a;
        }
        return null;
    }

    static void transactionMenu(Account acc) {
        while (true) {
            System.out.println("\nRGBC");
            System.out.println("Richard Gwapo Banking Corporation\n");
            System.out.println("B -> Balance Inquiry");
            System.out.println("W -> Withdrawal");
            System.out.println("D -> Deposit");
            System.out.println("T -> Transfer Fund");
            System.out.println("C -> Cancel");
            System.out.print("\nEnter transaction type: ");
            String type = sc.nextLine().toUpperCase();

            switch (type) {
                case "B":
                    balanceInquiry(acc);
                    break;
                case "W":
                    withdrawal(acc);
                    break;
                case "D":
                    deposit(acc);
                    break;
                case "T":
                    transfer(acc);
                    break;
                case "C":
                    return;
                default:
                    System.out.println("Invalid transaction type.");
            }
        }
    }

    static void balanceInquiry(Account acc) {
        System.out.println("\nRGBC");
        System.out.println("Richard Gwapo Banking Corporation\n");
        System.out.println("BALANCE INQUIRY\n");
        System.out.println("Account #: " + acc.accNo);
        System.out.println("Account Name: " + acc.name);
        System.out.printf("Balance: %.2f%n", acc.balance);
        System.out.println("\nPress X to Exit");
        sc.nextLine();
    }

    static void withdrawal(Account acc) {
        System.out.println("\nWITHDRAWAL");
        System.out.print("Enter amount to be withdrawn: ");
        double amount = sc.nextDouble();
        sc.nextLine();

        if (amount < 100 || amount % 100 != 0) {
            System.out.println("Invalid amount. Must be 100 denomination or higher.");
            return;
        }
        if (amount > acc.balance) {
            System.out.println("Insufficient funds.");
            return;
        }
        acc.balance -= amount;
        System.out.println("Withdrawal successful.");
        System.out.printf("New balance: %.2f%n", acc.balance);
        System.out.println("\nPress X to Exit");
        sc.nextLine();
    }

    static void deposit(Account acc) {
        System.out.println("\nDEPOSIT");
        System.out.print("Enter amount to be deposited: ");
        double amount = sc.nextDouble();
        sc.nextLine();

        if (amount < 100) {
            System.out.println("Invalid amount. Deposit must be at least 100.");
            return;
        }
        acc.balance += amount;
        System.out.println("Deposit successful.");
        System.out.printf("New balance: %.2f%n", acc.balance);
        System.out.println("\nPress X to Exit");
        sc.nextLine();
    }

    static void transfer(Account acc) {
        System.out.println("\nTRANSFER FUND");
        System.out.print("Transfer to (account #): ");
        String targetAccNo = sc.nextLine();
        Account target = findAccount(targetAccNo);

        if (target == null) {
            System.out.println("Target account not found.");
            return;
        }
        System.out.print("Enter amount to transfer: ");
        double amount = sc.nextDouble();
        sc.nextLine();

        if (amount < 1000) {
            System.out.println("Minimum transfer is 1000.");
            return;
        }

        double fee = 25 * (amount / 1000);
        double total = amount + fee;

        if (acc.balance < total) {
            System.out.println("Insufficient balance for transfer + fee.");
            return;
        }

        acc.balance -= total;
        target.balance += amount;
        System.out.println("Transfer successful.");
        System.out.printf("Fee deducted: %.2f%n", fee);
        System.out.printf("Your new balance: %.2f%n", acc.balance);
        System.out.println("\nPress X to Exit");
        sc.nextLine();
    }

    // ================= ADMIN MENU ================= //

    static void adminMenu() {
        while (true) {
            System.out.println("\nRGBC ADMIN PAGE");
            System.out.println("(1) View Customers");
            System.out.println("(2) Search Customer");
            System.out.println("(3) Add New Customer");
            System.out.println("(4) Edit Customer Name");
            System.out.println("(5) Change Customer PIN");
            System.out.println("(6) Transfer Fund");
            System.out.println("(7) Activate/Block Account");
            System.out.println("(X) Exit");
            System.out.print("Enter your choice: ");
            String choice = sc.nextLine().toUpperCase();

            switch (choice) {
                case "1": viewCustomers(); break;
                case "2": searchCustomer(); break;
                case "3": addCustomer(); break;
                case "4": editCustomer(); break;
                case "5": changePin(); break;
                case "6": adminTransfer(); break;
                case "7": toggleStatus(); break;
                case "X": return;
                default: System.out.println("Invalid choice.");
            }
        }
    }

    static void viewCustomers() {
        System.out.println("\nCUSTOMER LIST:");
        for (Account a : accounts) {
            System.out.printf("%s | %s | %.2f | %d | %s%n", a.accNo, a.name, a.balance, a.pin, a.status);
        }
    }

    static void searchCustomer() {
        System.out.print("Enter account number: ");
        String accNo = sc.nextLine();
        Account a = findAccount(accNo);
        if (a == null) System.out.println("Account not found.");
        else System.out.printf("%s | %s | %.2f | %d | %s%n", a.accNo, a.name, a.balance, a.pin, a.status);
    }

    static void addCustomer() {
        System.out.print("Enter new account number: ");
        String accNo = sc.nextLine();
        System.out.print("Enter account name: ");
        String name = sc.nextLine();
        System.out.print("Enter starting balance: ");
        double balance = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter pin number: ");
        int pin = sc.nextInt();
        sc.nextLine();
        accounts.add(new Account(accNo, name, balance, pin, "Active"));
        System.out.println("Customer added successfully.");
    }

    static void editCustomer() {
        System.out.print("Enter account number: ");
        String accNo = sc.nextLine();
        Account a = findAccount(accNo);
        if (a == null) {
            System.out.println("Account not found.");
            return;
        }
        System.out.print("Enter new name: ");
        a.name = sc.nextLine();
        System.out.println("Name updated.");
    }

    static void changePin() {
        System.out.print("Enter account number: ");
        String accNo = sc.nextLine();
        Account a = findAccount(accNo);
        if (a == null) {
            System.out.println("Account not found.");
            return;
        }
        System.out.print("Enter new PIN: ");
        a.pin = sc.nextInt();
        sc.nextLine();
        System.out.println("PIN changed successfully.");
    }

    static void adminTransfer() {
        System.out.print("Enter sender account #: ");
        String fromAccNo = sc.nextLine();
        System.out.print("Enter receiver account #: ");
        String toAccNo = sc.nextLine();
        Account from = findAccount(fromAccNo);
        Account to = findAccount(toAccNo);
        if (from == null || to == null) {
            System.out.println("One or both accounts not found.");
            return;
        }
        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();

        if (amount < 1000) {
            System.out.println("Minimum transfer is 1000.");
            return;
        }

        double fee = 25 * (amount / 1000);
        double total = amount + fee;

        if (from.balance < total) {
            System.out.println("Insufficient balance.");
            return;
        }

        from.balance -= total;
        to.balance += amount;
        System.out.println("Transfer successful by admin.");
    }

    static void toggleStatus() {
        System.out.print("Enter account number: ");
        String accNo = sc.nextLine();
        Account a = findAccount(accNo);
        if (a == null) {
            System.out.println("Account not found.");
            return;
        }
        a.status = a.status.equalsIgnoreCase("Active") ? "Blocked" : "Active";
        System.out.println("Account status changed to " + a.status);
    }
}
