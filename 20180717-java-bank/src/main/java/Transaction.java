import java.util.Date;

class Transaction {
    private final Date date;
    private final int amount;

    Transaction(Date date, int amount) {
        this.date = date;
        this.amount = amount;
    }

    Date getDate() {
        return date;
    }

    int getAmount() {
        return amount;
    }
}
