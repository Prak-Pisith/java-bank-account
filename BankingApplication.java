public class BankingApplication {
    public static void main(String[] args) throws InsufficientFundsException {
        System.out.println("Welcome to the Banking Application");

        // // Create a Saving Account
        // SavingAccount savingAccount = new SavingAccount("SA-001", "Alice", 5000.00, 4.5);
        // System.out.println(savingAccount.getAccountSummary());

        // savingAccount.deposit(1000.00);
        // System.out.println(savingAccount.getAccountSummary());

        try {
            
            Bank bank = new Bank();

            SavingAccount savingAccount = new SavingAccount("SA-001", "Alice", 5000.00, 4.5);
            SavingAccount savingAccount2 = new SavingAccount("SA-002", "Bob", 3000.00, 4.5);

            bank.addAccount(savingAccount);

            savingAccount.deposit(1000.00);
            savingAccount.withdraw(500.00);
            savingAccount.applyInterest();

            bank.addAccount(savingAccount2);

            bank.transfer("SA-001", "SA-002", 350);

            bank.printAccountStatement("SA-001");
            bank.printAccountStatement("SA-002");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }


    }
}
