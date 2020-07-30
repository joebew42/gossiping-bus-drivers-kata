import org.junit.Test;

import static java.lang.Integer.valueOf;
import static java.util.List.of;
import static org.junit.Assert.assertEquals;

public class RouteTest {
    @Test
    public void return_the_stop_at_a_specific_minute() {
        Route route = new Route(of(1));

        assertEquals(valueOf(1), route.stopAtMinute(0));
    }
}