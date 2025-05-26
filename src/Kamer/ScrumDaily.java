package Kamer;

import Opdracht.OpdrachtStrategy;

/**
 * Kamer waarin de speler ervaart hoe de Daily Scrum werkt.
 * De speler moet de juiste statusupdate geven als opdracht.
 */
public class ScrumDaily extends Kamer {
    private final String instructie;
    private final OpdrachtStrategy opdracht;

    /**
     * Constructor voor de Daily Scrum kamer.
     *
     * @param opdracht De bijbehorende opdracht (via strategy pattern)
     */
    public ScrumDaily(OpdrachtStrategy opdracht) {
        super("Daily Scrum");
        this.instructie = "Iedereen geeft een korte statusupdate.";
        this.opdracht = opdracht;
    }

    /**
     * Toont uitleg bij het betreden van de kamer.
     */
    @Override
    public void betreed() {
        System.out.println("Je betreedt: " + getNaam());
        System.out.println(instructie);
        // Hier kun je later uitbreiden met validatie of een monster bij fout antwoord.
    }

    /**
     * Voert de opdracht uit en geeft terug of deze slaagt.
     *
     * @return true als opdracht goed is uitgevoerd
     */
    @Override
    public boolean start() {
        return opdracht.voerUit(); // Strategy pattern toegepast
    }
}
