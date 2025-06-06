package Opdracht;

import java.util.Scanner;

public class TiaFinaleOpdracht extends InteractieveOpdracht {

    public TiaFinaleOpdracht(Scanner scanner) {
        super(scanner, "Finale");
    }

    @Override
    protected String getVraag() {
        return "Finale opdracht: Waarom werkt Scrum iteratief?";
    }

    @Override
    protected String[] getOpties() {
        return new String[]{
                "Zodat alles tegelijk opgeleverd wordt",
                "Om geleidelijk feedback te verwerken en continu te verbeteren",
                "Omdat teams niet kunnen plannen"
        };
    }

    @Override
    protected String getJuisteAntwoord() {
        return "B";
    }

    @Override
    protected String getFeedbackCorrect() {
        return "Juist! Scrum gebruikt iteraties om continu te verbeteren.";
    }

    @Override
    protected String getFeedbackFout() {
        return "Fout. Scrum gebruikt iteraties om steeds kleine stappen te verbeteren.";
    }
}
