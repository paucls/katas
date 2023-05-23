import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Gossiping {
    private final int[][] routes;

    private final HashMap<Integer, Driver> drivers = new HashMap<>();

    public Gossiping(int[][] routes) {
        this.routes = routes;

        IntStream.range(0, routes.length)
                .forEach(i -> drivers.put(i, new Driver(i)));
    }

    public String howLongItTakes() {

        for (int stopIdx = 0; stopIdx < routes[0].length; stopIdx++) {

            if (routes[0][stopIdx] == routes[1][stopIdx]) {
                drivers.get(0).indicateItKnowsAboutGossip(drivers.get(1).getGossipsItKnowsAbout());
                drivers.get(1).indicateItKnowsAboutGossip(drivers.get(0).getGossipsItKnowsAbout());
            }

            boolean allKnowAll = drivers.values().stream().allMatch(driver -> driver.getGossipsItKnowsAbout().size() == drivers.size());

            if (allKnowAll) {
                return String.valueOf(stopIdx + 1);
            }
        }

        return "never";
    }
}

class Driver {
    private final Set<Integer> gossipsItKnowsAbout = new HashSet<>();

    public Driver(Integer driverNumber) {
        gossipsItKnowsAbout.add(driverNumber);
    }

    public Set<Integer> getGossipsItKnowsAbout() {
        return gossipsItKnowsAbout;
    }

    public void indicateItKnowsAboutGossip(Set<Integer> gossipNumber) {
        gossipsItKnowsAbout.addAll(gossipNumber);
    }
}