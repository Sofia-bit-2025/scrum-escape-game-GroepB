package Opdracht;

import java.util.Scanner;

/**
 * De laatste opdracht van het spel – een soort eindexamen over Scrum.
 * Je krijgt een meerkeuzevraag over waarom Scrum in rondes (iteraties) werkt.
 * <br>Het helpt je begrijpen dat je bij Scrum steeds een beetje beter wordt, in plaats van alles in één keer te doen.
 */


//Zorgt ervoor dat deze opdracht correct gekoppeld wordt aan de context TiaFinaleKamer
public class TiaFinaleOpdracht extends InteractieveOpdracht {
    public TiaFinaleOpdracht(Scanner scanner) {
        super(scanner, "TiaFinaleKamer");
    }

    //Geeft de vraagtekst terug die aan de speler wordt gesteld bij deze finale opdracht.
    @Override
    protected String getVraag() {
        return "Finale opdracht: Waarom werkt Scrum iteratief?";
    }


    //Geeft de antwoordopties terug voor de meerkeuzevraag.
    // Elke string in de array is één keuze
    //De speler moet hieruit kiezen
    @Override
    protected String[] getOpties() {
        return new String[] {
                "Zodat alles tegelijk opgeleverd wordt",
                "Om geleidelijk feedback te verwerken en continu te verbeteren",
                "Omdat teams niet kunnen plannen"
        };
    }

    //Geeft aan welk antwoord het juiste is voor deze opdracht.
    @Override
    protected String getJuisteAntwoord() {
        return "B";
    }

    //Geeft de feedback die wordt getoond als de speler het juiste antwoord kiest.
    @Override
    protected String getFeedbackCorrect() {
        return "Juist! Scrum gebruikt iteraties om continu te verbeteren.";
    }

    //Geeft de feedback die getoond wordt als de speler het foute antwoord kiest. 
    @Override
    protected String getFeedbackFout() {
        return "Fout. Scrum gebruikt iteraties om steeds kleine stappen te verbeteren.";
    }
}
