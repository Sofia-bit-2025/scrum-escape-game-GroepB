package Kamer;

/**
 * Abstracte basis voor elke kamer in het spel.
 * Dwingt structuur af voor naam, instructie en opdrachtuitvoering.
 * Past bij SOLID (OCP & DIP) en maakt polymorfie mogelijk.
 */
public abstract class Kamer {
    protected final String naam;

    /**
     * Constructor voor een kamer.
     * @param //afdwingen dat elke kamer een naam heeft.
     * verplicht maken via de constructor
     */
    public Kamer(String naam) {
        this.naam = naam;
    }

    /**
     * Wordt aangeroepen wanneer de speler de kamer betreedt.
     * Laat de introductie/instructie van de kamer zien.
     */
    public abstract void betreed();

    /**
     * Voert de opdracht of uitdaging van deze kamer uit.
     * @return true als de speler de kamer/opdracht succesvol voltooit, false anders.
     */
    public abstract boolean start();

    /**
     * Geeft de naam van de kamer terug.
     * @return naam van de kamer
     */
    public String getNaam() {
        return naam;
    }
}
