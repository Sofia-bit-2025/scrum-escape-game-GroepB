package Kamer;


public class ScrumBoard implements Kamer {
    private final String naam;
    private final String instructie;

    public ScrumBoard() {
        this.naam = "Scrum Board";
        this.instructie = "Richt het bord in met taken en user stories.";
    }

    @Override
    public void betreed() {
        System.out.println("Je betreedt: " + naam);
        System.out.println(instructie);
    }

    @Override
    public void actieUitvoeren() {
        System.out.println("Plaats de juiste taken op het juiste deel van het bord");
    }
}