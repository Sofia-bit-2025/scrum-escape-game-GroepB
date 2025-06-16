package Hint;

import java.util.List;
import java.util.stream.Collectors;

public class HintFilter {

    private final HintFilterStrategy filterStrategy;

    public HintFilter(HintFilterStrategy filterStrategy) {
        this.filterStrategy = filterStrategy;
    }

    public List<Hint> filter(List<Hint> allHints, String context) {
        return allHints.stream()
                .filter(h -> filterStrategy.accepteert(h.getTekst(), context))
                .collect(Collectors.toList());
    }
}
