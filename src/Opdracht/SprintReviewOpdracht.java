package Opdracht;

import java.util.Scanner;

public class SprintReviewOpdracht implements OpdrachtStrategy {

    @Override
    public boolean voerUit() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Opdracht: Evalueer de feedback van stakeholders.");
            System.out.println("Welke actie hoort bij een goede Sprint Review?");
            System.out.println("A) Nieuwe sprintdoelen plannen");
            System.out.println("B) Feedback ontvangen en bespreken");
            System.out.println("C) De sprint beëindigen zonder overleg");
            System.out.print("> Kies A, B of C: ");

            String input = scanner.nextLine().trim().toUpperCase();
            if (input.equals("hint")) {
                JokerManager.gebruikHint("Taken die in uitvoering zijn horen bij 'Doing'.");
                continue; // stel vraag opnieuw
            }


            String antwoord = input.toUpperCase();

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
                    return false;
                default:
                    System.out.println("Ongeldig antwoord. Kies A, B of C.");
                    return false;
            }
        }
    }
}
