package com.codurance.training.tasks;

import java.io.PrintWriter;

public class Command {

    private static final String COMMAND_SEPARATOR = " ";
    private String name;
    private String arguments;
    protected PrintWriter out;

    public Command(String commandLine) {
        parseCommandLine(commandLine);
    }

    public Command(String commandLine, PrintWriter printWriter) {
        parseCommandLine(commandLine);
        this.out = printWriter;
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

    public String getName() {
        return this.name;
    }

    public String getArguments() {
        return this.arguments;
    }

    //TODO: make it abstract
    public void execute() {
        switch (getName()) {
            case "today":
                today();
                break;
            case "deadline":
                break;
        }
    }

    private void today() {
        out.println("katas");
        out.println("    [ ] 1: roman numbers");
        out.println();
    }

    public static Command create(String commandLine, PrintWriter printWriter) {
        switch (commandLine) {
            case "help":
                return new HelpCommand(commandLine, printWriter);
            case "today":
                return new Command(commandLine, printWriter);
            case "deadline":
                return new Command(commandLine, printWriter);
            default:
                return new Command(commandLine, printWriter);
        }
    }
}
