public class SavingAccount extends Account {

    private double interestRate;
    private static final double MINIMUM_BALANCE = 100.00;

    public SavingAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        double balance = getBalance();
        if (balance - amount < MINIMUM_BALANCE) {
            throw new InsufficientFundsException("Minimum balance must be maintained: $" + MINIMUM_BALANCE);
        }
        setBalance(balance - amount);
        addTransaction(new Transaction("Withdrawal", TransactionType.DEBIT, amount));
    }

    @Override
    public void deposit(double amount) {
        double balance = getBalance();
        setBalance(balance + amount);
        addTransaction(new Transaction("Deposit", TransactionType.CREDIT, amount));
    }

    public void applyInterest() {
        double interest = getBalance() * interestRate / 100;
        deposit(interest);
    }
    
}
