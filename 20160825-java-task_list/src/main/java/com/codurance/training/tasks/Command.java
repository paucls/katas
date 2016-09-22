package com.codurance.training.tasks;

import java.io.PrintWriter;

public class Command {

    private static final String COMMAND_SEPARATOR = " ";
    private String name;
    private String arguments;
    private PrintWriter out;

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

    public void execute() {
        switch (getName()) {
            case "help":
                help();
                break;
            case "today":
                today();
                break;
            case "deadline":
                break;
        }
    }

    private void help() {
        out.println("Commands:");
        out.println("  show");
        out.println("  add project <project name>");
        out.println("  add task <project name> <task description>");
        out.println("  check <task ID>");
        out.println("  uncheck <task ID>");
        out.println();
    }

    private void today() {
        out.println("katas");
        out.println("    [ ] 1: roman numbers");
        out.println();
    }

}
