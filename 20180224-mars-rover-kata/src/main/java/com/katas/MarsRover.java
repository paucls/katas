package com.katas;

public class MarsRover {

    private int[] position = new int[]{0, 0};

    public int[] currentPosition() {
        return this.position;
    }

    public void handleCommand(char[] commands) {
        this.position = new int[]{0, 1};
    }
}
