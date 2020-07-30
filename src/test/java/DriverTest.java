import org.junit.Test;

import static java.lang.Integer.valueOf;
import static org.junit.Assert.assertEquals;

public class DriverTest {
    @Test
    public void a_driver_always_start_knowing_only_one_gossip() {
        assertEquals(valueOf(1), new Driver().knownGossips());
    }

    @Test
    public void drivers_can_exchanges_gossips_each_other() {
        Driver driver = new Driver();
        Driver otherDriver = new Driver();

        driver.exchangeGossips(otherDriver);

        assertEquals(valueOf(2), driver.knownGossips());
        assertEquals(valueOf(2), otherDriver.knownGossips());
    }


}
