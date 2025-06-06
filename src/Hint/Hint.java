package Hint;


public class Hint {
    private final String tekst;
    private final String type;


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


    public String getTekst() {
        return tekst;
    }


    public String getType() {
        return type;
    }


    @Override
    public String toString() {
        return "[" + type + "] " + tekst;
    }
}
