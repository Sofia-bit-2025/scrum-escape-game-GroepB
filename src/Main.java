import java.util.Scanner;
import Spel.GameConsole;


public class Main {
    public static void main(String[] args) {

        DatabaseService.maakVerbinding();


        Scanner scanner = new Scanner(System.in);
        boolean usingApp = true;
        boolean gameStarted = false;

        GameConsole console = new GameConsole();


        while (usingApp) {
            if (gameStarted) {
                System.out.println("\nMaak een keuze:");
                System.out.println("Help - Voer 'help' in om de beschikbare commando's te zien");
                System.out.println("Stop - Voer 'stop' in om het programma te beëindigen");

            } else {
                System.out.println("\nMaak een keuze:");
                System.out.println("Help - Voer 'help' in om de beschikbare commando's te zien");
                System.out.println("Start Spel - Voer 'start spel' in om het spel te starten");
                System.out.println("Stop - Voer 'stop' in om het programma te beëindigen");
            }


            String input = scanner.nextLine().toLowerCase();

            switch (input) {
                case "help":
                    System.out.println("Hier vind je alle beschikbare commando's:");
                    System.out.println("Status -> dit laat je huidige status zien");
                    System.out.println("Ga naar kamer <nummer> -> ga naar een specifieke kamer");
                    System.out.println("Stop -> stop het spel");
                    break;
                case "start spel":
                    if (!gameStarted) {
                        System.out.println("\n--- Spel is begonnen ---");
                        System.out.println("Typ 'help' om de beschikbare commando's te zien.");
                        System.out.println("Je staat voor een mysterieuze deur: 'Kamer 1'.");
                        System.out.println("Typ 'ga naar kamer 1' om naar binnen te gaan.");
                        console.start();
                        gameStarted = true;
                    }
                    //start het spel
                    break;


                case "stop":
                    System.out.println("Programma wordt afgesloten...");
                    usingApp = false;
                    break;

            }
        }

        scanner.close();
    }
}
