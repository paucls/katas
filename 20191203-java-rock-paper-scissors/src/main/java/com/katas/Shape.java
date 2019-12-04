package com.katas;

public abstract class Shape {

    private String name;

    public Shape(String name) {
        this.name = name;
    }

    public abstract boolean beats(Shape otherShape);

    protected boolean isPaper() {
        return "Paper".equals(name);
    }

    protected boolean isScissors() {
        return "Scissors".equals(name);
    }

    protected boolean isRock() {
        return "Rock".equals(name);
    }
}
