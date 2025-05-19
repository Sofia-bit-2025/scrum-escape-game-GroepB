//De speler te introduceren aan Sprint Planning binnen Scrum;
//De kamer-instructie en bijbehorende actie/opdracht te tonen;
//Onderdeel te zijn van een polymorf ontwerp
// (via de Kamer interface) waarbij iedere kamer
// een eigen Scrumonderwerp behandelt.

package Kamer;

public class SprintPlanning implements Kamer {
    private final String naam;//de naam van de kamer
    private final String instructie;//uitleg over de opdracht in deze kamer.


    //Constructor die naam en instructie instelt
    public SprintPlanning() {
        this.naam = "Sprint Planning";
        this.instructie = "Plan de sprint.";
    }

    @Override
    public void betreed() {
        System.out.println("Je betreedt: " + naam);
        System.out.println(instructie);
    }


    //de logica voor de opdracht die de speler moet uitvoeren.
    @Override
    public void actieUitvoeren() {
        System.out.println("Beantwoord de vraag over inschatting van taken");
        // logica nog toevoegen


    }


    //Retourneert de naam van de kamer
    @Override
    public String getNaam() {
        return naam;
    }
}
