package Kamer;

public class TiaFinaleKamer implements Kamer {
    private final String naam;
    private final String instructie;

    public TiaFinaleKamer() {
        this.naam = "Finale Kamer: TIA";
        this.instructie = "Beantwoord vragen";
    }

    @Override
    public void betreed() {
        System.out.println("Je betreedt: " + naam);
        System.out.println(instructie);
    }

    @Override
    public void actieUitvoeren() {
        System.out.println("Leg uit wat Scrum in het geheel oplevert en waarom het iteratief werkt?");
    }
}
