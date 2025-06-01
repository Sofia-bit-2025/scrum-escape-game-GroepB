package Hint;

/**
 * Een hint die tijdens het spel wordt getoond.
 * Een hint bestaat uit:
 * <ul>
 *     <li><b>tekst</b>: de inhoud van de hint, vaak contextueel zoals "ScrumBoard: gebruik je kolommen."</li>
 *     <li><b>type</b>: het soort hint, zoals "help", "grappig", "info", ...</li>
 * </ul>
 *
 * Beide velden zijn immutable en worden gevalideerd in de constructor.
 */
public class Hint {
    private final String tekst;
    private final String type;

    /**
     * Maakt een nieuwe Hint aan.
     *
     * @param tekst De hinttekst (mag niet null of leeg zijn)
     * @param type  Het type hint, zoals "grappig" of "help" (mag niet null of leeg zijn)
     * @throws IllegalArgumentException als tekst of type ongeldig is
     */
    public Hint(String tekst, String type) {
        if (tekst == null || tekst.isBlank()) {
            throw new IllegalArgumentException("Hinttekst mag niet leeg zijn.");
        }
        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("Hinttype mag niet leeg zijn.");
        }

        this.tekst = tekst;
        this.type = type;
    }

    /**
     * @return De tekstuele inhoud van de hint
     */
    public String getTekst() {
        return tekst;
    }

    /**
     * @return Het type van de hint (bijv. "grappig", "help")
     */
    public String getType() {
        return type;
    }

    /**
     * @return Een nette stringrepresentatie zoals "[help] ScrumBoard: gebruik je kolommen."
     */
    @Override
    public String toString() {
        return "[" + type + "] " + tekst;
    }
}
