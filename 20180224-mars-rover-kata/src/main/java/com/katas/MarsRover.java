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
        direction = direction.right();
    }

    private void turnLeft() {
        direction = direction.left();
    }

    private void moveBackward() {
        position = new GridPosition(position.x, position.y - 1);
    }

    private void moveForward() {
        switch (direction) {
            case NORTH:
                position = new GridPosition(position.x, position.y + 1);
                break;
            case EAST:
                position = new GridPosition(position.x + 1, position.y);
                break;
            case SOUTH:
                position = new GridPosition(position.x, position.y - 1);
                break;
            case WEST:
                position = new GridPosition(position.x - 1, position.y);
        }
    }
}
