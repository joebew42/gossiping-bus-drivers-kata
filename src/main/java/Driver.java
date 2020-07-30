import java.util.HashSet;
import java.util.Set;

public class Driver {

    private final Set<Gossip> knownGossips;
    private Route route;

    public Driver() {
        this(new Route());
    }

    public Driver(Route route) {
        this.route = route;
        this.knownGossips = initialGossips();
    }

    public Integer numberOfGossips() {
        return gossips().size();
    }

    public void exchangeGossips(Driver other) {
        addGossips(other.gossips());
        other.addGossips(gossips());
    }

    public void exchangeGossipsAtMinute(Integer minute, Driver otherDriver) {
        Integer stop = route.stopAtMinute(minute);
        Integer otherStop = otherDriver.route.stopAtMinute(minute);

        if (stop.equals(otherStop)) {
            exchangeGossips(otherDriver);
        }
    }

    private void addGossips(Set<Gossip> gossips) {
        this.gossips().addAll(gossips);
    }

    private Set<Gossip> gossips() {
        return knownGossips;
    }

    private HashSet<Gossip> initialGossips() {
        return new HashSet<>() {{
            add(new Gossip());
        }};
    }
}
