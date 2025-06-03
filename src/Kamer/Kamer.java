package Kamer;

/**
 * Abstracte basis voor elke kamer in het spel.
 * dwingt structuur af voor naam, instructie en opdrachtuitvoering.
 * Past bij SOLID OCP & DIP en maakt polymorfie mogelijk.
 */
public abstract class Kamer {
    protected final String naam;

    /**
     * Constructor voor een kamer.
     * @param //afdwingen  elke kamer heeft een naam.
     * verplicht maken via de constructor
     */
    public Kamer(String naam) {
        this.naam = naam;
    }

    /**
     * Wordt aangeroepen wanneer de speler de kamer binnenloopt.
     * Laat de introductie  van de kamer zien.
     */
    public abstract void betreed();

    /**
     * Voert de opdracht van deze kamer uit.
     * @return true als de speler opdracht succesvol voltooit en false anders.
     */
    public abstract boolean start();

    /**

     * @return naam van de kamer
     */
    public String getNaam() {
        return naam;
    }
}
