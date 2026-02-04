class Account{
    private String accountNumber;
    private double balance;

    //public getter for accountNumber
    public String getAccountNumber() {
        return accountNumber;
    }

    //public setter for accountNumber
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    //public getter for balance
    public double getBalance() {
        return balance;
    }

    //public setter for balance
    public void setBalance(double balance) {
        this.balance = balance;
    }

    //Default method to display account details
    void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: Php" + balance);

    }
}

public class Accn {
    public static void main(String[] args) {
        Account acc = new Account();
        acc.setAccountNumber("12345");
        acc.setBalance(5000.00);
        
        //Acess using public methods
        System.out.println("Account Number(via getter): " + acc.getAccountNumber());
        System.out.println("Balance(via getter): Php" + acc.getBalance());

       //Access using default method
        acc.displayAccountDetails();


    }
}
        