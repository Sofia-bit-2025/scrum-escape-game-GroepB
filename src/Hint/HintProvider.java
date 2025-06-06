package Hint;

import java.util.List;

/**
 * Interface voor een provider van hints binnen het spel.
 */
public interface HintProvider {

    List<Hint> getHintsForContext(String context);
}










