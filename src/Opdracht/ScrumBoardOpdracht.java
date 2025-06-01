package Opdracht;

import Hint.Hint;
import Hint.HintFactory;

import java.util.Scanner;

/**
 * Een concrete opdracht voor de ScrumBoard-kamer.
 * De speler moet aangeven op welk deel van het Scrum Board een taak thuishoort.
 * <br>Hints worden via HintFactory opgehaald en zijn afhankelijk van de context "ScrumBoard".
 * <br>Volledig in lijn met User Story 20 en het Dependency Inversion Principle.
 */
public class ScrumBoardOpdracht implements OpdrachtStrategy {

    private final Scanner scanner;

    public ScrumBoardOpdracht(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public boolean voerUit() {
        System.out.println("Opdracht: Waar hoort de taak 'abstracte klasse controleren' op het Scrum Board?");
        System.out.println("A) To Do");
        System.out.println("B) Doing");
        System.out.println("C) Done");

        System.out.print("> Jouw antwoord: ");
        String antwoord = scanner.nextLine().trim().toUpperCase();

        if (antwoord.length() > 0) {
            antwoord = antwoord.substring(0, 1); // Pak eerste letter
        }

        if (antwoord.equals("B")) {
            System.out.println("Correct! Deze taak hoort bij 'Doing'.");
            return true;
        } else {
            System.out.println("Fout. Het juiste antwoord was: B) Doing.");
            System.out.print("Wil je een hint? (ja/nee): ");
            String keuze = scanner.nextLine().trim().toLowerCase();

            if (keuze.equals("ja")) {
                Hint hint = HintFactory.geefRandomHint("ScrumBoard");
                System.out.println("Hint (" + hint.getType() + "): " + hint.getTekst());
            }

            return false;
        }
    }
}
