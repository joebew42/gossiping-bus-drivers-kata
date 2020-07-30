import org.junit.Test;

import static java.lang.Integer.valueOf;
import static org.junit.Assert.assertEquals;

public class GossipingBusDriversTest {
    public static final Integer NEVER = valueOf(-1);

    @Test
    public void when_not_all_gossips_are_exchanged_among_all_drivers_returns_never() {
        Driver driverA = new Driver(new Route(2, 1, 2));
        Driver driverB = new Driver(new Route(5, 2, 8));

        GossipingBusDrivers gossipingBusDrivers = new GossipingBusDrivers(driverA, driverB);

        assertNever(gossipingBusDrivers.stopsNeededToShareAllGossips());
    }

    private void assertNever(Integer stopsNeeded) {
        assertEquals(NEVER, stopsNeeded);
    }
}
