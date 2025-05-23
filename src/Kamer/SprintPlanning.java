package Kamer;

import Opdracht.OpdrachtStrategy;

/**
 * Kamer waarin de speler leert hoe Sprint Planning werkt.
 * De speler moet de sprint correct plannen via een opdracht.
 */
public class SprintPlanning extends Kamer {
    private final String instructie;
    private final OpdrachtStrategy opdracht;

    /**
     * Constructor voor de Sprint Planning-kamer.
     * De opdracht wordt van buitenaf geïnjecteerd (DIP toegepast).
     *
     * @param opdracht De opdracht van deze kamer (strategy pattern).
     */
    public SprintPlanning(OpdrachtStrategy opdracht) {
        super("Sprint Planning");
        this.instructie = "Plan de sprint.";
        this.opdracht = opdracht; // alleen abstractie gebruiken
    }

    /**
     * Laat een instructie zien wanneer de kamer betreden wordt.
     */
    @Override
    public void betreed() {
        System.out.println("Je betreedt: " + getNaam());
        System.out.println(instructie);
    }

    /**
     * Voert de opdracht uit en retourneert of het gelukt is.
     * @return true als speler de opdracht goed uitvoert.
     */
    @Override
    public boolean start() {
        return opdracht.voerUit(); // Strategy pattern toegepast
    }
}
