package Opdracht;

import Hint.Hint;
import Hint.HintFactory;

import java.util.Scanner;

/**
 * Een concrete opdracht voor de Sprint Review-kamer.
 */
public class SprintReviewOpdracht implements OpdrachtStrategy {

    private final Scanner scanner;

    public SprintReviewOpdracht(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public boolean voerUit() {
        System.out.println("Opdracht: Evalueer de feedback van stakeholders.");
        System.out.println("Welke actie hoort bij een goede Sprint Review?");
        System.out.println("A) Nieuwe sprintdoelen plannen");
        System.out.println("B) Feedback ontvangen en bespreken");
        System.out.println("C) De sprint beëindigen zonder overleg");

        System.out.print("> Kies A, B of C: ");
        String antwoord = scanner.nextLine().trim().toUpperCase();

        if (antwoord.length() > 0) {
            antwoord = antwoord.substring(0, 1);
        }

        if (antwoord.equals("B")) {
            System.out.println("Juist! Een Sprint Review draait om feedback en samenwerking.");
            return true;
        } else if (antwoord.equals("A") || antwoord.equals("C")) {
            System.out.println("Fout. In de Review wordt vooral teruggeblikt met stakeholders.");

            System.out.print("Wil je een hint? (ja/nee): ");
            String keuze = scanner.nextLine().trim().toLowerCase();

            if (keuze.equals("ja")) {
                Hint hint = HintFactory.geefRandomHint("SprintReview");
                System.out.println("Hint (" + hint.getType() + "): " + hint.getTekst());
            }

            return false;
        }

        System.out.println("Ongeldige keuze.");
        return false;
    }
}
