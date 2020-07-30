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

    public Integer stopAt(Integer atMinute) {
        return stops.get(atMinute % stops.size());
    }

    public Boolean hasTheSameStopOf(Route other, Integer atMinute) {
        return stopAt(atMinute).equals(other.stopAt(atMinute));
    }
}
