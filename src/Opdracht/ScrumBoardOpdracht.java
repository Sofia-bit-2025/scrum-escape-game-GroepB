package Opdracht;

import java.util.Scanner;

public class ScrumBoardOpdracht extends InteractieveOpdracht {

    public ScrumBoardOpdracht(Scanner scanner) {
        super(scanner, "ScrumBoard");
    }

    @Override
    protected String getVraag() {
        return "Opdracht: Waar hoort de taak 'abstracte klasse controleren' op het Scrum Board?";
    }

    @Override
    protected String[] getOpties() {
        return new String[] {"To Do", "Doing", "Done"};
    }

    @Override
    protected String getJuisteAntwoord() {
        return "B";
    }

    @Override
    protected String getFeedbackCorrect() {
        return "Correct! Deze taak hoort bij 'Doing'.";
    }

    @Override
    protected String getFeedbackFout() {
        return "Fout. Het juiste antwoord was: B) Doing.";
    }
}
