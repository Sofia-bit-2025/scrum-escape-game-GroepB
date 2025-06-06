package Opdracht;

import java.util.Scanner;

public class ScrumDailyOpdracht extends InteractieveOpdracht {

    public ScrumDailyOpdracht(Scanner scanner) {
        super(scanner, "DailyScrum");
    }

    @Override
    protected String getVraag() {
        return "Opdracht: Wat wordt besproken tijdens een Daily Scrum?";
    }

    @Override
    protected String[] getOpties() {
        return new String[] {
                "Gedetailleerde sprintplanning",
                "Wat ieder teamlid gedaan heeft, gaat doen, en blokkades",
                "Retrospective feedback"
        };
    }

    @Override
    protected String getJuisteAntwoord() {
        return "B";
    }

    @Override
    protected String getFeedbackCorrect() {
        return "Correct! Dat is precies de bedoeling van een Daily Scrum.";
    }

    @Override
    protected String getFeedbackFout() {
        return "Fout. Het juiste antwoord was: B) Wat ieder teamlid gedaan heeft, gaat doen, en blokkades.";
    }
}
