package Hint;

import java.util.List;

/**
 * Interface voor een provider van hints binnen het spel.
 * <p>
 * Elke implementatie levert een verzameling {@link Hint} objecten die relevant zijn
 * voor een gegeven context, zoals een specifieke kamer ("ScrumBoard") of fase ("SprintPlanning").
 * </p>
 * <p>
 * De logica voor het filteren van hints (bijvoorbeeld op context of type)
 * kan worden toegepast binnen de provider zelf of extern via {@link HintFilterStrategy}.
 * </p>
 */
public interface HintProvider {

    /**
     * Geeft een lijst van hints die relevant zijn voor de opgegeven context.
     *
     * @param context De naam van de kamer of situatie waarin de speler zich bevindt (bijv. "DailyScrum")
     * @return Een lijst met relevante {@link Hint} objecten (mag leeg zijn, maar niet null)
     */
    List<Hint> getHintsForContext(String context);
}
