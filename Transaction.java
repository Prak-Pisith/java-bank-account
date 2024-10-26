import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private String description;
    private TransactionType type;
    private double amount;
    private LocalDateTime timestamp;

    public Transaction(String description, TransactionType type, double amount) {
        this.description = description;
        this.type = type;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("[%s] %s: $%.2f (%s)", 
                timestamp.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                description, amount, type);
    }

}
