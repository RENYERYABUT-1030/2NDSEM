class AccountDeposit {
    private double balance;

    //Public method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: Php" + amount);
        } else {
            System.out.println("Deposit amount Must be positive.");
        }
    }

    //Default method to display balance
    void displayBalance() {
        System.out.println("Current Balance: Php" + balance);
    }
}

public class balndeposit {
    public static void main(String[] args) {
        AccountDeposit acc = new AccountDeposit();
        
        //Deposit Valid Amount
        acc.deposit(1000.00);

        //Deposit invalid Amount
        acc.deposit(-500.00);

        //Display balance 
        acc.displayBalance();
    }
}