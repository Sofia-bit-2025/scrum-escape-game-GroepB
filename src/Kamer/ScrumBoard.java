//de speler leert wat een Scrum Board is,
//oefent met het juist indelen van taken op dat bord
//voortgang maakt binnen het spel als de opdracht correct wordt uitgevoerd
package Kamer;

        import java.util.Scanner;

public class ScrumBoard implements Kamer {
    private final String naam = "Scrum Board";
    private final String instructie = "Richt het bord in met taken en user stories.";

    @Override
    public void betreed() {
        System.out.println("Je betreedt: " + naam);
        System.out.println(instructie);
    }

    @Override
    public void actieUitvoeren() {
        System.out.println("Welke taak hoort bij 'Done'?");
        System.out.println("A) Taken die moeten worden gestart\nB) Taken die klaar zijn\nC) Taken die wachten op review");
        Scanner scanner = new Scanner(System.in);
        String antwoord = scanner.nextLine();
        if (antwoord.equalsIgnoreCase("B")) {
            System.out.println("✅ Correct! Taken in 'Done' zijn afgerond.");
        } else {
            System.out.println("❌ Fout. 'Done' betekent klaar.");
        }
    }

    @Override
    public String getNaam() {
        return naam;
    }
}
