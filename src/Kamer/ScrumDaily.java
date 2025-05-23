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
     * De opdracht wordt van buitenaf geïnjecteerd (DIP toegepast).
     *
     * @param opdracht De bijbehorende opdracht (via strategy pattern)
     */
    public ScrumDaily(OpdrachtStrategy opdracht) {
        super("Daily Scrum");
        this.instructie = "Iedereen geeft een korte statusupdate.";
        this.opdracht = opdracht; // geen concrete implementatie aanmaken hier
    }

    /**
     * Toont uitleg bij het betreden van de kamer.
     */
    @Override
    public void betreed() {
        System.out.println("Je betreedt: " + getNaam());
        System.out.println(instructie);
    }

    /**
     * Voert de opdracht uit en geeft terug of deze slaagt.
     * @return true als opdracht goed is uitgevoerd
     */
    @Override
    public boolean start() {
        return opdracht.voerUit(); // Strategy pattern toegepast
    }
}
