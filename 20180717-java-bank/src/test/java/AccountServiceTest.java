import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AccountServiceTest {

    @Test
    public void printStatement_should_print_column_names() {
        Console consoleMock = mock(Console.class);
        Calendar calendarMock = mock(Calendar.class);
        AccountService accountService = new AccountService(consoleMock, calendarMock);

        accountService.printStatement();

        verify(consoleMock).printLine("DATE | AMOUNT | BALANCE");
    }

    @Test
    public void deposit_should_record_transaction() {
        Console consoleMock = mock(Console.class);
        Calendar calendarMock = mock(Calendar.class);
        AccountService accountService = new AccountService(consoleMock, calendarMock);

        accountService.deposit(1000);
        accountService.printStatement();

        verify(consoleMock).printLine("DATE | AMOUNT | BALANCE");
        verify(consoleMock).printLine("20/10/2017 | 1000 | 1000");
    }
}