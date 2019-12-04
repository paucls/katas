package com.katas;

public class Paper extends Shape{

    public Paper() {
        super("Paper");
    }

    @Override
    public boolean beats(Shape otherShape) {
        return otherShape.isRock();
    }
}
