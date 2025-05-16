package Opdracht;

import java.util.Scanner;

public class SprintReviewOpdracht implements OpdrachtStrategy {
    @Override
    public void voerUit() {
        System.out.println(" Opdracht: Evalueer de feedback van stakeholders.");
        System.out.println("Welke actie hoort bij een goede Sprint Review?");
        System.out.println("A) Nieuwe sprintdoelen plannen");
        System.out.println("B) Feedback ontvangen en bespreken");
        System.out.println("C) De sprint beëindigen zonder overleg");

        Scanner scanner = new Scanner(System.in);
        System.out.print("> Kies A, B of C: ");
        String antwoord = scanner.nextLine().trim().toUpperCase();

        if (antwoord.equals("B")) {
            System.out.println("Juist! Een Sprint Review draait om feedback en samenwerking.");
        } else if (antwoord.equals("A") || antwoord.equals("C")) {
            System.out.println("Fout. In de Review wordt er vooral teruggeblikt met stakeholders.");
        } else {
            System.out.println(" Ongeldig . Kies A, B of C.");
        }
    }
}
