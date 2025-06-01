package Opdracht;

import java.util.Scanner;

/**
 * Deze opdracht test of je weet hoe je taken op een Scrum Board indeelt.
 * Je krijgt een taak en moet aangeven of die in "To Do", "Doing" of "Done" hoort.
 * <br>Handig om te oefenen hoe een Scrum Board werkt in het echte leven.
 */

//De constructor maakt een opdracht aan die hoort bij de ScrumBoard kamer
//geeft door aan de superklasse dat het om de ScrumBoard context gaat,
// zodat de juiste hints en vraaglogica gebruikt worden.
public class ScrumBoardOpdracht extends InteractieveOpdracht {
    public ScrumBoardOpdracht(Scanner scanner) {
        super(scanner, "ScrumBoard");
    }


    //Deze methode geeft de vraag terug die de speler op het scherm ziet.
    //Het is een specifieke meerkeuzevraag over het Scrum Board die bij deze opdracht hoort.
    @Override
    protected String getVraag() {
        return "Opdracht: Waar hoort de taak 'abstracte klasse controleren' op het Scrum Board?";
    }

    //Geeft de keuzemogelijkheden terug die de speler te zien krijgt bij de vraag.
    //In dit geval: drie kolommen van het Scrum Board waaruit je moet kiezen.
    @Override
    protected String[] getOpties() {
        return new String[] {
                "To Do",
                "Doing",
                "Done"
        };
    }

    //Geeft de keuzemogelijkheden terug die de speler te zien krijgt bij de vraag.
    //In dit geval drie kolommen van het Scrum Board waaruit je moet kiezen.
    @Override
    protected String getJuisteAntwoord() {
        return "B";
    }

    //Geeft de tekst terug die getoond wordt als de speler het juiste antwoord kiest.
    //Hier wordt de speler bevestigd dat "Doing" correct is.
    @Override
    protected String getFeedbackCorrect() {
        return "Correct! Deze taak zit midden in het werkproces – 'Doing' is juist.";
    }

    //Geeft de tekst terug die wordt getoond als de speler een fout antwoord geeft.
    //Het legt meteen uit wat het juiste antwoord wél had moeten zijn.
    @Override
    protected String getFeedbackFout() {
        return "Fout. Deze taak hoort bij: B) Doing.";
    }
}
