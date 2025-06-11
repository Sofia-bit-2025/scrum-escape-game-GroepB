package Opdracht;

import Hint.Hint;
import Hint.HintFactory;
import Kamer.Kamer;

import java.util.Scanner;

/**
 * Een abstracte opdracht waarbij de speler een meerkeuzevraag moet beantwoorden.
 */
public abstract class InteractieveOpdracht implements OpdrachtStrategy {

    protected final Scanner scanner;
    private final String context;

    /**
     * Constructor voor een interactieve opdracht.
     */
    public InteractieveOpdracht(Scanner scanner, String context) {
        if (scanner == null) throw new IllegalArgumentException("Scanner mag niet null zijn.");
        if (context == null || context.isBlank()) throw new IllegalArgumentException("Context mag niet leeg zijn.");
        this.scanner = scanner;
        this.context = context;
    }

    protected abstract String getVraag();

    protected abstract String[] getOpties();

    protected abstract String getJuisteAntwoord(); // bijv. "A", "B", ...

    protected abstract String getFeedbackCorrect();

    protected abstract String getFeedbackFout();

    @Override
    public boolean voerUit(Kamer kamer, Joker gekozenJoker) {
        toonVraagEnOpties();
        String antwoord = vraagGebruikerOmAntwoord();

        if (!isGeldigeKeuze(antwoord)) {
            System.out.println("Ongeldige keuze. Kies bijvoorbeeld A, B of C.");
            return false;
        }

        if (antwoord.equals(getJuisteAntwoord())) {
            System.out.println(getFeedbackCorrect());
            return true;
        }

        System.out.println(getFeedbackFout());
        vraagOfHintGewenst();
        return false;
    }

    private void toonVraagEnOpties() {
        System.out.println(getVraag());
        String[] opties = getOpties();
        char letter = 'A';
        for (String optie : opties) {
            System.out.println(letter++ + ") " + optie);
        }
    }

    private String vraagGebruikerOmAntwoord() {
        System.out.print("> Kies een optie (A, B, C...): ");
        return scanner.nextLine().trim().toUpperCase();
    }

    private boolean isGeldigeKeuze(String antwoord) {
        return antwoord.matches("[A-Z]") && antwoord.length() == 1;
    }

    private void vraagOfHintGewenst() {
        System.out.print("Wil je een hint? (ja/nee): ");
        String keuze = scanner.nextLine().trim().toLowerCase();
        if (keuze.equals("ja")) {
            Hint hint = HintFactory.geefRandomHint(context);
            System.out.println("Hint (" + hint.getType() + "): " + hint.getTekst());
        }
    }
}
