package Opdracht;

import java.util.Scanner;

public class TiaFinaleOpdracht implements OpdrachtStrategy {
    @Override
    public void voerUit() {
        System.out.println("Finale opdracht: Waarom werkt Scrum iteratief?");
        System.out.println("A) Zodat alles tegelijk opgeleverd wordt");
        System.out.println("B) Om geleidelijk feedback te verwerken en continu te verbeteren");
        System.out.println("C) Omdat teams niet kunnen plannen");

        Scanner scanner = new Scanner(System.in);
        System.out.print("> Kies A, B of C: ");
        String antwoord = scanner.nextLine().trim().toUpperCase();

        if (antwoord.equals("B")) {
            System.out.println("Juist! Iteratief werken maakt snelle bijsturing mogelijk.");
        } else if (antwoord.equals("A") || antwoord.equals("C")) {
            System.out.println("Fout. Scrum gebruikt iteraties om steeds kleine stappen te verbeteren.");
        } else {
            System.out.println("Fout. Kies A, B of C.");
        }
    }
}
