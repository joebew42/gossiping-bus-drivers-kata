import java.util.List;

import static java.util.Collections.emptyList;

public class Route {
    public Route(List<Integer> stops) {

    }

    public Route() {
        this(emptyList());
    }

    public Integer stopAtMinute(Integer minute) {
        return 1;
    }
}
