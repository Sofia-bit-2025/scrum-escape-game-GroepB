package Hint;

/**
 * Deze filter checkt of een hint past bij de juiste kamer.
 * Hij kijkt gewoon of de hint begint met de naam van de kamer.
 * Bijvoorbeeld: als je in "ScrumBoard" zit, dan pakt hij alleen hints die beginnen met "ScrumBoard:".
 * Superhandig om hints te koppelen aan de juiste context, zonder gedoe.
 */
public class ContextPrefixFilter implements HintFilterStrategy {

    //filtert alleen de hints die bedoeld zijn voor de kamer waarin je zit.
    @Override
    public boolean accepteert(String hintTekst, String context) {
        return hintTekst != null && context != null && hintTekst.startsWith(context + ":");
    }
}
