package Hint;

/**
 * Een strategie-interface voor het filteren van hints op basis van contextuele criteria.
 * <p>
 * Elke implementatie bepaalt haar eigen logica om te bepalen of een hint relevant is
 * in een bepaalde situatie. Dit maakt het systeem uitbreidbaar en losgekoppeld (DIP).
 * </p>
 * <p>
 * Voorbeelden van implementaties:
 * <ul>
 *     <li>{@code ContextPrefixFilter}: accepteert hints waarvan de tekst begint met de kamernaam.</li>
 *     <li>{@code TypeFilter}: accepteert hints van een specifiek type, zoals "help" of "grappig".</li>
 *     <li>{@code AndHintFilter}: combineert meerdere filters (bijv. context én type).</li>
 * </ul>
 */
public interface HintFilterStrategy {

    /**
     * Bepaalt of een gegeven hinttekst relevant is voor de opgegeven context.
     *
     * @param hintTekst De volledige tekst van de hint (bijv. "ScrumBoard: Gebruik de kolommen goed.")
     * @param context   De huidige spelsituatie of kamer (bijv. "ScrumBoard")
     * @return {@code true} als deze hint geaccepteerd wordt voor de gegeven context, anders {@code false}
     */
    boolean accepteert(String hintTekst, String context);
}
