// 1. Base Account Class

import java.util.ArrayList;
import java.util.List;

public abstract class Account {

    // Common Properties
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private List<Transaction> transactions;

    public Account(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    // Common Methods
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountSummary() {
        return "Account Number: " + accountNumber + "\nAccount Holder: " + accountHolder + "\nBalance: " + balance;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public void printTransactions() {
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

    public List<Transaction> getTransactionHistory() {
        return new ArrayList<>(transactions);
    } 

    // Abstract Methods to be implemented by child classes (specific account types)
    public abstract void deposit(double amount);
    public abstract void withdraw(double amount) throws InsufficientFundsException;
} 