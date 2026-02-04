import javax.swing.JOptionPane;
import java.util.ArrayList;

public class CaseStudy {
    // Account class to store account information
    static class Account {
        String accountNumber;
        String accountName;
        double balance;
        String pinNumber;
        String status;
        int failedAttempts;

        public Account(String accNum, String accName, double bal, String pin, String stat) {
            this.accountNumber = accNum;
            this.accountName = accName;
            this.balance = bal;
            this.pinNumber = pin;
            this.status = stat;
            this.failedAttempts = 0;
        }
    }

    // ArrayList to store all accounts
    static ArrayList<Account> accounts = new ArrayList<>();
    static Account currentUser = null;
    static final String ADMIN_ACC = "0000-000-0000";
    static final String ADMIN_PIN = "0000";

    public static void main(String[] args) {
        initializeAccounts();
        showMainMenu();
    }

    // Initialize with sample accounts
    public static void initializeAccounts() {
        accounts.add(new Account("0123-4567-8901", "Roel Richard", 5000.00, "1111", "Active"));
        accounts.add(new Account("2345-6789-0123", "Dorie Marie", 0.00, "2222", "Blocked"));
        accounts.add(new Account("3456-7890-1234", "Railee Darrel", 10000, "3333", "Active"));
        accounts.add(new Account("4567-8901-2345", "Railynne Dessirei", 2500, "4444", "Active"));
        accounts.add(new Account("5678-9012-3456", "Raine Dessirei", 10000, "5555", "Active"));
    }

    // Main menu
    public static void showMainMenu() {
        while (true) {
            String menu = "Richard Gwapo Banking Corporation\n\n" +
                    "S -> Start Transaction\n" +
                    "Q -> Quit\n" +
                    "A -> Admin Login\n\n" +
                    "Enter your choice:";

            String choice = JOptionPane.showInputDialog(null, menu, "RGBC", JOptionPane.QUESTION_MESSAGE);

            if (choice == null || choice.equalsIgnoreCase("Q")) {
                JOptionPane.showMessageDialog(null, "Thank you for using RGBC!");
                System.exit(0);
            } else if (choice.equalsIgnoreCase("S")) {
                userLogin();
            } else if (choice.equalsIgnoreCase("A")) {
                adminLogin();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid choice! Please try again.");
            }
        }
    }

    // User login
    public static void userLogin() {
        String accNumber = JOptionPane.showInputDialog("Enter your account number:");

        // Find account
        Account account = findAccount(accNumber);

        if (account == null) {
            JOptionPane.showMessageDialog(null, "Account not found!");
            return;
        }

        if (account.status.equals("Blocked")) {
            JOptionPane.showMessageDialog(null, "Account is blocked! Please contact administrator.");
            return;
        }

        // Check PIN
        for (int attempts = 0; attempts < 3; attempts++) {
            String pin = JOptionPane.showInputDialog("Enter your PIN number:");

            if (pin.equals(account.pinNumber)) {
                currentUser = account;
                account.failedAttempts = 0; // Reset failed attempts
                showUserMenu();
                return;
            } else {
                account.failedAttempts++;
                JOptionPane.showMessageDialog(null,
                        "Invalid PIN! Attempts left: " + (2 - attempts));
            }
        }

        // Block account after 3 failed attempts
        account.status = "Blocked";
        JOptionPane.showMessageDialog(null,
                "CAPTURED CARD.... PLEASE CALL 143-44\nAccount has been blocked!");
    }

    // User transaction menu
    public static void showUserMenu() {
        while (currentUser != null) {
            String menu = "Richard Gwapo Banking Corporation\n\n" +
                    "SELECT TYPE OF TRANSACTION\n\n" +
                    "B -> Balance Inquiry\n" +
                    "W -> Withdrawal\n" +
                    "D -> Deposit\n" +
                    "T -> Transfer Fund\n" +
                    "C -> Cancel\n\n" +
                    "Enter transaction type:";

            String choice = JOptionPane.showInputDialog(null, menu, "RGBC", JOptionPane.QUESTION_MESSAGE);

            if (choice == null || choice.equalsIgnoreCase("C")) {
                currentUser = null;
                return;
            }

            switch (choice.toUpperCase()) {
                case "B":
                    balanceInquiry();
                    break;
                case "W":
                    withdrawal();
                    break;
                case "D":
                    deposit();
                    break;
                case "T":
                    transferFund();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice!");
            }
        }
    }

    // Balance inquiry
    public static void balanceInquiry() {
        String message = "BALANCE INQUIRY\n\n" +
                "Account #: " + currentUser.accountNumber + "\n" +
                "Account Name: " + currentUser.accountName + "\n" +
                "Balance: " + String.format("%.2f", currentUser.balance) + "\n\n" +
                "Press OK to continue";
        JOptionPane.showMessageDialog(null, message);
    }

    // Withdrawal
    public static void withdrawal() {
        String amountStr = JOptionPane.showInputDialog("Enter amount to be withdrawn:");

        try {
            double amount = Double.parseDouble(amountStr);

            // Validation
            if (amount < 100) {
                JOptionPane.showMessageDialog(null, "Minimum withdrawal is 100 pesos!");
                return;
            }

            if (amount % 100 != 0) {
                JOptionPane.showMessageDialog(null, "Amount must be in 100 denomination!");
                return;
            }

            if (amount > currentUser.balance) {
                JOptionPane.showMessageDialog(null, "Insufficient funds!");
                return;
            }

            // Process withdrawal
            currentUser.balance -= amount;
            JOptionPane.showMessageDialog(null,
                    "Successfully withdrawn: " + String.format("%.2f", amount) +
                            "\nNew balance: " + String.format("%.2f", currentUser.balance));

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid amount format!");
        }
    }

    // Deposit
    public static void deposit() {
        String amountStr = JOptionPane.showInputDialog("Enter amount to be deposited:");

        try {
            double amount = Double.parseDouble(amountStr);

            if (amount < 100) {
                JOptionPane.showMessageDialog(null, "Minimum deposit is 100 pesos!");
                return;
            }

            // Process deposit
            currentUser.balance += amount;
            JOptionPane.showMessageDialog(null,
                    "Successfully deposited: " + String.format("%.2f", amount) +
                            "\nNew balance: " + String.format("%.2f", currentUser.balance));

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid amount format!");
        }
    }

    // Transfer fund
    public static void transferFund() {
        String targetAcc = JOptionPane.showInputDialog("Transfer to (enter account #):");
        Account targetAccount = findAccount(targetAcc);

        if (targetAccount == null) {
            JOptionPane.showMessageDialog(null, "Target account not found!");
            return;
        }

        if (targetAccount.status.equals("Blocked")) {
            JOptionPane.showMessageDialog(null, "Target account is blocked!");
            return;
        }

        String amountStr = JOptionPane.showInputDialog("Enter amount to transfer:");

        try {
            double amount = Double.parseDouble(amountStr);

            if (amount < 1000) {
                JOptionPane.showMessageDialog(null, "Minimum transfer amount is 1000 pesos!");
                return;
            }

            // Calculate charge (25 pesos for every 1000)
            double charge = (int)(amount / 1000) * 25;
            double totalDeduction = amount + charge;

            if (totalDeduction > currentUser.balance) {
                JOptionPane.showMessageDialog(null, "Insufficient funds! Including transfer charge.");
                return;
            }

            // Process transfer
            currentUser.balance -= totalDeduction;
            targetAccount.balance += amount;

            JOptionPane.showMessageDialog(null,
                    "Transfer successful!\n" +
                            "Amount transferred: " + String.format("%.2f", amount) + "\n" +
                            "Transfer charge: " + String.format("%.2f", charge) + "\n" +
                            "New balance: " + String.format("%.2f", currentUser.balance));

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid amount format!");
        }
    }

    // Admin login
    public static void adminLogin() {
        String accNumber = JOptionPane.showInputDialog("Enter admin account number:");
        String pin = JOptionPane.showInputDialog("Enter admin PIN:");

        if (ADMIN_ACC.equals(accNumber) && ADMIN_PIN.equals(pin)) {
            showAdminMenu();
        } else {
            JOptionPane.showMessageDialog(null, "Invalid admin credentials!");
        }
    }

    // Admin menu
    public static void showAdminMenu() {
        while (true) {
            String menu = "Richard Gwapo Banking Corporation\n\n" +
                    "ADMIN MENU\n\n" +
                    "1 - View Customer Information\n" +
                    "2 - Search Customer\n" +
                    "3 - Add New Customer\n" +
                    "4 - Edit Customer Information\n" +
                    "5 - Change Customer Pin Number\n" +
                    "6 - Transfer Fund\n" +
                    "7 - Activate/Block Account\n" +
                    "X - Exit\n\n" +
                    "Enter your choice:";

            String choice = JOptionPane.showInputDialog(null, menu, "Admin Panel", JOptionPane.QUESTION_MESSAGE);

            if (choice == null || choice.equalsIgnoreCase("X")) {
                return;
            }

            switch (choice) {
                case "1":
                    viewAllCustomers();
                    break;
                case "2":
                    searchCustomer();
                    break;
                case "3":
                    addNewCustomer();
                    break;
                case "4":
                    editCustomer();
                    break;
                case "5":
                    changeCustomerPin();
                    break;
                case "6":
                    adminTransferFund();
                    break;
                case "7":
                    toggleAccountStatus();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice!");
            }
        }
    }

    // Admin function: View all customers
    public static void viewAllCustomers() {
        StringBuilder sb = new StringBuilder("ALL CUSTOMER INFORMATION\n\n");

        for (Account acc : accounts) {
            sb.append("Account #: ").append(acc.accountNumber).append("\n")
                    .append("Name: ").append(acc.accountName).append("\n")
                    .append("Balance: ").append(String.format("%.2f", acc.balance)).append("\n")
                    .append("Status: ").append(acc.status).append("\n")
                    .append("----------------------------\n");
        }

        JOptionPane.showMessageDialog(null, sb.toString());
    }

    // Admin function: Search customer
    public static void searchCustomer() {
        String accNumber = JOptionPane.showInputDialog("Enter account number to search:");
        Account account = findAccount(accNumber);

        if (account != null) {
            String info = "CUSTOMER FOUND\n\n" +
                    "Account #: " + account.accountNumber + "\n" +
                    "Name: " + account.accountName + "\n" +
                    "Balance: " + String.format("%.2f", account.balance) + "\n" +
                    "Status: " + account.status;
            JOptionPane.showMessageDialog(null, info);
        } else {
            JOptionPane.showMessageDialog(null, "Customer not found!");
        }
    }

    // Admin function: Add new customer
    public static void addNewCustomer() {
        String accNumber = JOptionPane.showInputDialog("Enter new account number:");

        // Check if account already exists
        if (findAccount(accNumber) != null) {
            JOptionPane.showMessageDialog(null, "Account number already exists!");
            return;
        }

        String name = JOptionPane.showInputDialog("Enter account name:");
        String pin = JOptionPane.showInputDialog("Enter PIN number:");
        String balanceStr = JOptionPane.showInputDialog("Enter initial balance:");

        try {
            double balance = Double.parseDouble(balanceStr);
            accounts.add(new Account(accNumber, name, balance, pin, "Active"));
            JOptionPane.showMessageDialog(null, "Customer added successfully!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid balance amount!");
        }
    }

    // Admin function: Edit customer
    public static void editCustomer() {
        String accNumber = JOptionPane.showInputDialog("Enter account number to edit:");
        Account account = findAccount(accNumber);

        if (account != null) {
            String newName = JOptionPane.showInputDialog("Enter new name:", account.accountName);
            if (newName != null && !newName.trim().isEmpty()) {
                account.accountName = newName;
                JOptionPane.showMessageDialog(null, "Customer information updated!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Customer not found!");
        }
    }

    // Admin function: Change customer PIN
    public static void changeCustomerPin() {
        String accNumber = JOptionPane.showInputDialog("Enter account number:");
        Account account = findAccount(accNumber);

        if (account != null) {
            String newPin = JOptionPane.showInputDialog("Enter new PIN:");
            if (newPin != null && !newPin.trim().isEmpty()) {
                account.pinNumber = newPin;
                JOptionPane.showMessageDialog(null, "PIN changed successfully!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Customer not found!");
        }
    }

    // Admin function: Transfer fund
    public static void adminTransferFund() {
        // Similar to user transfer but without charges for admin
        String sourceAcc = JOptionPane.showInputDialog("Enter source account number:");
        Account sourceAccount = findAccount(sourceAcc);

        if (sourceAccount == null) {
            JOptionPane.showMessageDialog(null, "Source account not found!");
            return;
        }

        String targetAcc = JOptionPane.showInputDialog("Enter target account number:");
        Account targetAccount = findAccount(targetAcc);

        if (targetAccount == null) {
            JOptionPane.showMessageDialog(null, "Target account not found!");
            return;
        }

        String amountStr = JOptionPane.showInputDialog("Enter amount to transfer:");

        try {
            double amount = Double.parseDouble(amountStr);

            if (amount <= 0) {
                JOptionPane.showMessageDialog(null, "Amount must be positive!");
                return;
            }

            if (amount > sourceAccount.balance) {
                JOptionPane.showMessageDialog(null, "Insufficient funds!");
                return;
            }

            // Process transfer (no charge for admin)
            sourceAccount.balance -= amount;
            targetAccount.balance += amount;

            JOptionPane.showMessageDialog(null, "Transfer successful!");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid amount format!");
        }
    }

    // Admin function: Toggle account status
    public static void toggleAccountStatus() {
        String accNumber = JOptionPane.showInputDialog("Enter account number:");
        Account account = findAccount(accNumber);

        if (account != null) {
            String newStatus = account.status.equals("Active") ? "Blocked" : "Active";
            account.status = newStatus;
            JOptionPane.showMessageDialog(null, "Account status changed to: " + newStatus);
        } else {
            JOptionPane.showMessageDialog(null, "Customer not found!");
        }
    }

    // Helper method to find account by number
    public static Account findAccount(String accountNumber) {
        for (Account acc : accounts) {
            if (acc.accountNumber.equals(accountNumber)) {
                return acc;
            }
        }
        return null;
    }
}