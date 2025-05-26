package Opdracht;

import java.util.Scanner;

public class TiaFinaleOpdracht implements OpdrachtStrategy {

    @Override
    public boolean voerUit() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Finale opdracht: Waarom werkt Scrum iteratief?");
            System.out.println("A) Zodat alles tegelijk opgeleverd wordt");
            System.out.println("B) Om geleidelijk feedback te verwerken en continu te verbeteren");
            System.out.println("C) Omdat teams niet kunnen plannen");
            System.out.print("> Kies A, B of C: ");
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.equals("hint")) {
                JokerManager.gebruikHint("Taken die in uitvoering zijn horen bij 'Doing'.");
                continue; // stel vraag opnieuw
            }
            String antwoord = scanner.nextLine().trim().toUpperCase();


            // Alleen eerste letter gebruiken
            if (antwoord.length() > 0) {
                antwoord = antwoord.substring(0, 1);
            }

            switch (antwoord) {
                case "B":
                    System.out.println("Juist! Scrum gebruikt iteraties om continu te verbeteren.");
                    return true;
                case "A":
                case "C":
                    System.out.println("Fout. Scrum gebruikt iteraties om steeds kleine stappen te verbeteren.");
                    return false;
                default:
                    System.out.println("Ongeldig antwoord. Kies A, B of C.");
                    return false;
            }
        }
    }
}
