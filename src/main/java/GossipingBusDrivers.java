import java.util.List;

import static java.util.Arrays.asList;

public class GossipingBusDrivers {
    public static final Integer MINUTES_IN_A_DAY = 480;
    public static final Integer NEVER = -1;

    private List<Driver> drivers;

    public GossipingBusDrivers(Driver... drivers) {
        this.drivers = asList(drivers);
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
        for (int i = 0; i < drivers.size() - 1; i++) {
            drivers.get(i).exchangeGossipsAtMinute(minute, drivers.get(i + 1));
        }
    }

    private boolean allGossipsExchanged() {
        return drivers.stream().allMatch(this::allGossipsExchanged);
    }

    private boolean allGossipsExchanged(Driver driver) {
        return driver.numberOfGossips() == numberOfDrivers();
    }

    private int numberOfDrivers() {
        return drivers.size();
    }

    private Integer stopsNeededFrom(Integer minute) {
        return minute + 1;
    }
}
