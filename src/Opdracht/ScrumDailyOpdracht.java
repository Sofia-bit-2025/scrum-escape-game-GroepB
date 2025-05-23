package Opdracht;

import java.util.Scanner;
import Hint.HintProvider;



public class ScrumDailyOpdracht implements OpdrachtStrategy {

    private final HintProvider hintProvider;
    public ScrumDailyOpdracht(HintProvider hintProvider) {
        this.hintProvider = hintProvider;
    }



    //vraag
    @Override
    public boolean voerUit() {
        System.out.println("Opdracht: Wat wordt besproken tijdens een Daily Scrum?");
        System.out.println("A) Gedetailleerde sprintplanning");
        System.out.println("B) Wat ieder teamlid gedaan heeft, gaat doen, en blokkades");
        System.out.println("C) Retrospective feedback");

        // input vragen
        Scanner scanner = new Scanner(System.in);
        System.out.print("> Jouw antwoord: ");
        String antwoord = scanner.nextLine().trim().toUpperCase();//spatie weghalen en naar hoofdletters omzetten

        // Alleen eerste letter checken
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
                System.out.println("Hint: " + hintProvider.getHint());
            }
            return false;
        }
    }
}
