package codingdojo.officecleaner9;

import java.util.TreeMap;

public class RobotCleaner {
    /**
     * Directions NEWS = North, East, West, South
    */
        final String DIRECTIONS = "NEWS";
    /**
     * Maximum number of steps
    */
        final int MAX_STEPS = 100000;
    /**
     * Upper bounadry width of the room.
     * from problem x(-100,000 <= x <= 100,000).
    */
    private final int FLOOR_UPPER_WIDTH = 100000;
    /**
     * Lower bounadry width of the room.
     * from problem x(-100,000 <= x <= 100,000).
    */
    private final int FLOOR_LOWER_WIDTH = -100000;
    /**
     * Upper bounadry length of the room.
     * from problem y(-100,000 <= y <= 100,000).
    */
    private final int FLOOR_UPPER_LENGTH = 100000;
    /**
     * Lower bounadry length of the room.
     * from problem y(-100,000 <= y <= 100,000).
    */
    private final int FLOOR_LOWER_LENGTH = -100000;
    /**
     * Current Location X.
    */
    private static int CURRENT_X;
    /**
     * Current Location Y.
    */
    private static int CURRENT_Y;

    /**
     * Holds the x y coordiantes on floor.
    */
    public class Coordinates
    {
        public int X;
        public int Y;
            public Coordinates(int x, int y)
        {
            this.X = x;
            this.Y = y;
        }

        public String ToString()
        {
            return "[" + this.X + ", " + this.Y + ", Visit]";
        }
    }
    /**
     * Sorted List(for fast searching) of visited spaces(coordinates) on floor.
    */
    public TreeMap<String, Coordinates> cleanedPlaces = new TreeMap<String, Coordinates>();

    /**
     * Constructor with no parameter
    */
    public RobotCleaner() { }

    /**
     * Starts the robot at given location and Visit it
    */
    // <param name="X">X coordinate</param>
    // <param name="Y">Y coordiante</param>
    public void StartAt(int X, int Y)
    {
        CURRENT_X = X; // x(-100,000 <= x <= 100,000)
        CURRENT_Y = Y; //y(-100,000 <= y <= 100,000)
        //Visited start position,  (Key  = CURRENT_X + CURRENT_Y) for searching
        cleanedPlaces.put(String.format("%s %s",CURRENT_X, CURRENT_Y), new Coordinates(CURRENT_X, CURRENT_Y));
    }

    /**
     * Visits the floor
     * in direction
     * with number of steps
    */
    // <param name="direction">Direction {'E', 'W', 'N', 'S'}</param>
    // <param name="steps"></param>
    public void cleanFloor(char direction, int steps)
    {
        // if the correct direction is no given it exits
        if (!DIRECTIONS.contains(""+direction))
            return;
        //if steps is less than 0 or greater than MAX_STEPS it exits
        if (steps < 0 || steps > MAX_STEPS)
            return;
        switch (direction)
        {
            case 'N':
                cleanNorthDirection(steps);
                break;
            case 'S':
                cleanDirection('S', steps);
                break;
            case 'E':
                cleanEastDirection(steps);
                break;
            case 'W':
                cleanWestDirection(steps);
                break;
        }
    }

    private void cleanWestDirection(int steps) {
        for (int i = 0; i < steps; i++)
        {
            if (isRobotAtTheBoundaryOfTheFloor('W')) {
                break;
            }
            //if place is not visited
            if (!cleanedPlaces.containsKey(String.format("%s %s", CURRENT_X + 1, CURRENT_Y)))
            {
                //Visit it and add to the visited places
                cleanedPlaces.put(String.format("%s %s", CURRENT_X + 1, CURRENT_Y), new Coordinates(++CURRENT_X, CURRENT_Y));
            }
            else
            {
                //otherwise moves to the next location
                ++CURRENT_X;
            }
        }
    }

    private void cleanEastDirection(int steps) {
        for (int i = 0; i < steps; i++)
        {
            if (isRobotAtTheBoundaryOfTheFloor('E')) {
                break;
            }
            //if place is not visited
            if (!cleanedPlaces.containsKey(String.format("%s %s", CURRENT_X - 1, CURRENT_Y)))
            {
                //Visit it and add to the visited places
                cleanedPlaces.put(String.format("%s %s", CURRENT_X - 1, CURRENT_Y), new Coordinates(--CURRENT_X, CURRENT_Y));
            }
            else
            {
                //otherwise moves to the next location
                --CURRENT_X;
            }
        }
    }

    private void cleanDirection(char direction, int steps) {
        for (int i = 0; i < steps; i++) {
            if (isRobotAtTheBoundaryOfTheFloor(direction)) {
                break;
            }

            // move
            move(direction);

            // clean (if place is not visited)
            if (!cleanedPlaces.containsKey(String.format("%s %s", CURRENT_X, CURRENT_Y))) {
                //Visit it and add to the visited places
                cleanedPlaces.put(String.format("%s %s", CURRENT_X, CURRENT_Y), new Coordinates(CURRENT_X, CURRENT_Y));
            }
        }
    }

    private static void move(char direction) {
        if (direction == 'N') {
        } else if (direction == 'S') {
            --CURRENT_Y;
        } else if (direction == 'E') {
        } else if (direction == 'W') {
        }
    }

    private void cleanNorthDirection(int steps) {
        for (int i = 0; i < steps; i++) {
            if (isRobotAtTheBoundaryOfTheFloor('N')) {
                break;
            }

            //if place is not visited
            if (!cleanedPlaces.containsKey(String.format("%s %s", CURRENT_X, CURRENT_Y + 1))) {
                // clean
                cleanedPlaces.put(String.format("%s %s", CURRENT_X, CURRENT_Y + 1), new Coordinates(CURRENT_X, ++CURRENT_Y));
            } else {
                //otherwise moves to the next location
                ++CURRENT_Y;
            }
        }
    }

    private boolean isRobotAtTheBoundaryOfTheFloor(char direction) {
        if (direction == 'N') {
            return CURRENT_Y + 1 > FLOOR_UPPER_LENGTH;
        } else if (direction == 'S') {
            return CURRENT_Y - 1 > FLOOR_UPPER_LENGTH;
        } else if (direction == 'E') {
            return CURRENT_X - 1 < FLOOR_LOWER_WIDTH;
        } else if (direction == 'W') {
            return CURRENT_X + 1 > FLOOR_UPPER_WIDTH;
        }
        return false;
    }

    public void PrintVisitedPlaces()
    {

        var result = "";
        for (var spot : cleanedPlaces.values())
        {
            result += spot.ToString();
            result += "\n";
        }
        //System.out.println(result);

    }
}
