package Hint;

/**
 * Een hint die tijdens het spel wordt getoond.
 */
public class Hint {
    private final String tekst;
    private final String type;

    /**
     * Maakt een nieuwe Hint aan.
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
     * @return Het type van de hint
     */
    public String getType() {
        return type;
    }


    @Override
    public String toString() {
        return "[" + type + "] " + tekst;
    }
}
