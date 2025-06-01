package Opdracht;

import java.util.Scanner;

/**
 * Deze opdracht test of je weet wat belangrijk is tijdens een Sprint Review.
 * Je krijgt een meerkeuzevraag over wat je hoort te doen als je feedback van stakeholders krijgt.
 * <br>Handig om te snappen dat een review geen eenrichtingsverkeer is – je bespreekt samen het resultaat.
 */



//Deze constructor maakt een SprintReviewOpdracht-object aan. Hij geeft aan dat de context "SprintReview" is,
// zodat hints en logica afgestemd zijn op deze kamer.
// De scanner wordt gebruikt voor invoer van de speler.
public class SprintReviewOpdracht extends InteractieveOpdracht {
    public SprintReviewOpdracht(Scanner scanner) {
        super(scanner, "SprintReview"); // context toevoegen
    }



    //Geeft de vraagtekst terug die aan de speler wordt gesteld in deze opdracht.
    @Override
    protected String getVraag() {
        return "Opdracht: Evalueer de feedback van stakeholders.\nWelke actie hoort bij een goede Sprint Review?";
    }


    //Geeft de antwoordopties terug waaruit de speler kan kiezen.
    // Elke optie stelt een mogelijke actie voor tijdens een Sprint Review.
    @Override
    protected String[] getOpties() {
        return new String[] {
                "Nieuwe sprintdoelen plannen",
                "Feedback ontvangen en bespreken",
                "De sprint beëindigen zonder overleg"
        };
    }


    //geeft aan wat het juiste antwoord is op de meerkeuzevraag
    @Override
    protected String getJuisteAntwoord() {
        return "B";
    }

    //Geeft de feedbacktekst die wordt getoond als de speler het juiste antwoord kiest
    //  dus een positieve bevestiging dat het klopt
    @Override
    protected String getFeedbackCorrect() {
        return "Juist! Een goede Sprint Review draait om feedback en samenwerking";
    }

    //Geeft de tekst die verschijnt als de speler het fout heeft
    //  een korte uitleg waarom het gekozen antwoord niet klopt
    @Override
    protected String getFeedbackFout() {
        return "Fout. In een Sprint Review bespreek je vooral de feedback van stakeholders";
    }
}
