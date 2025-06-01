package Hint;

/**
 * Deze interface bepaalt hoe we hints filteren op basis van context.
 * Bijvoorbeeld: als je in de "ScrumBoard"-kamer zit,
 * wil je alleen hints die met "ScrumBoard:" beginnen.
 * <br>Elke klasse die deze interface implementeert, bepaalt zijn eigen logica om te checken
 * of een hint bij de huidige situatie past.
 */
public interface HintFilterStrategy {
    boolean accepteert(String hintTekst, String context);
}
