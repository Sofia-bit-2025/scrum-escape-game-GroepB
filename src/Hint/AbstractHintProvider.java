package Hint;

import java.util.List;

public abstract class AbstractHintProvider implements HintProvider {

    private final HintFilter hintFilter;

    public AbstractHintProvider() {

        this.hintFilter = new HintFilter(new ContextPrefixFilter());
    }

    @Override
    public List<Hint> getHintsForContext(String context) {
        List<Hint> allHints = getAllHints();
        return hintFilter.filter(allHints, context);
    }

    protected abstract List<Hint> getAllHints();
}
