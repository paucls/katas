package com.codurance.training.tasks;

import org.junit.Test;

import java.io.PrintWriter;

import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import static org.mockito.Mockito.*;

public class CommandTest {
    @Test
    public void a_command_must_be_constructed_with_a_command_line() {
        Command command = new Command("help");

        assertThat(command.getName(), is("help"));
    }

    @Test
    public void a_command_can_have_arguments() {
        Command command = new Command("add project secrets");

        assertThat(command.getName(), is("add"));
    }

    @Test
    public void a_command_arguments_can_be_accessed() {
        Command command = new Command("add project secrets");

        assertThat(command.getArguments(), is("project secrets"));
    }

    @Test
    public void a_command_can_be_created() {
        PrintWriter mockPrintWriter = mock(PrintWriter.class);
        Command helpCommand = Command.create("help", mockPrintWriter);

        assertThat(helpCommand, instanceOf(Command.class));
        assertThat(helpCommand, instanceOf(HelpCommand.class));
    }

    @Test
    public void a_command_can_be_executed() {
        PrintWriter mockPrintWriter = mock(PrintWriter.class);

        Command helpCommand = Command.create("help", mockPrintWriter);

        helpCommand.execute();
        verify(mockPrintWriter, times(6)).println(anyString());
        verify(mockPrintWriter, times(1)).println();
    }

    @Test
    public void a_command_deadline_can_be_executed() {
        PrintWriter mockPrintWriter = mock(PrintWriter.class);

        Command command = new Command("deadline", mockPrintWriter);

        command.execute();
        verify(mockPrintWriter, times(0)).println();
    }

    @Test
    public void a_command_today_can_be_executed() {
        PrintWriter mockPrintWriter = mock(PrintWriter.class);

        Command command = new Command("today", mockPrintWriter);

        command.execute();
        verify(mockPrintWriter, times(2)).println(anyString());
        verify(mockPrintWriter, times(1)).println();
    }

}
