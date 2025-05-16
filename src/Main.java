import Spel.DatabaseService;
import Spel.GameConsole;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean usingApp = true;
        boolean gameStarted = false;

        GameConsole console = new GameConsole();

        System.out.println("Welkom bij het spel!");
        System.out.println("Typ 'help' om een overzicht van alle commando's te zien.");
        System.out.println("Typ 'stop' om het spel te verlaten.\n");



        while (usingApp) {
            if (gameStarted) {
                System.out.println("\nMaak een keuze:");
                System.out.println("Help - Voer 'help' in om de beschikbare commando's te zien");
                System.out.println("Stop - Voer 'stop' in om het programma te beëindigen");
            }

            String input = scanner.nextLine().toLowerCase();

            switch (input) {
                case "start spel":
                    if (!gameStarted) {
                        System.out.println("\n--- Spel is begonnen ---");
                        System.out.println("Typ 'help' om de beschikbare commando's te zien.");
                        System.out.println("Je staat voor een mysterieuze deur: 'Kamer 1'.");
                        System.out.println("Typ 'ga naar kamer 1' om naar binnen te gaan.");
                        gameStarted = true;   // Zet dit vóór console.start()
                        console.start();
                    } else {
                        System.out.println("Het spel is al gestart.");
                    }
                    break;

                case "help":
                    System.out.println("Hier vind je alle beschikbare commando's:");
                    System.out.println("Status -> dit laat je huidige status zien");
                    System.out.println("Start spel -> Start het spel");
                    System.out.println("Stop -> stop het spel");
                    break;

                case "stop":
                    System.out.println("Programma wordt afgesloten...");
                    usingApp = false;
                    break;

                default:
                    System.out.println("Onbekend commando, typ 'help' voor een overzicht.");
                    break;
            }
        }

        scanner.close();
    }
}
