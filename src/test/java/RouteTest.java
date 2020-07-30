import org.junit.Test;

import static java.lang.Integer.valueOf;
import static org.junit.Assert.assertEquals;

public class RouteTest {
    @Test
    public void return_the_stop_at_a_specific_minute() {
        Route route = new Route(2, 4, 8);

        assertEquals(valueOf(2), route.stopAtMinute(0));
        assertEquals(valueOf(4), route.stopAtMinute(1));
        assertEquals(valueOf(8), route.stopAtMinute(2));
    }

    @Test
    public void stops_are_repeated_over_and_over() {
        Route route = new Route(2, 4, 8);

        assertEquals(valueOf(2), route.stopAtMinute(3));
        assertEquals(valueOf(4), route.stopAtMinute(4));
        assertEquals(valueOf(8), route.stopAtMinute(5));
    }
}