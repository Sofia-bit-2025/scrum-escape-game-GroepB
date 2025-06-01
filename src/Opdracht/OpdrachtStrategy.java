package Opdracht;

/**
 * Strategie-interface voor opdrachten in kamers.
 * <p>
 * Deze interface maakt het mogelijk om verschillende soorten opdrachten los te koppelen van kamers.
 * Elke kamer kan zijn eigen {@code OpdrachtStrategy} gebruiken, zoals een quiz, puzzel of interactieve actie.
 * </p>
 *
 * <p>Wordt gebruikt in het Strategy Pattern: de kamer is afhankelijk van de interface, niet van concrete opdrachten.</p>
 */
public interface OpdrachtStrategy {

    /**
     * Voert de opdracht uit, toont vragen of opdrachten aan de speler,
     * en verwerkt de input.
     *
     * @return {@code true} als de opdracht succesvol is uitgevoerd (bijv. correct beantwoord)
     */
    boolean voerUit();
}
