package Kamer;

import Opdracht.OpdrachtStrategy;

/**

 * De speler moet de juiste statusupdate geven als opdracht.
 */
public class ScrumDaily extends Kamer {
    private final String instructie;
    private final OpdrachtStrategy opdracht;

    /**
     * Constructor voor de DailyScrum kamer.
     * De opdracht wordt van buitenaf geïnjecteerd (DIP toegepast)
     */
    public ScrumDaily(OpdrachtStrategy opdracht) {
        super("Daily Scrum");
        this.instructie = "Iedereen geeft een korte statusupdate.";
        this.opdracht = opdracht; // geen concrete implementatie aanmaken hier
    }

    /**
     * Toont uitleg bij het enter van de kamer.
     */
    @Override
    public void betreed() {
        System.out.println("Je betreedt: " + getNaam());
        System.out.println(instructie);
    }

    /**

     * @return true als opdracht goed is uitgevoerd
     */
    @Override
    public boolean start() {
        return opdracht.voerUit(); // Strategy pattern toegepast
    }
}
