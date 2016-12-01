import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class SecurityManagerTest {

    @Test
    public void createUser_should_ask_for_username() throws IOException {
        BufferedReader bufferedReaderMock = mock(BufferedReader.class);
        PrintStream outputMock = mock(PrintStream.class);
        when(bufferedReaderMock.readLine()).thenReturn("John");
        SecurityManager securityManager = new SecurityManager(bufferedReaderMock, outputMock);

        securityManager.createUser();

        verify(outputMock).println("Enter a username");
    }

}
