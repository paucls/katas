package com.codurance.training.tasks;

public class Command {

    private String name;

    public Command(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
