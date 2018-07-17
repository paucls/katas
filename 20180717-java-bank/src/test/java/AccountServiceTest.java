import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AccountServiceTest {

    private Console consoleMock = mock(Console.class);
    private Calendar calendarMock = mock(Calendar.class);

    @Test
    public void printStatement_should_print_column_names() {
        AccountService accountService = new AccountService(consoleMock, calendarMock);

        accountService.printStatement();

        verify(consoleMock).printLine("DATE | AMOUNT | BALANCE");
    }

    @Test
    public void printStatement_should_print_a_deposit() throws ParseException {
        AccountService accountService = new AccountService(consoleMock, calendarMock);
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        when(calendarMock.currentDate()).thenReturn(format.parse("22/10/2017"));

        accountService.deposit(1000);
        accountService.printStatement();

        verify(consoleMock).printLine("22/10/2017 | 1000 | 1000");
    }

    @Test
    public void printStatement_should_print_a_withdrawal() throws ParseException {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Transaction withdrawal = new Transaction(format.parse("22/10/2017"), -500);
        List<Transaction> transactions = Collections.singletonList(withdrawal);
        AccountService accountService = new AccountService(consoleMock, calendarMock, transactions);

        accountService.printStatement();

        verify(consoleMock).printLine("22/10/2017 | -500 | -500");
    }
}