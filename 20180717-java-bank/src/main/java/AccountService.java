import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AccountService {
    private final Console console;
    private final Calendar calendar;

    private List<String> transactions = new ArrayList<>();

    public AccountService(Console console, Calendar calendar) {
        this.console = console;
        this.calendar = calendar;
    }

    public void deposit(int amount) {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        this.transactions.add(format.format(calendar.currentDate()) + " | " + amount + " | " + amount);
    }

    public void withdraw(int amount) {
    }

    public void printStatement() {
        console.printLine("DATE | AMOUNT | BALANCE");
        for (String transaction : transactions) {
            console.printLine(transaction);
        }
    }
}