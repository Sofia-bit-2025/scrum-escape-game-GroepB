package Kamer;

import Opdracht.Joker;
import Opdracht.OpdrachtStrategy;
import java.util.Objects;

/**

 * Wanneer je een kamer binnenkomt, laat deze klasse eerst wat uitleg zien
 * en daarna voert hij de opdracht uit die bij die kamer hoort.
 * <br>Deze opdracht komt via het Strategy Pattern, dus elke kamer kan z’n eigen opdrachtstrategie hebben.
 */
public abstract class BasisKamer extends Kamer {

    /**
     * De tekstinstructie die wordt getoond bij het betreden van de kamer.
     */
    private final String instructie;

    /**
     * De opdracht die uitgevoerd wordt wanneer de kamer start.
     */
    private final OpdrachtStrategy opdracht;


    //De constructor maakt een kamer aan met een naam, instructietekst en opdracht.
    //controleert of de instructie niet leeg is en of de opdracht bestaat
    public BasisKamer(String naam, String instructie, OpdrachtStrategy opdracht) {
        super(naam);
        this.instructie = validateInstructie(instructie);
        this.opdracht = Objects.requireNonNull(opdracht, "Opdracht mag niet null zijn.");
    }


    //Deze methode checkt of de instructie geldig is.
    //gooit een foutmelding als de tekst null of leeg is
    private String validateInstructie(String instructie) {
        Objects.requireNonNull(instructie, "Instructie mag niet null zijn.");
        if (instructie.trim().isEmpty()) {
            throw new IllegalArgumentException("Instructie mag niet leeg zijn.");
        }
        return instructie;
    }


    //Deze methode wordt uitgevoerd als je een kamer binnenkomt
    //toont de naam van de kamer en de instructie die erbij hoort
    @Override
    public void betreed() {
        System.out.println("Je betreedt: " + getNaam());
        System.out.println(instructie);
    }


    //Deze methode start de opdracht van de kamer
    //roept gewoon de voerUit() methode aan op de opdrachtstrategie
    @Override
    public boolean start(Joker gekozenJoker) {
        return opdracht.voerUit(this, gekozenJoker);
    }
}
