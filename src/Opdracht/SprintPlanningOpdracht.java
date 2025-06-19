package Opdracht;

import java.util.Scanner;

public class SprintPlanningOpdracht extends InteractieveOpdracht {

    public SprintPlanningOpdracht(Scanner scanner) {
        super(scanner, "SprintPlanning");
    }

    @Override
    protected String getVraag() {
        return "Wat plan je in de sprint?";
    }

    @Override
    protected String[] getOpties() {
        return new String[] {
                "Bugs oplossen",
                "Wat het team kan afronden",
                "Alles in de backlog"
        };
    }

    @Override
    protected String getJuisteAntwoord() {
        return "B";
    }

    @Override
    protected String getFeedbackCorrect() {
        return "Correct! Je plant alleen wat het team realistisch kan afronden.";
    }

    @Override
    protected String getFeedbackFout() {
        return "Fout! Je plant geen willekeurige bugs of alles uit de backlog.";
    }
}
