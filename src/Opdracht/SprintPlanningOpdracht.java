package Opdracht;

import java.util.Scanner;

/**
 * Deze opdracht test of je snapt wat je wel en niet plant in een sprint.
 * Je krijgt een meerkeuzevraag over sprintplanning.
 * <br>Handig om te leren dat je alleen plant wat je team ook echt af kan krijgen.
 */



//Zorgt ervoor dat de opdracht gekoppeld is aan de kamer SprintPlanning
// ende speler via de scanner input kan geven.
public class SprintPlanningOpdracht extends InteractieveOpdracht {
    public SprintPlanningOpdracht(Scanner scanner) {
        super(scanner, "SprintPlanning"); // correcte context meegeven
    }


    //Geeft de vraag die aan de speler wordt gesteld tijdens deze opdracht
    @Override
    protected String getVraag() {
        return "Wat plan je in de sprint?";
    }


    //Deze methode levert de keuzemogelijkheden meerkeuze antwoorden
    // die de speler te zien krijgt bij de vraag.
    @Override
    protected String[] getOpties() {
        return new String[] {
                "Bugs oplossen",
                "Wat het team kan afronden",
                "Alles in de backlog"
        };
    }


//Geeft aan wat het correcte antwoord is op de vraag (in dit geval optie B).
    @Override
    protected String getJuisteAntwoord() {
        return "B";
    }

    //Geeft de feedbacktekst terug die getoond wordt als de speler het juiste antwoord heeft gekozen.
    @Override
    protected String getFeedbackCorrect() {
        return "Correct! In een sprint plan je alleen wat het team realistisch kan afronden.";
    }

    //Functie van deze methode:
    //Geeft de foutmelding die wordt getoond als de speler een verkeerd antwoord kiest.
    @Override
    protected String getFeedbackFout() {
        return "Fout! Je plant alleen datgene wat het team kan afronden, niet willekeurig alles of alle bugs.";
    }
}
