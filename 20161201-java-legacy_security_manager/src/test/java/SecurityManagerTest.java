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

    @Test
    public void createUser_should_verify_password_matches() throws IOException {
        when(bufferedReaderMock.readLine())
                .thenReturn("John")
                .thenReturn("John Doe")
                .thenReturn("password1")
                .thenReturn("password1");

        securityManager.createUser();

        verify(outputMock, never()).println("The passwords don't match");
    }

    @Test
    public void createUser_should_warn_user_when_password_dont_match() throws IOException {
        when(bufferedReaderMock.readLine())
                .thenReturn("John")
                .thenReturn("John Doe")
                .thenReturn("password1")
                .thenReturn("password2");

        securityManager.createUser();

        verify(outputMock).println("The passwords don't match");
    }

    @Test
    public void createUser_should_verify_password_length() throws IOException {
        when(bufferedReaderMock.readLine())
                .thenReturn("John")
                .thenReturn("John Doe")
                .thenReturn("password1")
                .thenReturn("password1");

        securityManager.createUser();

        verify(outputMock, never()).println("Password must be at least 8 characters in length");
    }

    @Test
    public void createUser_should_warn_user_when_password_length_less_than_eight() throws IOException {
        when(bufferedReaderMock.readLine())
                .thenReturn("John")
                .thenReturn("John Doe")
                .thenReturn("pass")
                .thenReturn("pass");

        securityManager.createUser();

        verify(outputMock).println("Password must be at least 8 characters in length");
    }


    @Test
    public void createUser_should_show_result_when_success() throws IOException {
        when(bufferedReaderMock.readLine())
                .thenReturn("John")
                .thenReturn("John Doe")
                .thenReturn("password1")
                .thenReturn("password1");

        securityManager.createUser();

        verify(outputMock).println("Saving Details for User (John, John Doe, 1drowssap)\n");
    }

}
