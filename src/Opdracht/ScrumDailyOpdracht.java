package Opdracht;

import java.util.Scanner;

public class ScrumDailyOpdracht implements OpdrachtStrategy {

    @Override
    public boolean voerUit() {
        System.out.println("Opdracht: Wat wordt besproken tijdens een Daily Scrum?");
        System.out.println("A) Gedetailleerde sprintplanning");
        System.out.println("B) Wat ieder teamlid gedaan heeft, gaat doen, en blokkades");
        System.out.println("C) Retrospective feedback");

        Scanner scanner = new Scanner(System.in);
        System.out.print("> Jouw antwoord: ");
        String antwoord = scanner.nextLine().trim().toUpperCase();

        // Alleen eerste letter checken
        if (antwoord.length() > 0) {
            antwoord = antwoord.substring(0, 1);
        }

        if (antwoord.equals("B")) {
            System.out.println("Correct! Dat is precies de bedoeling van een Daily Scrum.");
            return true;
        } else {
            System.out.println("Fout. Het juiste antwoord was: B) Wat ieder teamlid gedaan heeft, gaat doen, en blokkades.");
            // Eventueel: speler.voegMonsterToe(new Vertraging());
            return false;
        }
    }
}
