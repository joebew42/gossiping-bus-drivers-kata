import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;

public class Route {
    private List<Integer> stops;

    public Route() {
        this(emptyList());
    }

    public Route(Integer ... stops) {
        this.stops = asList(stops);
    }

    private Route(List<Integer> stops) {
        this.stops = stops;
    }

    public Integer stopAtMinute(Integer minute) {
        return stops.get(minute % stops.size());
    }
}
