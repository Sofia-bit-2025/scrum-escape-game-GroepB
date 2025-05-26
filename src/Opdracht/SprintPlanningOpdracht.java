package Opdracht;

import java.util.Scanner;
public class SprintPlanningOpdracht implements OpdrachtStrategy {

    @Override
    public boolean voerUit() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Wat plan je in de sprint?");
            System.out.println("A) Bugs oplossen");
            System.out.println("B) Wat het team kan afronden");
            System.out.println("C) Alles in de backlog");
            System.out.print("> Kies A, B of C: ");
            String input = scanner.nextLine().trim().toUpperCase();

            if (input.equals("hint")) {
                JokerManager.gebruikHint("Taken die in uitvoering zijn horen bij 'Doing'.");
                continue; // stel vraag opnieuw
            }

            String antwoord = input.toUpperCase();

            // Controle op eerste letter
            if (antwoord.length() > 0) {
                antwoord = antwoord.substring(0, 1);
            }


            switch (antwoord) {
                case "B":
                    System.out.println("Correct! Je plant alleen wat het team realistisch kan afronden.");
                    return true;
                case "A":
                case "C":
                    System.out.println("Fout! Je plant geen willekeurige bugs of alles uit de backlog.");
                    return false;
                default:
                    System.out.println("Ongeldig antwoord. Kies A, B of C.");
                    return false;
            }
        }
    }
}
