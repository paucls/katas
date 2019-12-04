package com.katas;

public class Rock extends Shape {
    public Rock() {
        super("Rock");
    }

    @Override
    public boolean beats(Shape otherShape) {
        return otherShape.isScissors();
    }
}
