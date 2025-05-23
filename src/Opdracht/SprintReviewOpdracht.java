package Opdracht;

import java.util.Scanner;

import Hint.HintFactory;
import Hint.HintProvider;

public class SprintReviewOpdracht implements OpdrachtStrategy {


    @Override
    public boolean voerUit() {
        System.out.println("Opdracht: Evalueer de feedback van stakeholders.");
        System.out.println("Welke actie hoort bij een goede Sprint Review?");
        System.out.println("A) Nieuwe sprintdoelen plannen");
        System.out.println("B) Feedback ontvangen en bespreken");
        System.out.println("C) De sprint beëindigen zonder overleg");

        Scanner scanner = new Scanner(System.in);
        System.out.print("> Kies A, B of C: ");
        String antwoord = scanner.nextLine().trim().toUpperCase();

        if (antwoord.length() > 0) {
            antwoord = antwoord.substring(0, 1);
        }

        switch (antwoord) {
            case "B":
                System.out.println("Juist! Een Sprint Review draait om feedback en samenwerking.");
                return true;
            case "A":
            case "C":
                System.out.println("Fout. In de Review wordt vooral teruggeblikt met stakeholders.");

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
