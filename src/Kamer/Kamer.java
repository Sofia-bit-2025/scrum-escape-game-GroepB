package Kamer;

/**
 * Kamer is de basis voor elke ruimte in het spel die je kunt betreden.
 * Elke kamer heeft een naam, toont iets als je binnenkomt (via {@code betreed()})
 * en voert een opdracht uit (via {@code start()}).
 * <br>Subklassen zoals {@code ScrumBoard} of {@code SprintPlanning} geven hun eigen gedrag hieraan mee.
 * <br>Deze abstracte klasse zorgt dus voor structuur, zodat elke kamer netjes dezelfde basisregels volgt.
 * <br>Goed voor uitbreidbaarheid en overzicht: je kunt altijd een nieuwe kamer maken door deze klasse te erven.
 */
public abstract class Kamer {

    // Naam van de kamer bijvoorbeeld SprintReview
    private final String naam;



    //Deze constructor maakt een kamer aan met een naam.
    // Als de naam leeg of null is, gooit hij een foutmelding.
    public Kamer(String naam) {
        if (naam == null || naam.trim().isEmpty()) {
            throw new IllegalArgumentException("Naam van kamer mag niet leeg of null zijn.");
        }
        this.naam = naam;
    }



    //Deze abstracte methode zegt
    // Elke kamer moet zelf bepalen wat er gebeurt als je die binnenkomt.
    public abstract void betreed();


    //Deze methode dwingt af dat elke kamer zelf bepaalt
    // wat er gebeurt als een speler begint met de opdracht
    public abstract boolean start();



    //Geeft  de naam van de kamer terug
    public final String getNaam() {
        return naam;
    }

    //een leesbare tekstversie van het kamerobject terug
    @Override
    public String toString() {
        return "Kamer: " + naam;
    }
}
