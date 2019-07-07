package mars_rover;

import java.util.ArrayList;
import java.util.List;

public class Rover {

    private String direction;
    private int y;
    private int x;

    public Rover(int x, int y, String direction) {
        this.direction = direction;
        this.y = y;
        this.x = x;
    }

    public void receive(String commandsSequence) {

        List<String> commands = new ArrayList<>();

        for (int i = 0; i < commandsSequence.length(); ++i) {
            commands.add(commandsSequence.substring(i, i + 1));
        }

        for (String command : commands) {
            processCommand(command);
        }
    }

    private void processCommand(String command) {
        if (command.equals("l")) {
            rotateLeft();
        } else if (command.equals("r")) {
            rotateRight();
        } else if (command.equals("f")) {
            moveForwards();
        } else {
            moveBackwards();
        }
    }

    private void rotateLeft() {
        // Rotate Rover left
        if (direction.equals("N")) {
            direction = "W";
        } else if (direction.equals("S")) {
            direction = "E";
        } else if (direction.equals("W")) {
            direction = "S";
        } else {
            direction = "N";
        }
    }

    private void rotateRight() {
        // Rotate Rover right
        if (direction.equals("N")) {
            direction = "E";
        } else if (direction.equals("S")) {
            direction = "W";
        } else if (direction.equals("W")) {
            direction = "N";
        } else {
            direction = "S";
        }
    }

    private void moveForwards() {
        int displacement = 1;

        if (direction.equals("N")) {
            y += displacement;
        } else if (direction.equals("S")) {
            y -= displacement;
        } else if (direction.equals("W")) {
            x -= displacement;
        } else {
            x += displacement;
        }
    }

    private void moveBackwards() {
        int displacement = -1;

        if (direction.equals("N")) {
            y += displacement;
        } else if (direction.equals("S")) {
            y -= displacement;
        } else if (direction.equals("W")) {
            x -= displacement;
        } else {
            x += displacement;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rover rover = (Rover) o;

        if (y != rover.y) return false;
        if (x != rover.x) return false;
        return direction != null ? direction.equals(rover.direction) : rover.direction == null;

    }

    @Override
    public int hashCode() {
        int result = direction != null ? direction.hashCode() : 0;
        result = 31 * result + y;
        result = 31 * result + x;
        return result;
    }

    @Override
    public String toString() {
        return "Rover{" +
            "direction='" + direction + '\'' +
            ", y=" + y +
            ", x=" + x +
            '}';
    }
}
