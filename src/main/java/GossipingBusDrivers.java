public class GossipingBusDrivers {
    public static final int MINUTES_IN_A_DAY = 480;

    private Driver driverA;
    private Driver driverB;

    public GossipingBusDrivers(Driver driverA, Driver driverB) {
        this.driverA = driverA;
        this.driverB = driverB;
    }

    public Integer stopsNeededToShareAllGossips() {
        for (int currentMinute = 0; currentMinute < MINUTES_IN_A_DAY; currentMinute++) {
            if (allGossipsExchanged()) {
                return currentMinute;
            }
        }
        return -1;
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
}
