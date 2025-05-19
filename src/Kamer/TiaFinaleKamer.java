package Kamer;
import java.util.Scanner;

public class TiaFinaleKamer implements Kamer {
    private final String naam = "Finale Kamer: TIA";
    private final String instructie = "Beantwoord de eindvraag over Scrum.";

    @Override
    public void betreed() {
        System.out.println("Je betreedt: " + naam);
        System.out.println(instructie);
    }

    @Override
    public void actieUitvoeren() {
        System.out.println("Wat is het hoofddoel van Scrum?");
        System.out.println("A) Alles documenteren\nB) Waarde leveren via iteraties\nC) De klant betrekken in design");
        Scanner scanner = new Scanner(System.in);
        String antwoord = scanner.nextLine();
        if (antwoord.equalsIgnoreCase("B")) {
            System.out.println("✅ Correct! Scrum draait om iteratief waarde leveren.");
        } else {
            System.out.println("❌ Fout. Scrum is iteratief en klantgericht, maar draait primair om waarde leveren.");
        }
    }

    @Override
    public String getNaam() {
        return naam;
    }
}
