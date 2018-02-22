package com.katas;

public class RoverAPI {

    private static final char FORWARD_COMMAND = 'f';
    private static final char BACKWARD_COMMAND = 'b';

    private Rover rover;

    RoverAPI(Rover rover) {
        this.rover = rover;
    }

    public void handle(char[] commands) {
        switch (commands[0]) {
            case FORWARD_COMMAND:
                rover.moveForward();
                break;
            case BACKWARD_COMMAND:
                rover.moveBackward();
                break;
                
        }
    }
}
