import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SecurityManagerTest {

    @Test
    public void createUser_should_ask_for_username() throws IOException {

        BufferedReader bufferedReaderMock = mock(BufferedReader.class);
        when(bufferedReaderMock.readLine()).thenReturn("Johnatan");

        SecurityManager securityManager = new SecurityManager(bufferedReaderMock);

        securityManager.createUser();
    }

}
