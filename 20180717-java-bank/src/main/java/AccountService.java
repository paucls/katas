public class AccountService {
    private final Console console;
    private final Calendar calendar;

    public AccountService(Console console, Calendar calendar) {
        this.console = console;
        this.calendar = calendar;
    }

    public void deposit(int amount) {
    }

    public void withdraw(int amount) {
    }

    public void printStatement() {
        console.printLine("DATE | AMOUNT | BALANCE");
    }
}