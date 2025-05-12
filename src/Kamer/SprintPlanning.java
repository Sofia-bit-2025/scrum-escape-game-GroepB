//De speler te introduceren aan Sprint Planning binnen Scrum;
//De kamer-instructie en bijbehorende actie/opdracht te tonen;
//Onderdeel te zijn van een polymorf ontwerp
// (via de Kamer interface) waarbij iedere kamer
// een eigen Scrumonderwerp behandelt.

package Kamer;
import Opdracht.OpdrachtStrategy;

public class SprintPlanning implements Kamer {
    private final String naam;//de naam van de kamer
    private final String instructie;
    private final OpdrachtStrategy opdracht;//uitleg over de opdracht in deze kamer.


    //Constructor die naam en instructie instelt
    public SprintPlanning(OpdrachtStrategy opdracht) {
        this.naam = "Sprint Planning";
        this.instructie = "Plan de sprint.";
        this.opdracht=opdracht;
    }

    @Override
    public void betreed() {
        System.out.println("Je betreedt: " + naam);
        System.out.println(instructie);
    }


    //de logica voor de opdracht die de speler moet uitvoeren.
    @Override
    public void actieUitvoeren() {
      opdracht.voerUit();//strategy pattern toegepast
    }


    //Retourneert de naam van de kamer
    @Override
    public String getNaam() {
        return naam;
    }
}
