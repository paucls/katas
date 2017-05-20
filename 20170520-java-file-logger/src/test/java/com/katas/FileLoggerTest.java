package com.katas;

import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class FileLoggerTest {

    @Test
    public void log_should_write_message_on_new_file() throws IOException {
        // Arrange
        FileSystemAdapter fileSystemAdapterMock = mock(FileSystemAdapter.class);
        FileLogger fileLogger = new FileLogger(fileSystemAdapterMock);

        // Act
        fileLogger.log("A message");

        // Assert
        verify(fileSystemAdapterMock).write("log.txt", "A message");
    }

}
