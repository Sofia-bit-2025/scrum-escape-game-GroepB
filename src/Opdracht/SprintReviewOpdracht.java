package Opdracht;

import Hint.Hint;
import Hint.HintFactory;
import Kamer.Kamer;
import java.util.Scanner;

public class SprintReviewOpdracht implements OpdrachtStrategy {

    private final Scanner scanner;

    public SprintReviewOpdracht(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public boolean voerUit(Kamer kamer, Joker gekozenJoker) {
        System.out.println("Opdracht: Evalueer de feedback van stakeholders.");
        System.out.println("Welke actie hoort bij een goede Sprint Review?");
        System.out.println("A) Nieuwe sprintdoelen plannen");
        System.out.println("B) Feedback ontvangen en bespreken");
        System.out.println("C) De sprint beëindigen zonder overleg");

        while (true) {
            System.out.print("> Kies A, B of C (of typ 'joker'): ");
            String antwoord = scanner.nextLine().trim().toLowerCase();

            if (antwoord.equals("joker")) {
                if (gekozenJoker.isAvailableFor(kamer)) {
                    gekozenJoker.useIn(kamer);
                } else {
                    System.out.println("De joker kan hier niet worden gebruikt of is al opgebruikt.");
                }
                continue;
            }

            if (antwoord.length() > 0) {
                antwoord = antwoord.substring(0, 1);
            }

            if (antwoord.equals("b")) {
                System.out.println("Juist! Een Sprint Review draait om feedback en samenwerking.");
                return true;
            } else if (antwoord.equals("a") || antwoord.equals("c")) {
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
        }
    }
}
