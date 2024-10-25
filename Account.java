// 1. Base Account Class
public abstract class Account {

    // Common Properties
    private String accountNumber;
    private String accountHolder;
    private double balance;

    public Account(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Common Methods
    public double getBalance() {
        return balance;
    }

    public String getAccountSummary() {
        return "Account Number: " + accountNumber + "\nAccount Holder: " + accountHolder + "\nBalance: " + balance;
    }


    // Abstract Methods to be implemented by child classes (specific account types)
    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);
} 