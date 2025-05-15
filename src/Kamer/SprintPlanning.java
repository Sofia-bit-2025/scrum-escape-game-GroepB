//De speler te introduceren aan Sprint Planning binnen Scrum;
//De kamer-instructie en bijbehorende actie/opdracht te tonen;
//Onderdeel te zijn van een polymorf ontwerp
// (via de Kamer interface) waarbij iedere kamer
// een eigen Scrumonderwerp behandelt.

package Kamer;
import java.util.Scanner;

public class SprintPlanning implements Kamer {
    private final String naam = "Sprint Planning";
    private final String instructie = "Bepaal wat haalbaar is in de komende sprint.";

    @Override
    public void betreed() {
        System.out.println("Je betreedt: " + naam);
        System.out.println(instructie);
    }

    @Override
    public void actieUitvoeren() {
        System.out.println("Wat is het doel van een Sprint Planning?");
        System.out.println("A) Feedback verzamelen\nB) Doelen kiezen en werk inschatten\nC) Werk afronden");
        Scanner scanner = new Scanner(System.in);
        String antwoord = scanner.nextLine();
        if (antwoord.equalsIgnoreCase("B")) {
            System.out.println("✅ Correct! De doelen zijn gekozen en ingeschat.");
        } else {
            System.out.println("❌ Fout. Sprint Planning draait om doelen kiezen en werk inschatten.");
        }
    }

    @Override
    public String getNaam() {
        return naam;
    }
}