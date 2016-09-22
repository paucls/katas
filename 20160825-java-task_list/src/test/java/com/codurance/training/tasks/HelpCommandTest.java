package com.codurance.training.tasks;

import org.junit.Test;

import java.io.PrintWriter;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class HelpCommandTest {

    @Test
    public void command_help_can_be_executed() {
        PrintWriter mockPrintWriter = mock(PrintWriter.class);

        HelpCommand helpCommand = new HelpCommand("help", mockPrintWriter);

        helpCommand.execute();
        verify(mockPrintWriter, times(6)).println(anyString());
        verify(mockPrintWriter, times(1)).println();
    }

}
