package Opdracht;

import Hint.Hint;
import Hint.HintFactory;
import Kamer.Kamer;
import java.util.Scanner;

public class ScrumDailyOpdracht implements OpdrachtStrategy {

    private final Scanner scanner;

    public ScrumDailyOpdracht(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public boolean voerUit(Kamer kamer, Joker gekozenJoker) {
        System.out.println("Opdracht: Wat wordt besproken tijdens een Daily Scrum?");
        System.out.println("A) Gedetailleerde sprintplanning");
        System.out.println("B) Wat ieder teamlid gedaan heeft, gaat doen, en blokkades");
        System.out.println("C) Retrospective feedback");

        while (true) {
            System.out.print("> Jouw antwoord (of typ 'joker'): ");
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
                System.out.println("Correct! Dat is precies de bedoeling van een Daily Scrum.");
                return true;
            } else {
                System.out.println("Fout. Het juiste antwoord was: B) Wat ieder teamlid gedaan heeft, gaat doen, en blokkades.");
                System.out.print("Wil je een hint? (ja/nee): ");
                String keuze = scanner.nextLine().trim().toLowerCase();

                if (keuze.equals("ja")) {
                    Hint hint = HintFactory.geefRandomHint("DailyScrum");
                    System.out.println("Hint (" + hint.getType() + "): " + hint.getTekst());
                }

                return false;
            }
        }
    }
}
