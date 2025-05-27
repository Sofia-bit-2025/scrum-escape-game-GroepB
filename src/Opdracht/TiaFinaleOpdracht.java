package Opdracht;

import java.util.Scanner;

import Hint.HintFactory;
import Hint.HintProvider;

public class TiaFinaleOpdracht implements OpdrachtStrategy {



    @Override
    public boolean voerUit() {
        System.out.println("Finale opdracht: Waarom werkt Scrum iteratief?");
        System.out.println("A) Zodat alles tegelijk opgeleverd wordt");
        System.out.println("B) Om geleidelijk feedback te verwerken en continu te verbeteren");
        System.out.println("C) Omdat teams niet kunnen plannen");

        Scanner scanner = new Scanner(System.in);
        System.out.print("> Kies A, B of C: ");

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

                System.out.print("Wil je een hint? (ja/nee): ");
                String keuze = scanner.nextLine().trim().toLowerCase();

                if (keuze.equals("ja")) {
                    HintProvider hintProvider = HintFactory.createRandomHintProvider();
                    System.out.println("Hint: " + hintProvider.getHint());
                }

                return false;  // altijd returnen, ongeacht of speler een hint wil
        }
        return false;
    }
}



