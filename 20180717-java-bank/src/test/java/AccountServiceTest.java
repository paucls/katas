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

}