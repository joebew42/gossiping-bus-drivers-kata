public class GossipingBusDrivers {
    public static final Integer MINUTES_IN_A_DAY = 480;
    public static final Integer NEVER = -1;

    private Driver driverA;
    private Driver driverB;

    public GossipingBusDrivers(Driver driverA, Driver driverB) {
        this.driverA = driverA;
        this.driverB = driverB;
    }

    public GossipingBusDrivers(Driver ... drivers) {
    }

    public Integer stopsNeededToShareAllGossips() {
        for (int currentMinute = 0; currentMinute < MINUTES_IN_A_DAY; currentMinute++) {
            exchangeAllGossipsAt(currentMinute);

            if (allGossipsExchanged()) {
                return stopsNeededFrom(currentMinute);
            }
        }
        return NEVER;
    }

    private void exchangeAllGossipsAt(Integer minute) {
        driverA.exchangeGossipsAtMinute(minute, driverB);
    }

    private boolean allGossipsExchanged() {
        if (allGossipsExchangedFor(driverA) && allGossipsExchangedFor(driverB)) {
            return true;
        }
        return false;
    }

    private boolean allGossipsExchangedFor(Driver driver) {
        return driver.numberOfGossips() == numberOfDrivers();
    }

    private int numberOfDrivers() {
        return 2;
    }

    private Integer stopsNeededFrom(Integer minute) {
        return minute + 1;
    }
}
