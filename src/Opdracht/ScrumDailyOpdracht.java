package Opdracht;

import Hint.Hint;
import Hint.HintFactory;

import java.util.Scanner;

/**
 * Een concrete opdracht voor de Daily Scrum-kamer.
 * De speler moet weten wat er tijdens een Daily Scrum besproken wordt.
 * Bij een fout antwoord kan hij een hint krijgen, gefilterd op context "DailyScrum".
 */
public class ScrumDailyOpdracht implements OpdrachtStrategy {

    private final Scanner scanner;

    public ScrumDailyOpdracht(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public boolean voerUit() {
        System.out.println("Opdracht: Wat wordt besproken tijdens een Daily Scrum?");
        System.out.println("A) Gedetailleerde sprintplanning");
        System.out.println("B) Wat ieder teamlid gedaan heeft, gaat doen, en blokkades");
        System.out.println("C) Retrospective feedback");

        System.out.print("> Jouw antwoord: ");
        String antwoord = scanner.nextLine().trim().toUpperCase();

        if (antwoord.length() > 0) {
            antwoord = antwoord.substring(0, 1);
        }

        if (antwoord.equals("B")) {
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
