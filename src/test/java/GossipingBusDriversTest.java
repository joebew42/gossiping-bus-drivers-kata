import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GossipingBusDriversTest {
    @Test
    public void when_not_all_gossips_are_exchanged_among_two_drivers_returns_never() {
        Driver driverA = new Driver(new Route(2, 1, 2));
        Driver driverB = new Driver(new Route(5, 2, 8));

        GossipingBusDrivers gossipingBusDrivers = new GossipingBusDrivers(driverA, driverB);

        assertNever(gossipingBusDrivers.stopsNeededToShareAllGossips());
    }

    @Test
    public void when_all_gossips_are_exchanged_among_two_drivers_returns_the_number_of_needed_stops() {
        Driver driverA = new Driver(new Route(2, 1, 2, 7));
        Driver driverB = new Driver(new Route(5, 2, 8, 7));

        GossipingBusDrivers gossipingBusDrivers = new GossipingBusDrivers(driverA, driverB);

        assertNumberOfNeededStops(4, gossipingBusDrivers.stopsNeededToShareAllGossips());
    }

    @Test
    @Ignore
    public void when_all_gossips_are_exchanged_among_all_drivers_returns_the_number_of_needed_stops() {
        Driver driverA = new Driver(new Route(3, 1, 2, 3));
        Driver driverB = new Driver(new Route(3, 2, 3, 1));
        Driver driverC = new Driver(new Route(4, 2, 3, 4, 5));

        GossipingBusDrivers gossipingBusDrivers = new GossipingBusDrivers(driverA, driverB, driverC);

        assertNumberOfNeededStops(5, gossipingBusDrivers.stopsNeededToShareAllGossips());
    }

    private void assertNumberOfNeededStops(Integer expectedStops, Integer actualStops) {
        assertEquals(expectedStops, actualStops);
    }

    private void assertNever(Integer stopsNeeded) {
        assertEquals(GossipingBusDrivers.NEVER, stopsNeeded);
    }
}
