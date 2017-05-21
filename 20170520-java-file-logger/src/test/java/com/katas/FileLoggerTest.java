package com.katas;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.time.LocalDateTime;

import static org.mockito.Mockito.*;

public class FileLoggerTest {

    private static final String A_MESSAGE = "A message";

    FileSystemAdapter fileSystemAdapterMock;
    DateProvider dateProviderStub;

    @Before
    public void setup() {
        fileSystemAdapterMock = mock(FileSystemAdapter.class);
        dateProviderStub = mock(DateProvider.class);
    }

    @Test
    public void log_should_write_message_on_new_file_each_day() throws IOException {
        FileLogger fileLogger = new FileLogger(fileSystemAdapterMock, dateProviderStub);
        when(dateProviderStub.now()).thenReturn(LocalDateTime.of(2017, 05, 21, 0, 0));

        fileLogger.log(A_MESSAGE);
        verify(fileSystemAdapterMock).write("log20170521.txt", A_MESSAGE);

        when(dateProviderStub.now()).thenReturn(LocalDateTime.of(2017, 05, 22, 0, 0));

        fileLogger.log(A_MESSAGE);
        verify(fileSystemAdapterMock).write("log20170522.txt", A_MESSAGE);
    }

    @Test
    public void log_should_append_message_when_file_already_exists_for_the_day() throws IOException {
        String logFilePath = "log20170521.txt";
        FileLogger fileLogger = new FileLogger(fileSystemAdapterMock, dateProviderStub);
        when(fileSystemAdapterMock.exists(logFilePath)).thenReturn(true);
        when(dateProviderStub.now()).thenReturn(LocalDateTime.of(2017, 05, 21, 0, 0));

        fileLogger.log(A_MESSAGE);

        verify(fileSystemAdapterMock).append(logFilePath, A_MESSAGE);
    }

}
