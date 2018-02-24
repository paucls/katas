package com.katas;

public class MarsRover {

    private static final char BACKWARD_COMMAND = 'b';
    private static final char FORWARD_COMMAND = 'f';
    private static final char TURN_LEFT_COMMAND = 'l';
    private static final char TURN_RIGHT_COMMAND = 'r';

    private GridPosition position;
    private Direction direction;

    MarsRover() {
        position = new GridPosition(0, 0);
        direction = Direction.NORTH;
    }

    public GridPosition currentPosition() {
        return position;
    }

    public Direction currentDirection() {
        return direction;
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
                case TURN_LEFT_COMMAND:
                    turnLeft();
                    break;
                case TURN_RIGHT_COMMAND:
                    turnRight();
                    break;
            }
        }
    }

    private void turnRight() {
        switch (direction) {
            case NORTH:
                direction = Direction.EAST;
                break;
            case EAST:
                direction = Direction.SOUTH;
                break;
            case SOUTH:
                direction = Direction.WEST;
                break;
            case WEST:
                direction = Direction.NORTH;
                break;
        }
    }

    private void turnLeft() {
        switch (direction) {
            case NORTH:
                direction = Direction.WEST;
                break;
            case WEST:
                direction = Direction.SOUTH;
                break;
            case SOUTH:
                direction = Direction.EAST;
                break;
            case EAST:
                direction = Direction.NORTH;
                break;
        }
    }

    private void moveBackward() {
        position = new GridPosition(0, position.y - 1);
    }

    private void moveForward() {
        position = new GridPosition(0, position.y + 1);
    }
}
