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
        String message = "A message";
        FileSystemAdapter fileSystemAdapterMock = mock(FileSystemAdapter.class);
        FileLogger fileLogger = new FileLogger(fileSystemAdapterMock);

        // Act
        fileLogger.log(message);

        // Assert
        verify(fileSystemAdapterMock).write("log.txt", message);
    }

    @Test
    public void log_should_append_message_when_file_already_exists() throws IOException {
        // Arrange
        String message = "A message";
        String logFilePath = "log.txt";
        FileSystemAdapter fileSystemAdapterMock = mock(FileSystemAdapter.class);
        FileLogger fileLogger = new FileLogger(fileSystemAdapterMock);
        when(fileSystemAdapterMock.exists(logFilePath)).thenReturn(true);

        // Act
        fileLogger.log(message);

        // Assert
        verify(fileSystemAdapterMock).append(logFilePath, message);
    }

}
