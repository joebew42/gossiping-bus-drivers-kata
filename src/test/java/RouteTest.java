import org.junit.Test;

import static java.lang.Integer.valueOf;
import static org.junit.Assert.assertEquals;

public class RouteTest {

    public static final int MINUTE_ZERO = 0;
    public static final int MINUTE_ONE = 1;
    public static final int MINUTE_TWO = 2;
    public static final int MINUTE_THREE = 3;
    public static final int MINUTE_FOUR = 4;
    public static final int MINUTE_FIVE = 5;

    @Test
    public void return_the_stop_at_a_specific_minute() {
        Route route = new Route(2, 4, 8);

        assertEquals(valueOf(2), route.stopAt(MINUTE_ZERO));
        assertEquals(valueOf(4), route.stopAt(MINUTE_ONE));
        assertEquals(valueOf(8), route.stopAt(MINUTE_TWO));
    }

    @Test
    public void stops_are_repeated_over_and_over() {
        Route route = new Route(2, 4, 8);

        assertEquals(valueOf(2), route.stopAt(MINUTE_THREE));
        assertEquals(valueOf(4), route.stopAt(MINUTE_FOUR));
        assertEquals(valueOf(8), route.stopAt(MINUTE_FIVE));
    }
}