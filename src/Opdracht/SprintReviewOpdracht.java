package Opdracht;

import java.util.Scanner;

public class SprintReviewOpdracht extends InteractieveOpdracht {

    public SprintReviewOpdracht(Scanner scanner) {
        super(scanner, "SprintReview");
    }

    @Override
    protected String getVraag() {
        return "Opdracht: Evalueer de feedback van stakeholders.\nWelke actie hoort bij een goede Sprint Review?";
    }

    @Override
    protected String[] getOpties() {
        return new String[]{
                "Nieuwe sprintdoelen plannen",
                "Feedback ontvangen en bespreken",
                "De sprint beëindigen zonder overleg"
        };
    }

    @Override
    protected String getJuisteAntwoord() {
        return "B";
    }

    @Override
    protected String getFeedbackCorrect() {
        return "Juist! Een Sprint Review draait om feedback en samenwerking.";
    }

    @Override
    protected String getFeedbackFout() {
        return "Fout. In de Review wordt vooral teruggeblikt met stakeholders.";
    }
}
