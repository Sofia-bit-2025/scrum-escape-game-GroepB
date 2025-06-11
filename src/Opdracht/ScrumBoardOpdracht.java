package Opdracht;

import Hint.Hint;
import Hint.HintFactory;
import Kamer.Kamer;
import java.util.Scanner;

public class ScrumBoardOpdracht implements OpdrachtStrategy {

    private final Scanner scanner;

    public ScrumBoardOpdracht(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public boolean voerUit(Kamer kamer, Joker gekozenJoker) {
        System.out.println("Opdracht: Waar hoort de taak 'abstracte klasse controleren' op het Scrum Board?");
        System.out.println("A) To Do");
        System.out.println("B) Doing");
        System.out.println("C) Done");

        while (true) {
            System.out.print("> Jouw antwoord (of typ 'joker'): ");
            String antwoord = scanner.nextLine().trim().toLowerCase();

            if (antwoord.equals("joker")) {
                if (gekozenJoker.isAvailableFor(kamer)) {
                    gekozenJoker.useIn(kamer);
                } else {
                    System.out.println("De joker kan hier niet worden gebruikt of is al opgebruikt.");
                }
                continue;  // laat speler daarna nog steeds antwoorden
            }

            if (antwoord.length() > 0) {
                antwoord = antwoord.substring(0, 1); // Pak eerste letter
            }

            if (antwoord.equals("b")) {
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
}
