package com.katas;

class Rover {

    private static final char RIGHT_COMMAND = 'R';

    private String direction = "N";

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
        if (this.direction.equals("N")) this.direction = "E";
        else if (this.direction.equals("E")) this.direction = "S";
        else if (this.direction.equals("S")) this.direction = "W";
        else this.direction = "N";
    }

    private void turnLeft() {
        if (this.direction.equals("N")) this.direction = "W";
        else if (this.direction.equals("W")) this.direction = "S";
        else if (this.direction.equals("S")) this.direction = "E";
        else this.direction = "N";
    }
}
