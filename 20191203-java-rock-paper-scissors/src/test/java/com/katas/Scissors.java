package com.katas;

public class Scissors extends Shape {
    public Scissors() {
        super("Scissors");
    }

    @Override
    public boolean beats(Shape otherShape) {
        return otherShape.isPaper();
    }
}
