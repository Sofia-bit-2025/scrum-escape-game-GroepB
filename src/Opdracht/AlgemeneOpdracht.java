package Opdracht;

import Hint.Hint;
import Hint.HintFactory;

import java.util.Scanner;

public class AlgemeneOpdracht extends InteractieveOpdracht {

    private final String vraag;
    private final String[] opties;
    private final String juisteAntwoord;
    private final String feedbackCorrect;
    private final String feedbackFout;

    public AlgemeneOpdracht(
            Scanner scanner,
            String context,
            String vraag,
            String[] opties,
            String juisteAntwoord,
            String feedbackCorrect,
            String feedbackFout) {

        super(scanner, context);
        if (vraag == null || vraag.isBlank()) throw new IllegalArgumentException("Vraag mag niet leeg zijn.");
        if (opties == null || opties.length == 0) throw new IllegalArgumentException("Opties mogen niet leeg zijn.");
        if (juisteAntwoord == null || juisteAntwoord.isBlank()) throw new IllegalArgumentException("Juiste antwoord mag niet leeg zijn.");
        if (feedbackCorrect == null) throw new IllegalArgumentException("Feedback correct mag niet null zijn.");
        if (feedbackFout == null) throw new IllegalArgumentException("Feedback fout mag niet null zijn.");

        this.vraag = vraag;
        this.opties = opties;
        this.juisteAntwoord = juisteAntwoord.toUpperCase().trim();
        this.feedbackCorrect = feedbackCorrect;
        this.feedbackFout = feedbackFout;
    }

    @Override
    protected String getVraag() {
        return vraag;
    }

    @Override
    protected String[] getOpties() {
        return opties;
    }

    @Override
    protected String getJuisteAntwoord() {
        return juisteAntwoord;
    }

    @Override
    protected String getFeedbackCorrect() {
        return feedbackCorrect;
    }

    @Override
    protected String getFeedbackFout() {
        return feedbackFout;
    }
}
