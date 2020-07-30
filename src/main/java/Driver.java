public class Driver {

    private Integer knownGossips;

    public Driver() {
        knownGossips = 1;
    }

    public Integer knownGossips() {
        return knownGossips;
    }

    public void exchangeGossips(Driver other) {
        addGossips(other.knownGossips());
        other.addGossips(knownGossips() - other.knownGossips());
    }

    private void addGossips(Integer gossips) {
        this.knownGossips += gossips;
    }
}
