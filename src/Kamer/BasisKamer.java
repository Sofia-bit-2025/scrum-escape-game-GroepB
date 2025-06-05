package Kamer;

import Assistent.Assistent;
import Opdracht.OpdrachtStrategy;

import java.util.Objects;

/**
 * BasisKamer is een herbruikbare abstracte klasse voor kamers met instructie, opdracht en optionele assistent.
 * <br>Past SOLID-principes toe: SRP, DIP en OCP.
 */
public abstract class BasisKamer extends Kamer {

    private final String instructie;
    private final OpdrachtStrategy opdracht;
    private final Assistent assistent; // final: bij creatie vastgezet (geen setter nodig)

    /**
     * Constructor zonder assistent (fallback-variant)
     */
    public BasisKamer(String naam, String instructie, OpdrachtStrategy opdracht) {
        this(naam, instructie, opdracht, null); // constructor chaining
    }

    /**
     * Constructor met assistent (aanbevolen)
     */
    public BasisKamer(String naam, String instructie, OpdrachtStrategy opdracht, Assistent assistent) {
        super(naam);
        this.instructie = validateInstructie(instructie);
        this.opdracht = Objects.requireNonNull(opdracht, "Opdracht mag niet null zijn.");
        this.assistent = assistent; // mag null zijn → optioneel
    }

    private String validateInstructie(String instructie) {
        Objects.requireNonNull(instructie, "Instructie mag niet null zijn.");
        if (instructie.trim().isEmpty()) {
            throw new IllegalArgumentException("Instructie mag niet leeg zijn.");
        }
        return instructie;
    }

    /**
     * Activeer optionele assistent (hint, uitleg, motivatie)
     */
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
    public boolean start() {
        return opdracht.voerUit();
    }
}
