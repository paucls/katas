package com.katas;

public class MarsRover {

    private int[] position = new int[]{0, 0};

    public int[] currentPosition() {
        return this.position;
    }

    public void handleCommand(char[] commands) {
        for (char command : commands) {
            moveForward();
        }
    }

    private void moveForward() {
        this.position = new int[]{this.position[0], this.position[1] + 1};
    }
}
