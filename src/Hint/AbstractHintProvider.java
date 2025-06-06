package Hint;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractHintProvider implements HintProvider {

    @Override
    public List<Hint> getHintsForContext(String context) {
        List<Hint> result = new ArrayList<>();
        List<Hint> allHints = getAllHints();

        for (Hint hint : allHints) {
            if (hint.getTekst().startsWith(context + ":")) {
                result.add(hint);
            }
        }

        return result;
    }

    protected abstract List<Hint> getAllHints();
}
