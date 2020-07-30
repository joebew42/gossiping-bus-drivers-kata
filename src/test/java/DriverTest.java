import org.junit.Ignore;
import org.junit.Test;

import static java.lang.Integer.valueOf;
import static java.util.List.of;
import static org.junit.Assert.assertEquals;

public class DriverTest {

    public static final int ONE = 1;

    @Test
    public void a_driver_always_start_knowing_only_one_gossip() {
        assertEquals(valueOf(1), new Driver().numberOfGossips());
    }

    @Test
    public void drivers_can_exchange_gossips_each_other() {
        Driver driverA = new Driver();
        Driver driverB = new Driver();

        driverA.exchangeGossips(driverB);

        assertEquals(valueOf(2), driverA.numberOfGossips());
        assertEquals(valueOf(2), driverB.numberOfGossips());
    }

    @Test
    public void drivers_exchanges_all_the_known_gossips_each_other() {
        Driver driverA = new Driver();
        Driver driverB = new Driver();
        Driver driverC = new Driver();

        driverA.exchangeGossips(driverB);
        driverB.exchangeGossips(driverC);

        assertEquals(valueOf(2), driverA.numberOfGossips());
        assertEquals(valueOf(3), driverB.numberOfGossips());
        assertEquals(valueOf(3), driverC.numberOfGossips());
    }

    @Test
    public void drivers_not_exchanges_the_same_gossip_twice() {
        Driver driverA = new Driver();
        Driver driverB = new Driver();

        driverA.exchangeGossips(driverB);
        driverB.exchangeGossips(driverA);

        assertEquals(valueOf(2), driverA.numberOfGossips());
        assertEquals(valueOf(2), driverB.numberOfGossips());
    }

    @Test
    public void when_drivers_not_end_up_at_the_same_stop_they_not_exchange_gossips() {
        Driver driverA = new Driver(new Route(of(1)));
        Driver driverB = new Driver(new Route(of(2)));

        driverA.exchangeGossipsAtMinute(ONE, driverB);

        assertEquals(valueOf(1), driverA.numberOfGossips());
        assertEquals(valueOf(1), driverB.numberOfGossips());
    }

    @Test
    @Ignore
    public void when_drivers_end_up_at_the_same_stop_they_exchange_gossips() {
        Driver driverA = new Driver(new Route(of(1)));
        Driver driverB = new Driver(new Route(of(1)));

        driverA.exchangeGossipsAtMinute(ONE, driverB);

        assertEquals(valueOf(2), driverA.numberOfGossips());
        assertEquals(valueOf(2), driverB.numberOfGossips());
    }
}
