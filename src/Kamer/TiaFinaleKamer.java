package Kamer;

import Opdracht.OpdrachtStrategy;

public class TiaFinaleKamer implements Kamer {
    private final String naam;
    private final String instructie;
    private final OpdrachtStrategy opdracht;



    //Constructor die naam en instructie initialiseert
    public TiaFinaleKamer(OpdrachtStrategy opdracht) {
        this.naam = "Finale Kamer: TIA";
        this.instructie = "Beantwoord vragen";
        this.opdracht=opdracht;
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
     opdracht.voerUit();//strategy toegepast
    }


    @Override
    public String getNaam() {
        return naam;
    }
}


