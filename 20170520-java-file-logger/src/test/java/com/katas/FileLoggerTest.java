package com.katas;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class FileLoggerTest {

    FileSystemAdapter fileSystemAdapterMock;

    @Before
    public void setup() {
        fileSystemAdapterMock = mock(FileSystemAdapter.class);
    }

    @Test
    public void log_should_write_message_on_new_file() throws IOException {
        // Arrange
        String message = "A message";
        FileLogger fileLogger = new FileLogger(fileSystemAdapterMock);

        // Act
        fileLogger.log(message);

        // Assert
        verify(fileSystemAdapterMock).write("log20170521.txt", message);
    }

    @Test
    public void log_should_append_message_when_file_already_exists() throws IOException {
        // Arrange
        String message = "A message";
        String logFilePath = "log20170521.txt";
        FileLogger fileLogger = new FileLogger(fileSystemAdapterMock);
        when(fileSystemAdapterMock.exists(logFilePath)).thenReturn(true);

        // Act
        fileLogger.log(message);

        // Assert
        verify(fileSystemAdapterMock).append(logFilePath, message);
    }

}
