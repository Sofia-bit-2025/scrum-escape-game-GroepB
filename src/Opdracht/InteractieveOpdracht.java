package Opdracht;

import Hint.Hint;
import Hint.HintFactory;

import java.util.Scanner;

/**
 * Een abstracte opdracht waarbij je een meerkeuzevraag moet beantwoorden.
 * Wordt gebruikt door specifieke kamers zoals SprintPlanning of ScrumBoard.
 * <br>Geeft feedback op je antwoord, en als je het fout hebt, kun je een hint vragen.
 * <br>De hints worden op basis van de kamercontext gekozen via de HintFactory.
 */


//Deze abstracte klasse is een sjabloon voor opdrachten
// waarbij de speler vragen moet beantwoorden.
public abstract class InteractieveOpdracht implements OpdrachtStrategy {
    protected final Scanner scanner;
    private final String context;


    //De constructor zorgt dat er een Scanner en een geldige context wordt meegegeven.
    public InteractieveOpdracht(Scanner scanner, String context) {
        if (scanner == null) throw new IllegalArgumentException("Scanner mag niet null zijn.");
        if (context == null || context.isBlank()) throw new IllegalArgumentException("Context mag niet leeg zijn.");
        this.scanner = scanner;
        this.context = context;
    }

    //Deze methode moet door elke concrete opdracht ingevuld worden.
    protected abstract String getVraag();

    //Deze methode levert de mogelijke antwoordopties van de opdracht terug,
    protected abstract String[] getOpties();

    //Geeft het juiste antwoord terug, zoals B.
    // Wordt gebruikt om te checken of de speler het goed heeft beantwoord.
    protected abstract String getJuisteAntwoord(); // Bijv. "A", "B", ...

    //Geeft de feedbacktekst die getoond wordt als de speler het goede antwoord heeft gekozen.
    protected abstract String getFeedbackCorrect();

    //Geeft de tekst die je ziet als je het foute antwoord kiest.
    protected abstract String getFeedbackFout();

    //Toont de vraag en bijbehorende opties A B C  aan de speler.
    @Override
    public boolean voerUit() {
        System.out.println(getVraag());
        String[] opties = getOpties();
        char letter = 'A';
        for (String optie : opties) {
            System.out.println(letter++ + ") " + optie);
        }

        //Wacht op input van de speler,
        // maakt het antwoord hoofdletters en verwijdert spaties.
        System.out.print("> Kies een optie (A, B, C...): ");
        String antwoord = scanner.nextLine().trim().toUpperCase();


        // Deze checkt of de invoer precies één hoofdletter is bijv. A en B
        // Als dat niet zo is, krijgt de speler een foutmelding en stopt de opdracht
        if (!antwoord.matches("[A-Z]") || antwoord.length() != 1) {
            System.out.println("Ongeldige keuze. Kies bijvoorbeeld A, B of C.");
            return false;
        }


        //Controleert of het antwoord klopt met het juiste antwoord
        if (antwoord.equals(getJuisteAntwoord())) {
            System.out.println(getFeedbackCorrect());
            return true;


            //Als het antwoord fout is,
            // print hij de foute feedback en vraagt de speler of die een hint wil.
        } else {
            System.out.println(getFeedbackFout());
            System.out.print("Wil je een hint? (ja/nee): ");
            String keuze = scanner.nextLine().trim().toLowerCase();


            //Als je "ja" hebt gekozen,
            // dan vraagt hij via de HintFactory een willekeurige hint op die past bij de huidige context
            if (keuze.equals("ja")) {
                Hint hint = HintFactory.geefRandomHint(context);
                System.out.println("Hint (" + hint.getType() + "): " + hint.getTekst());
            }

            return false;
        }
    }
}
