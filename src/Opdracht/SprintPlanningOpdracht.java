package Opdracht;

import Hint.Hint;
import Hint.HintFactory;
import Kamer.Kamer;
import java.util.Scanner;

public class SprintPlanningOpdracht implements OpdrachtStrategy {

    private final Scanner scanner;

    public SprintPlanningOpdracht(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public boolean voerUit(Kamer kamer, Joker gekozenJoker) {
        System.out.println("Wat plan je in de sprint?");
        System.out.println("A) Bugs oplossen");
        System.out.println("B) Wat het team kan afronden");
        System.out.println("C) Alles in de backlog");

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
                System.out.println("Correct! Je plant alleen wat het team realistisch kan afronden.");
                return true;
            } else if (antwoord.equals("a") || antwoord.equals("c")) {
                System.out.println("Fout! Je plant geen willekeurige bugs of alles uit de backlog.");
                System.out.print("Wil je een hint? (ja/nee): ");
                String keuze = scanner.nextLine().trim().toLowerCase();

                if (keuze.equals("ja")) {
                    Hint hint = HintFactory.geefRandomHint("SprintPlanning");
                    System.out.println("Hint (" + hint.getType() + "): " + hint.getTekst());
                }

                return false;
            }

            System.out.println("Ongeldige keuze.");
        }
    }
}
