package Kamer;

import Opdracht.OpdrachtStrategy;

/**
 * Kamer waarin de speler leert hoe een Scrum Board werkt.
 * De speler moet de opdracht correct uitvoeren om verder te mogen.
 */
public class ScrumBoard extends Kamer {
    private final String instructie;
    private final OpdrachtStrategy opdracht;

    /**
     * Constructor voor de ScrumBoard-kamer.
     * @param opdracht De opdrachtstrategie die bij deze kamer hoort (via Strategy Pattern en DIP).
     */
    public ScrumBoard(OpdrachtStrategy opdracht) {
        super("Scrum Board");
        this.instructie = "Richt het bord in met taken en user stories.";
        this.opdracht = opdracht; // Geen concrete opdracht maken hier
    }

    /**
     * Laat de speler weten dat hij in de ScrumBoard-kamer is.
     */
    @Override
    public void betreed() {
        System.out.println("Je betreedt: " + getNaam());
        System.out.println(instructie);
    }

    /**
     * Voert de opdracht uit en geeft aan of de speler is geslaagd.
     * @return true als opdracht succesvol werd uitgevoerd
     */
    @Override
    public boolean start() {
        return opdracht.voerUit(); // Strategy Pattern toegepast
    }
}
