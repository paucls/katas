import java.util.HashMap;
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

            for (int driverIdx = 0; driverIdx < drivers.size(); driverIdx++) {
                for (int anotherDriverIdx = 0; anotherDriverIdx < drivers.size(); anotherDriverIdx++) {
                    if (driversMeetInStop(driverIdx, anotherDriverIdx, stopIdx)) {
                        drivers.get(driverIdx).exchangeGossipsWith(drivers.get(anotherDriverIdx));
                    }
                }
            }

            if (allDriversKnowAllGossips()) {
                return String.valueOf(stopIdx + 1);
            }
        }

        return "never";
    }

    private boolean driversMeetInStop(int driverIdx, int anotherDriverIdx, int stopIdx) {
        return routes[driverIdx][stopIdx] == routes[anotherDriverIdx][stopIdx];
    }

    private boolean allDriversKnowAllGossips() {
        return drivers.values().stream().allMatch(driver -> driver.gossipsCount() == drivers.size());
    }
}
