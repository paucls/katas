import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AccountService {
    private final Console console;
    private final Calendar calendar;
    private List<Transaction> transactions;

    public AccountService(Console console, Calendar calendar) {
        this(console, calendar, new ArrayList<>());
    }

    public AccountService(Console console, Calendar calendar, List<Transaction> transactions) {
        this.console = console;
        this.calendar = calendar;
        this.transactions = transactions;
    }

    public void deposit(int amount) {
        transactions.add(new Transaction(calendar.currentDate(), amount));
    }

    public void withdraw(int amount) {
        transactions.add(new Transaction(calendar.currentDate(), -amount));
    }

    public void printStatement() {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

        console.printLine("DATE | AMOUNT | BALANCE");

        for (Transaction t : transactions) {
            console.printLine(format.format(t.getDate()) + " | " + t.getAmount() + " | " + t.getAmount());
        }
    }
}