package Opdracht;

import java.util.Scanner;

public class SprintPlanningOpdracht implements OpdrachtStrategy {

    @Override
    public void voerUit() {
        System.out.println("Wat plan je in de sprint?");
        System.out.println("A) Bugs oplossen");
        System.out.println("B) Wat het team kan afronden");
        System.out.println("C) Alles in de backlog");

        Scanner scanner = new Scanner(System.in);
        System.out.print("> Kies A, B of C: ");
        String antwoord = scanner.nextLine().trim().toUpperCase();

        if (antwoord.equals("B")) {
            System.out.println("Correct! Je plant alleen wat het team realistisch kan afronden.");
        } else if (antwoord.equals("A") || antwoord.equals("C")) {
            System.out.println("Fout! In een Sprint plan je alleen wat haalbaar is.");
            // Hier nog  een monster kunnen activeren
            // monster.activeer(); via die methode
        } else {
            System.out.println(" Ongeldig antwoord. Kies A, B of C.");
        }
    }
}
