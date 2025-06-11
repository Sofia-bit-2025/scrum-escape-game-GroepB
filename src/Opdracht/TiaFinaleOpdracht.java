package Opdracht;

import Hint.Hint;
import Hint.HintFactory;
import Kamer.Kamer;
import java.util.Scanner;

public class TiaFinaleOpdracht implements OpdrachtStrategy {

    private final Scanner scanner;

    public TiaFinaleOpdracht(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public boolean voerUit(Kamer kamer, Joker gekozenJoker) {
        System.out.println("Finale opdracht: Waarom werkt Scrum iteratief?");
        System.out.println("A) Zodat alles tegelijk opgeleverd wordt");
        System.out.println("B) Om geleidelijk feedback te verwerken en continu te verbeteren");
        System.out.println("C) Omdat teams niet kunnen plannen");

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
                System.out.println("Juist! Scrum gebruikt iteraties om continu te verbeteren.");
                return true;
            } else if (antwoord.equals("a") || antwoord.equals("c")) {
                System.out.println("Fout. Scrum gebruikt iteraties om steeds kleine stappen te verbeteren.");
                System.out.print("Wil je een hint? (ja/nee): ");
                String keuze = scanner.nextLine().trim().toLowerCase();

                if (keuze.equals("ja")) {
                    Hint hint = HintFactory.geefRandomHint("Finale");
                    System.out.println("Hint (" + hint.getType() + "): " + hint.getTekst());
                }

                return false;
            }

            System.out.println("Ongeldige keuze.");
        }
    }
}
