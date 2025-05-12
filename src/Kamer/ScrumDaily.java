//toont instructies aan de speler en roept een actie
// op die aansluit bij dat Scrumevent.

//Door OOP en SOLID toe te passen is deze klasse:
//gescheiden van andere logica (SRP),
//vervangbaar of uitbreidbaar
package Kamer;
import Opdracht.OpdrachtStrategy;



public class ScrumDaily implements Kamer {//implementeert de interface Kamer
    private final String naam;
    private final String instructie;
    private final OpdrachtStrategy opdracht;

    //Constructor
    public ScrumDaily(OpdrachtStrategy opdracht) {
        this.naam = "Daily Scrum";
        this.instructie = "Iedereen geeft een korte statusupdate.";
        this.opdracht=opdracht;
    }

    @Override
    public void betreed() {//oont de naam van de kamer en de uitleg,
        System.out.println("Je betreedt: " + naam);
        System.out.println(instructie);
        //Hier nog vraag toevoegen met input validatie of een monster bij een fout antwoord.
    }



    @Override
    public void actieUitvoeren(){
        opdracht.voerUit();//strategy pattern toegepast
    }



    @Override
    public String getNaam() {
        return naam;
    }
}