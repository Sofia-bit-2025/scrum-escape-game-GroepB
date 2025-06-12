package Kamer;

import Assistent.Assistent;
import Opdracht.OpdrachtStrategy;
import Opdracht.Joker;

import java.util.Objects;


public abstract class BasisKamer extends Kamer {

    private final String instructie;
    private final OpdrachtStrategy opdracht;
    private final Assistent assistent;


    public BasisKamer(String naam, String instructie, OpdrachtStrategy opdracht) {
        this(naam, instructie, opdracht, null);
    }


    public BasisKamer(String naam, String instructie, OpdrachtStrategy opdracht, Assistent assistent) {
        super(naam);
        this.instructie = validateInstructie(instructie);
        this.opdracht = Objects.requireNonNull(opdracht, "Opdracht mag niet null zijn.");
        this.assistent = assistent;
    }

    private String validateInstructie(String instructie) {
        Objects.requireNonNull(instructie, "Instructie mag niet null zijn.");
        if (instructie.trim().isEmpty()) {
            throw new IllegalArgumentException("Instructie mag niet leeg zijn.");
        }
        return instructie;
    }


    public void gebruikAssistent() {
        if (assistent != null) {
            assistent.help();
        } else {
            System.out.println("Geen assistent beschikbaar in deze kamer.");
        }
    }

    @Override
    public void betreed() {
        System.out.println("Je betreedt: " + getNaam());
        System.out.println(instructie);
    }

    @Override
    public boolean start(Joker gekozenJoker) {
        return opdracht.voerUit(this, gekozenJoker);
    }
}
