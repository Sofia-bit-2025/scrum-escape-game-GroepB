package Kamer;



public class ScrumDaily implements Kamer {
    private final String naam;
    private final String instructie;

    public ScrumDaily() {
        this.naam = "Daily Scrum";
        this.instructie = "Iedereen geeft een korte statusupdate.";
    }

    @Override
    public void betreed() {
        System.out.println("Je betreedt: " + naam);
        System.out.println(instructie);
    }

    @Override
    public void actieUitvoeren() {
        System.out.println("Geef aan wat iedereen heeft gedaan");
    }
}