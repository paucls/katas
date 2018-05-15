package com.katas;

class Rover {

    private static final char RIGHT_COMMAND = 'R';
    private static final String NORTH = "N";
    private static final String EAST = "E";
    private static final String SOUTH = "S";
    private static final String WEST = "W";

    private String direction = NORTH;

    String reportPosition() {
        return "0:0:" + direction;
    }

    void execute(String commands) {
        for (char command : commands.toCharArray()) {
            if (command == RIGHT_COMMAND) {
                turnRight();
            } else {
                turnLeft();
            }
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
