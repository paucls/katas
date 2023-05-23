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
                for (int otherDriverIdx = 0; otherDriverIdx < drivers.size(); otherDriverIdx++) {
                    if (routes[driverIdx][stopIdx] == routes[otherDriverIdx][stopIdx]) {
                        drivers.get(driverIdx).exchangeGossipsWith(drivers.get(otherDriverIdx));
                    }
                }
            }

            boolean allKnowAll = drivers.values().stream().allMatch(driver -> driver.gossipsCount() == drivers.size());
            if (allKnowAll) {
                return String.valueOf(stopIdx + 1);
            }
        }

        return "never";
    }
}
