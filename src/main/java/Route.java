import java.util.List;

import static java.util.Collections.emptyList;

public class Route {
    private List<Integer> stops;

    public Route(List<Integer> stops) {
        this.stops = stops;
    }

    public Route() {
        this(emptyList());
    }

    public Integer stopAtMinute(Integer minute) {
        return stops.get(minute);
    }
}
