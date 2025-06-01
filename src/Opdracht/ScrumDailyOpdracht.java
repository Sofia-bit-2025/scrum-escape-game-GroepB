package Opdracht;

import java.util.Scanner;

/**
 * Deze opdracht checkt of je weet wat er besproken wordt tijdens een Daily Scrum.
 * Je krijgt een meerkeuzevraag over de standaardinhoud van een Daily.
 * <br>Super handig om te oefenen wat je wel of niet moet zeggen in zo’n meeting.
 */


//De constructor maakt een opdracht aan die hoort bij de Daily Scrum kamer.
//Hij geeft ook meteen de juiste context DailyScrum
// mee aan de bovenliggende InteractieveOpdracht, zodat hints en filters weten waar het over gaat.
public class ScrumDailyOpdracht extends InteractieveOpdracht {
    public ScrumDailyOpdracht(Scanner scanner) {
        super(scanner, "DailyScrum");
    }

    //Deze methode geeft simpelweg de vraag terug die aan de speler wordt gesteld in de opdracht.
    //Hier: wat je bespreekt tijdens een Daily Scrum  Handig om weer te geven in de CLI.
    @Override
    protected String getVraag() {
        return "Opdracht: Wat wordt besproken tijdens een Daily Scrum?";
    }

    //Deze methode geeft de drie antwoordopties terug waaruit de speler kan kiezen.
    //Wordt gebruikt om de meerkeuzevraag op het scherm te tonen
    @Override
    protected String[] getOpties() {
        return new String[] {
                "Gedetailleerde sprintplanning",
                "Wat ieder teamlid gedaan heeft, gaat doen, en blokkades",
                "Retrospective feedback"
        };
    }

    //Deze methode geeft aan wat het juiste antwoord is op de vraag
    @Override
    protected String getJuisteAntwoord() {
        return "B";
    }

    //Geeft de tekst terug die de speler ziet als die het juiste antwoord heeft gegeven.
    @Override
    protected String getFeedbackCorrect() {
        return "Correct! De Daily Scrum gaat precies daarover.";
    }

    @Override
    protected String getFeedbackFout() {
        return "Fout. De juiste inhoud is: B) Wat ieder teamlid gedaan heeft, gaat doen, en blokkades.";
    }
}
