package com.codurance.training.tasks;

import java.io.PrintWriter;

public class HelpCommand extends Command {
    public HelpCommand(String commandLine, PrintWriter printWriter) {
        super(commandLine, printWriter);
    }

    @Override
    public void execute() {
        out.println("Commands:");
        out.println("  show");
        out.println("  add project <project name>");
        out.println("  add task <project name> <task description>");
        out.println("  check <task ID>");
        out.println("  uncheck <task ID>");
        out.println();
    }
}
