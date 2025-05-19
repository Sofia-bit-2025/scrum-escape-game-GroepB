package Kamer;

import Opdracht.OpdrachtStrategy;

/**
 * De finale kamer waarin de speler een afsluitende reeks vragen beantwoordt.
 * Deze kamer bepaalt of de speler het spel succesvol afrondt.
 */
public class TiaFinaleKamer extends Kamer {
    private final String instructie;
    private final OpdrachtStrategy opdracht;

    /**
     * Constructor voor de finale kamer van het spel.
     * @param opdracht De afsluitende opdracht (strategy pattern).
     */
    public TiaFinaleKamer(OpdrachtStrategy opdracht) {
        super("Finale Kamer: TIA");
        this.instructie = "Beantwoord vragen.";
        this.opdracht = opdracht;
    }

    /**
     * Toont de naam en instructie bij het betreden van de kamer.
     */
    @Override
    public void betreed() {
        System.out.println("Je betreedt: " + getNaam());
        System.out.println(instructie);
    }

    /**
     * Voert de opdracht uit en retourneert of deze succesvol is.
     * @return true als speler correct antwoordt, anders false
     */
    @Override
    public boolean start() {
        return opdracht.voerUit();
    }
}
