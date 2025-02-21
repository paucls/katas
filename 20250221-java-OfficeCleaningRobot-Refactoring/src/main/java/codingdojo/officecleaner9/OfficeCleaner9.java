package codingdojo.officecleaner9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OfficeCleaner9 {

    public static void main() {
        Scanner input = new Scanner(System.in);
        int noCommands = Integer.parseInt(input.nextLine());
        //from problem - number of commands n(0 <= n <= 10,000).
        if (noCommands < 0 || noCommands > 10000) {
            return;
        }

        // PARSING
        //read starting location of robot
        String[] startPoints = input.nextLine().split(" ");
        int x = Integer.parseInt(startPoints[0]);
        int y = Integer.parseInt(startPoints[1]);

        List<String[]> commandOptions = readCommands(noCommands, input);

        // EXECUTE ROBOT
        var robot = new RobotCleaner();

        robot.StartAt(x, y);

        //Reads the direction and number of steps and Visits the floor in each direction
        for (String[] options : commandOptions) {
            robot.CleanFloor(options[0].charAt(0), Integer.parseInt(options[1]));
        }

        robot.PrintVisitedPlaces();
        System.out.println(String.format("=> Cleaned: %s", robot.visitedPlaces.size()));
    }

    private static List<String[]> readCommands(int noCommands, Scanner input) {
        List<String[]> commandOptions = new ArrayList<>();
        for (int i = 0; i < noCommands; i++) {
            String[] options = input.nextLine().split(" ");
            commandOptions.add(options);
        }
        return commandOptions;
    }
}
