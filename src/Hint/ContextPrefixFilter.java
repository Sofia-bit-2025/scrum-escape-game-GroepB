package Hint;

/**
 * Deze filterstrategie bepaalt of een hinttekst hoort bij een specifieke kamercontext.
 * Een hint wordt geaccepteerd als deze begint met de contextnaam gevolgd door een dubbele punt,
 * bijvoorbeeld: "ScrumBoard: Let op je WIP-limiet".
 *
 * Dit is handig om hints automatisch te koppelen aan de juiste kamer zonder extra metadata.
 */
public class ContextPrefixFilter implements HintFilterStrategy {

    /**
     * Controleert of de hinttekst begint met de opgegeven context als prefix.
     *
     * @param hintTekst De tekst van de hint (bijv. "ScrumBoard: Let op je taken")
     * @param context   De naam van de kamer of situatie (bijv. "ScrumBoard")
     * @return true als de hint bij deze context hoort
     */
    @Override
    public boolean accepteert(String hintTekst, String context) {
        if (hintTekst == null || context == null) {
            return false;
        }
        String prefix = context + ":";
        return hintTekst.startsWith(prefix);
    }
}
