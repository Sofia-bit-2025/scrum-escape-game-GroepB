//de speler leert wat een Scrum Board is,
//oefent met het juist indelen van taken op dat bord
//voortgang maakt binnen het spel als de opdracht correct wordt uitgevoerd
package Kamer;
import Opdracht.OpdrachtStrategy;

public class ScrumBoard implements Kamer {
    private final String naam;//Naam van de kamer wordt getoond bij binnenkomst.
    private final String instructie;//Uitleg over de opdracht
    private final OpdrachtStrategy opdracht;

    public ScrumBoard(OpdrachtStrategy opdracht) {
        this.naam = "Scrum Board";
        this.instructie = "Richt het bord in met taken en user stories.";
        this.opdracht = opdracht;
    }

    @Override
    public void betreed() {//Wordt aangeroepen als de speler de kamer binnenkomt
        System.out.println("Je betreedt: " + naam);
        System.out.println(instructie);
    }

    @Override
    public void actieUitvoeren() {
     opdracht.voerUit();//strategy pattern toegepast
    }

    //naam van de kamer
    @Override
    public String getNaam() {
        return naam;
    }
}
