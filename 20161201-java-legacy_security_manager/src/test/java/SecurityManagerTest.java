import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class SecurityManagerTest {

    private BufferedReader bufferedReaderMock;
    private PrintStream outputMock;
    private SecurityManager securityManager;

    @Before
    public void setup() {
        bufferedReaderMock = mock(BufferedReader.class);
        outputMock = mock(PrintStream.class);
        securityManager = new SecurityManager(bufferedReaderMock, outputMock);
    }


    @Test
    public void createUser_should_ask_for_username() throws IOException {
        when(bufferedReaderMock.readLine()).thenReturn("");

        securityManager.createUser();

        verify(outputMock).println("Enter a username");
    }

    @Test
    public void createUser_should_ask_for_full_name() throws IOException {
        when(bufferedReaderMock.readLine()).thenReturn("John");

        securityManager.createUser();

        verify(outputMock).println("Enter your full name");
    }

    @Test
    public void createUser_should_ask_for_password() throws IOException {
        when(bufferedReaderMock.readLine()).thenReturn("John");

        securityManager.createUser();

        verify(outputMock).println("Enter your password");
    }

    @Test
    public void createUser_should_ask_for_re_enter_password() throws IOException {
        when(bufferedReaderMock.readLine()).thenReturn("John");

        securityManager.createUser();

        verify(outputMock).println("Re-enter your password");
    }
}
