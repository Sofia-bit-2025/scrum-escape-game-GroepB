package Kamer;

public class SprintReview implements Kamer {
    private final String naam;
    private final String instructie;

    public SprintReview() {
        this.naam = "Sprint Review";
        this.instructie = "Beoordeel het resultaat.";
    }

    @Override
    public void betreed() {
        System.out.println("Je betreedt: " + naam);
        System.out.println(instructie);
    }

    @Override
    public void actieUitvoeren() {
        System.out.println("Evalueer de feedback van stakeholders");
    }
}
