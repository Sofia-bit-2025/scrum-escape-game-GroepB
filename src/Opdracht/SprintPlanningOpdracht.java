package Opdracht;

import Hint.Hint;
import Hint.HintFactory;

import java.util.Scanner;

/**
 * Opdracht voor de Sprint Planning-kamer.
 * De speler moet weten wat je realistisch plant in een sprint.
 * Bij een fout antwoord kan hij een hint krijgen (context: "SprintPlanning").
 */
public class SprintPlanningOpdracht implements OpdrachtStrategy {

    private final Scanner scanner;

    public SprintPlanningOpdracht(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public boolean voerUit() {
        System.out.println("Wat plan je in de sprint?");
        System.out.println("A) Bugs oplossen");
        System.out.println("B) Wat het team kan afronden");
        System.out.println("C) Alles in de backlog");

        System.out.print("> Kies A, B of C: ");
        String antwoord = scanner.nextLine().trim().toUpperCase();

        if (antwoord.length() > 0) {
            antwoord = antwoord.substring(0, 1);
        }

        if (antwoord.equals("B")) {
            System.out.println("Correct! Je plant alleen wat het team realistisch kan afronden.");
            return true;
        } else if (antwoord.equals("A") || antwoord.equals("C")) {
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
        return false;
    }
}
