import java.util.HashSet;
import java.util.Set;

public class Driver {

    private final Set<Gossip> knownGossips;

    public Driver() {
        knownGossips = new HashSet<>(){{
            add(new Gossip());
        }};
    }

    public Integer numberOfGossips() {
        return gossips().size();
    }

    public void exchangeGossips(Driver other) {
        addGossips(other.gossips());
        other.addGossips(gossips());
    }

    private void addGossips(Set<Gossip> gossips) {
        this.gossips().addAll(gossips);
    }

    private Set<Gossip> gossips() {
        return knownGossips;
    }
}
