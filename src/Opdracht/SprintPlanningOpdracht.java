package Opdracht;

import java.util.Scanner;

import Hint.HintFactory;
import Hint.HintProvider;

public class SprintPlanningOpdracht implements OpdrachtStrategy {



    //vraag en keuzemogelijkheden tonen
    @Override
    public boolean voerUit() {
        System.out.println("Wat plan je in de sprint?");
        System.out.println("A) Bugs oplossen");
        System.out.println("B) Wat het team kan afronden");
        System.out.println("C) Alles in de backlog");

        //antwoorden ophalen via scanner
        Scanner scanner = new Scanner(System.in);
        System.out.print("> Kies A, B of C: ");
        String antwoord = scanner.nextLine().trim().toUpperCase();

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

                System.out.print("Wil je een hint? (ja/nee): ");
                String keuze = scanner.nextLine().trim().toLowerCase();

                if (keuze.equals("ja")) {
                    HintProvider hintProvider = HintFactory.createRandomHintProvider();
                    System.out.println("Hint: " + hintProvider.getHint());
                }

                return false;
        }
        return false;
    }
}
