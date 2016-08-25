package com.codurance.training.tasks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CommandTest {
    @Test
    public void a_command_must_be_constructed_with_a_name() {
        Command command = new Command("help");

        assertThat(command.toString(), is("help"));
    }
}
