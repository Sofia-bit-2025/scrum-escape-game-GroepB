package Opdracht;

import java.util.Scanner;

public class JokerSelector {
    private final Scanner scanner;

    public JokerSelector(Scanner scanner) {
        this.scanner = scanner;
    }

    public Joker kiesJoker() {
        while (true) {
            System.out.print("Kies je joker (hint / key): ");
            String keuze = scanner.nextLine().trim().toLowerCase();

            switch (keuze) {
                case "hint" -> {
                    System.out.println("Je hebt de HintJoker gekozen.");
                    return new HintJoker();
                }
                case "key" -> {
                    System.out.println("Je hebt de KeyJoker gekozen.");
                    return new KeyJoker();
                }
                default -> System.out.println("Ongeldige keuze. Kies opnieuw.");
            }
        }
    }
}
