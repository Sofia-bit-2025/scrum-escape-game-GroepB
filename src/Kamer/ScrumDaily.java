//toont instructies aan de speler en roept een actie
// op die aansluit bij dat Scrumevent.

//Door OOP en SOLID toe te passen is deze klasse:
//gescheiden van andere logica (SRP),
//vervangbaar of uitbreidbaar
package Kamer;



public class ScrumDaily implements Kamer {//implementeert de interface Kamer
    private final String naam;
    private final String instructie;

    //Constructor
    public ScrumDaily() {
        this.naam = "Daily Scrum";
        this.instructie = "Iedereen geeft een korte statusupdate.";
    }

    @Override
    public void betreed() {//oont de naam van de kamer en de uitleg,
        System.out.println("Je betreedt: " + naam);
        System.out.println(instructie);
        //Hier nog vraag toevoegen met input validatie of een monster bij een fout antwoord.
    }



    @Override
    public void actieUitvoeren() {
        System.out.println("Geef aan wat iedereen heeft gedaan");
    }
    @Override
    public String getNaam() {
        return naam;
    }
}