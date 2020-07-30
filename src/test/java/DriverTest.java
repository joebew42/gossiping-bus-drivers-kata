import org.junit.Test;

import static java.lang.Integer.valueOf;
import static org.junit.Assert.assertEquals;

public class DriverTest {

    public static final int ONE = 1;

    @Test
    public void a_driver_always_start_knowing_only_one_gossip() {
        Driver driver = new Driver();

        assertNumberOfGossips(1, driver.numberOfGossips());
    }

    @Test
    public void drivers_can_exchange_gossips_each_other() {
        Driver driverA = new Driver();
        Driver driverB = new Driver();

        driverA.exchangeGossips(driverB);

        assertNumberOfGossips(2, driverA.numberOfGossips());
        assertNumberOfGossips(2, driverB.numberOfGossips());
    }

    @Test
    public void drivers_exchanges_all_the_known_gossips_each_other() {
        Driver driverA = new Driver();
        Driver driverB = new Driver();
        Driver driverC = new Driver();

        driverA.exchangeGossips(driverB);
        driverB.exchangeGossips(driverC);

        assertNumberOfGossips(2, driverA.numberOfGossips());
        assertNumberOfGossips(3, driverB.numberOfGossips());
        assertNumberOfGossips(3, driverC.numberOfGossips());
    }

    @Test
    public void drivers_not_exchanges_the_same_gossip_twice() {
        Driver driverA = new Driver();
        Driver driverB = new Driver();

        driverA.exchangeGossips(driverB);
        driverB.exchangeGossips(driverA);

        assertNumberOfGossips(2, driverA.numberOfGossips());
        assertNumberOfGossips(2, driverB.numberOfGossips());
    }

    @Test
    public void when_drivers_not_end_up_at_the_same_stop_they_not_exchange_gossips() {
        Driver driverA = new Driver(Route.withStops(1));
        Driver driverB = new Driver(Route.withStops(2));

        driverA.exchangeGossipsAtMinute(ONE, driverB);

        assertNumberOfGossips(1, driverA.numberOfGossips());
        assertNumberOfGossips(1, driverB.numberOfGossips());
    }

    @Test
    public void when_drivers_end_up_at_the_same_stop_they_exchange_gossips() {
        Driver driverA = new Driver(Route.withStops(1));
        Driver driverB = new Driver(Route.withStops(1));

        driverA.exchangeGossipsAtMinute(ONE, driverB);

        assertNumberOfGossips(2, driverA.numberOfGossips());
        assertNumberOfGossips(2, driverB.numberOfGossips());
    }

    private void assertNumberOfGossips(int i, Integer actual) {
        assertEquals(valueOf(i), actual);
    }
}
