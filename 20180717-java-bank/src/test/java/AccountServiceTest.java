import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AccountServiceTest {

    private Console consoleMock = mock(Console.class);
    private Calendar calendarMock = mock(Calendar.class);
    private AccountService accountService = new AccountService(consoleMock, calendarMock);

    @Test
    public void printStatement_should_print_column_names() {
        accountService.printStatement();

        verify(consoleMock).printLine("DATE | AMOUNT | BALANCE");
    }

    @Test
    public void printStatement_should_print_a_deposit() throws ParseException {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        when(calendarMock.currentDate()).thenReturn(format.parse("22/10/2017"));

        accountService.deposit(1000);
        accountService.printStatement();

        verify(consoleMock).printLine("22/10/2017 | 1000 | 1000");
    }
}