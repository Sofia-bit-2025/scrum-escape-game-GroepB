package Kamer;

import Opdracht.Joker;
import Opdracht.OpdrachtStrategy;

/**

 * De speler beoordeelt opgeleverd werk en verwerkt feedback.
 */
public class SprintReview extends Kamer {
    private final String instructie;
    private final OpdrachtStrategy opdracht;

    /**
     * Constructor voor de SprintReview kamer.
     * De opdracht wordt van buitenaf geïnjecteerd (via abstractie).
     *
     * @param opdracht De opdrachtstrategie die uitgevoerd moet worden.
     */
    public SprintReview(OpdrachtStrategy opdracht) {
        super("Sprint Review");
        this.instructie = "Beoordeel het resultaat.";
        this.opdracht = opdracht; // abstractie -> DIP toegepast
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
    public boolean start(Joker gekozenJoker) {
        return opdracht.voerUit(this, gekozenJoker);  // Strategy Pattern toegepast hier
    }
}
