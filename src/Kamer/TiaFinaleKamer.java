package Kamer;

public class TiaFinaleKamer implements Kamer {
    private final String naam;
    private final String instructie;



    //Constructor die naam en instructie initialiseert
    public TiaFinaleKamer() {
        this.naam = "Finale Kamer: TIA";
        this.instructie = "Beantwoord vragen";
    }


    //Laat een welkombericht en instructie zien
    @Override
    public void betreed() {
        System.out.println("Je betreedt: " + naam);
        System.out.println(instructie);
    }


    //Toont de afsluitende vraag
    @Override
    public void actieUitvoeren() {
        System.out.println("Leg uit wat Scrum in het geheel oplevert en waarom het iteratief werkt?");
    }

    @Override
    public String getNaam() {
        return naam;
    }
}
