package com.katas;

public class MarsRover {

    private GridPosition position = new GridPosition(0, 0);

    public GridPosition currentPosition() {
        return position;
    }

    public void handleCommand(char[] commands) {
        for (char command : commands) {
            switch (command) {
                case 'b':
                    moveBackward();
                    break;
                case 'f':
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
