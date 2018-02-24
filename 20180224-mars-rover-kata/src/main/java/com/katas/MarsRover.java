package com.katas;

public class MarsRover {

    public static final char BACKWARD_COMMAND = 'b';
    public static final char FORWARD_COMMAND = 'f';
    private GridPosition position = new GridPosition(0, 0);

    public GridPosition currentPosition() {
        return position;
    }

    public String currentDirection() {
        return "N";
    }

    public void handleCommand(char[] commands) {
        for (char command : commands) {
            switch (command) {
                case BACKWARD_COMMAND:
                    moveBackward();
                    break;
                case FORWARD_COMMAND:
                    moveForward();
                    break;
            }
        }
    }

    private void moveBackward() {
        position = new GridPosition(0, position.y - 1);
    }

    private void moveForward() {
        position = new GridPosition(0, position.y + 1);
    }
}
