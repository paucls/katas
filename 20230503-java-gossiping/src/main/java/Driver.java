import java.util.HashSet;
import java.util.Set;

class Driver {
    private final Set<Integer> gossipsItKnowsAbout = new HashSet<>();

    public Driver(Integer driverNumber) {
        gossipsItKnowsAbout.add(driverNumber);
    }

    public Integer gossipsCount() {
        return gossipsItKnowsAbout.size();
    }

    public void indicateItKnowsAboutGossip(Set<Integer> gossipNumber) {
        gossipsItKnowsAbout.addAll(gossipNumber);
    }

    public void exchangeGossipsWith(Driver anotherDriver) {
        this.indicateItKnowsAboutGossip(anotherDriver.gossipsItKnowsAbout);
        anotherDriver.indicateItKnowsAboutGossip(this.gossipsItKnowsAbout);
    }
}
