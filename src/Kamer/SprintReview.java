package Kamer;

import Opdracht.OpdrachtStrategy;

/**
 * Kamer waarin de speler leert hoe een Sprint Review werkt.
 * De speler beoordeelt opgeleverd werk en verwerkt feedback.
 */
public class SprintReview extends Kamer {
    private final String instructie;
    private final OpdrachtStrategy opdracht;

    /**
     * Constructor voor de Sprint Review kamer.
     * De opdracht wordt van buitenaf geïnjecteerd (via abstractie).
     *
     * @param opdracht De opdrachtstrategie die uitgevoerd moet worden.
     */
    public SprintReview(OpdrachtStrategy opdracht) {
        super("Sprint Review");
        this.instructie = "Beoordeel het resultaat.";
        this.opdracht = opdracht; // abstractie → DIP toegepast
    }

    /**
     * Wordt aangeroepen bij het betreden van de kamer.
     * Toont de instructie aan de speler.
     */
    @Override
    public void betreed() {
        System.out.println("Je betreedt: " + getNaam());
        System.out.println(instructie);
    }

    /**
     * Voert de opdracht uit via Strategy pattern.
     * @return true als de opdracht succesvol werd uitgevoerd
     */
    @Override
    public boolean start() {
        return opdracht.voerUit();
    }
}
