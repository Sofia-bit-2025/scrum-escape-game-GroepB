//de speler leert wat een Scrum Board is,
//oefent met het juist indelen van taken op dat bord
//voortgang maakt binnen het spel als de opdracht correct wordt uitgevoerd
package Kamer;

public class ScrumBoard implements Kamer {
    private final String naam;//Naam van de kamer wordt getoond bij binnenkomst.
    private final String instructie;//Uitleg over de opdracht

    public ScrumBoard() {
        this.naam = "Scrum Board";
        this.instructie = "Richt het bord in met taken en user stories.";
    }

    @Override
    public void betreed() {//Wordt aangeroepen als de speler de kamer binnenkomt
        System.out.println("Je betreedt: " + naam);
        System.out.println(instructie);
    }

    @Override
    public void actieUitvoeren() {//de opdracht zelf.
        System.out.println("Plaats de juiste taken op het juiste deel van het bord");
        // controle toevoegen nog
        System.out.println("Welke taak hoort bij 'Done'?");




    }

    //naam van de kamer
    @Override
    public String getNaam() {
        return naam;
    }
}
