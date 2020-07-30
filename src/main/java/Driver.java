public class Driver {

    private Integer numberOfKnownGossips;

    public Driver() {
        numberOfKnownGossips = 1;
    }

    public Integer knownGossips() {
        return numberOfKnownGossips;
    }

    public void exchangeGossips(Driver other) {
        addGossips(other.knownGossips());
        other.addGossips(knownGossips() - other.knownGossips());
    }

    private void addGossips(Integer gossips) {
        this.numberOfKnownGossips += gossips;
    }
}
