import java.util.ArrayList;
import java.util.List;

public class AccountService {
    private final Console console;
    private final Calendar calendar;

    private List<String> transactions = new ArrayList<>();

    public AccountService(Console console, Calendar calendar) {
        this.console = console;
        this.calendar = calendar;
    }

    public void deposit(int amount) {
        this.transactions.add("20/10/2017 | " + amount + " | " + amount);
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