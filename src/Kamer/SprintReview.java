//de speler leert wat een Sprint Review inhoudt:
//Het beoordelen van opgeleverd werk;
//Het evalueren van feedback van stakeholders;

package Kamer;
import java.util.Scanner;

public class SprintReview implements Kamer {
    private final String naam = "Sprint Review";
    private final String instructie = "Beoordeel het resultaat en verzamel feedback.";

    @Override
    public void betreed() {
        System.out.println("Je betreedt: " + naam);
        System.out.println(instructie);
    }

    @Override
    public void actieUitvoeren() {
        System.out.println("Wie neemt deel aan de Sprint Review?");
        System.out.println("A) Alleen het team\nB) Team, Scrum Master, Product Owner en stakeholders\nC) Alleen de Scrum Master");
        Scanner scanner = new Scanner(System.in);
        String antwoord = scanner.nextLine();
        if (antwoord.equalsIgnoreCase("B")) {
            System.out.println("✅ Correct! Iedereen die betrokken is komt samen.");
        } else {
            System.out.println("❌ Fout. De review is voor alle belanghebbenden.");
        }
    }

    @Override
    public String getNaam() {
        return naam;
    }
}
