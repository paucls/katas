package com.katas;

public class Rover {

    private static final int STEP = 1;

    private Position position;

    Rover(Position position) {
        this.position = position;
    }

    public void moveForward() {
        position = position.plusY(STEP);
    }

    public void moveBackward() {
        position = position.minusY(STEP);
    }

    public Position getPosition() {
        return position;
    }
}
