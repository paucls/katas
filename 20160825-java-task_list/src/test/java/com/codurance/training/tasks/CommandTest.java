package com.codurance.training.tasks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CommandTest {
    @Test
    public void a_command_must_be_constructed_with_a_command_line() {
        Command command = new Command("help");

        assertThat(command.toString(), is("help"));
    }

    @Test
    public void a_command_can_have_arguments() {
        Command command = new Command("add project secrets");

        assertThat(command.toString(), is("add"));
    }

    @Test
    public void a_command_arguments_can_be_accessed() {
        Command command = new Command("add project secrets");

        assertThat(command.getArguments(), is("project secrets"));
    }
}
