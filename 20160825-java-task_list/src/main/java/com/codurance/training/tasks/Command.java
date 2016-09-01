package com.codurance.training.tasks;

public class Command {

    private static final String COMMAND_SEPARATOR = " ";
    private String name;
    private String arguments;

    public Command(String commandLine) {
        parseCommandLine(commandLine);
    }

    private void parseCommandLine(String commandLine) {
        String[] commandParts = splitCommandLine(commandLine);

        this.name = commandParts[0];

        if (commandParts.length > 1) {
            this.arguments = commandParts[1];
        }
    }

    private String[] splitCommandLine(String commandLine) {
        return commandLine.split(COMMAND_SEPARATOR, 2);
    }

    @Override
    public String toString() {
        return this.name;
    }

    public String getArguments() {
        return this.arguments;
    }
}
