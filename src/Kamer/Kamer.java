package Kamer;

/**
 * Abstracte basis voor elke kamer in het spel.
 * dwingt structuur af voor naam, instructie en opdrachtuitvoering.
 * Past bij SOLID OCP & DIP en maakt polymorfie mogelijk.
 */
public abstract class Kamer {
    protected final String naam;


    public Kamer(String naam) {
        this.naam = naam;
    }


    public abstract void betreed();


    public abstract boolean start();

    /**
     * @return naam van de kamer
     */
    public String getNaam() {
        return naam;
    }
}
