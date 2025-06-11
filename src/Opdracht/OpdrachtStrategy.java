package Opdracht;

import Kamer.Kamer;

/**
 * Strategie-interface voor opdrachten in kamers.
 */
public interface OpdrachtStrategy {

    /**
     * Voert de opdracht uit, toont vragen of opdrachten aan de speler,
     */
    boolean voerUit(Kamer kamer, Joker gekozenJoker);
}
