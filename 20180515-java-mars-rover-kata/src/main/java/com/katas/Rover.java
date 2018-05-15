package com.katas;

class Rover {

    private static final char FORWARD_COMMAND = 'F';
    private static final char RIGHT_COMMAND = 'R';
    private static final String NORTH = "N";
    private static final String EAST = "E";
    private static final String SOUTH = "S";
    private static final String WEST = "W";

    private String direction = NORTH;
    private int positionX = 0;
    private int positionY = 0;

    String reportPosition() {
        return positionX + ":" + positionY + ":" + direction;
    }

    void execute(String commands) {
        for (char command : commands.toCharArray()) {
            if (command == FORWARD_COMMAND) {
                moveFordward();
            } else if (command == RIGHT_COMMAND) {
                turnRight();
            } else {
                turnLeft();
            }
        }
    }

    private void moveFordward() {
        if (direction.equals(NORTH)) {
            positionY++;
        } else if (direction.equals(SOUTH)) {
            positionY--;
        } else if (direction.equals(EAST)) {
            positionX++;
        } else {
            positionX--;
        }
    }

    private void turnRight() {
        if (this.direction.equals(NORTH)) this.direction = EAST;
        else if (this.direction.equals(EAST)) this.direction = SOUTH;
        else if (this.direction.equals(SOUTH)) this.direction = WEST;
        else this.direction = NORTH;
    }

    private void turnLeft() {
        if (this.direction.equals(NORTH)) this.direction = WEST;
        else if (this.direction.equals(WEST)) this.direction = SOUTH;
        else if (this.direction.equals(SOUTH)) this.direction = EAST;
        else this.direction = NORTH;
    }
}
