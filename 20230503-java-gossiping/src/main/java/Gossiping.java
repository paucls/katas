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

        if (routes[0][0] == routes[1][0]) {
            drivers.get(0).indicateItKnowsAboutGossip(drivers.get(1).getGossipsItKnowsAbout());
            drivers.get(1).indicateItKnowsAboutGossip(drivers.get(0).getGossipsItKnowsAbout());

            if (drivers.get(0).getGossipsItKnowsAbout().size() == drivers.size()
            && drivers.get(1).getGossipsItKnowsAbout().size() == drivers.size()) {
                return "1";
            }
        }
        if (routes[0][1] == routes[1][1]) {
            drivers.get(0).indicateItKnowsAboutGossip(drivers.get(1).getGossipsItKnowsAbout());
            drivers.get(1).indicateItKnowsAboutGossip(drivers.get(0).getGossipsItKnowsAbout());

            if (drivers.get(0).getGossipsItKnowsAbout().size() == drivers.size()
                    && drivers.get(1).getGossipsItKnowsAbout().size() == drivers.size()) {
                return "2";
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