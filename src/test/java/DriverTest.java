import org.junit.Test;

import static java.lang.Integer.valueOf;
import static org.junit.Assert.assertEquals;

public class DriverTest {
    @Test
    public void drivers_start_by_knowing_one_gossip() {
        assertEquals(valueOf(1), new Driver().knownGossips());
    }
}
