package Opdracht;

import java.util.Scanner;

public class ScrumBoardOpdracht implements OpdrachtStrategy {

    @Override
    public boolean voerUit() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Opdracht: Waar hoort de taak 'abstracte klasse controleren' op het Scrum Board?");
            System.out.println("A) To Do");
            System.out.println("B) Doing");
            System.out.println("C) Done");
            System.out.print("> Jouw antwoord of typ 'hint': ");

            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("hint")) {
                JokerManager.gebruikHint("Taken die in uitvoering zijn horen bij 'Doing'.");
                continue; // stel vraag opnieuw
            }

            String antwoord = input.toUpperCase();
            if (antwoord.length() > 0) {
                antwoord = antwoord.substring(0, 1);
            }

            if (antwoord.equals("B")) {
                System.out.println("Correct! Deze taak hoort bij 'Doing'.");
                return true;
            } else if (antwoord.equals("A") || antwoord.equals("C")) {
                System.out.println("Fout. Het juiste antwoord was: B) Doing.");
                return false;
            } else {
                System.out.println("Ongeldig antwoord. Kies A, B, C of typ 'hint'.");
            }
        }
    }
}
