package com.katas;

public class Rover {

    private static final int STEP = 1;

    private Position position;

    Rover(Position position) {
        this.position = position;
    }

    public void moveForward() {
        position = new Position(position.getX(), position.getY() + STEP);
    }

    public void moveBackward() {
        position = new Position(position.getX(), position.getY() - STEP);
    }

    public Position getPosition() {
        return position;
    }
}
