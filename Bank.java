import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Bank {
    
    private Map<String, Account> accounts;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Bank() {
        this.accounts = new HashMap<>();;
    }

    public void addAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public void transfer(String fromAccountNumber, String toAccountNumber, double amount) throws InsufficientFundsException {
        Account fromAccount = accounts.get(fromAccountNumber);
        Account toAccount = accounts.get(toAccountNumber);

        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
    }


    public void printAccountStatement(String accountNumber) {
        Account account = accounts.get(accountNumber);
        if (account == null) {
            System.out.println("Account not found");
            return;
        }

        System.out.println("\n=== Account Statement ===");
        System.out.println(account.getAccountSummary());
        System.out.println("\nTransaction History:");
        for (Transaction transaction : account.getTransactionHistory()) {
            System.out.println(transaction);
        }
        System.out.println("=====================");
    }

}
