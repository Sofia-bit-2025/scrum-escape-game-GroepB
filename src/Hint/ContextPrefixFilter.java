package Hint;

/**
 * Deze filterstrategie bepaalt of een hinttekst hoort bij een specifieke kamercontext.
 */
public class ContextPrefixFilter implements HintFilterStrategy {

    /**
     * Controleert of de hinttekst begint met de opgegeven context als prefix.
     *
     * @param hintTekst De tekst van de hint
     * @param context   De naam van de kamer of situatie
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
