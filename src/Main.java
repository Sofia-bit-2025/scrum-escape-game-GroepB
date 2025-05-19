import Spel.DatabaseService;
import Spel.GameConsole;
import Spel.Speler;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Speler speler = null;

        System.out.println("Welkom! Heb je al een account? (ja/nee)");
        String antwoord = scanner.nextLine();

        if (antwoord.equalsIgnoreCase("nee")) {
            System.out.print("Kies een gebruikersnaam: ");
            String nieuweGebruikersnaam = scanner.nextLine();

            System.out.print("Kies een wachtwoord: ");
            String nieuwWachtwoord = scanner.nextLine();

            boolean gelukt = DatabaseService.registreerSpeler(nieuweGebruikersnaam, nieuwWachtwoord);
            if (gelukt) {
                System.out.println("Registratie gelukt. Je kunt nu inloggen.");
            } else {
                System.out.println("Registratie mislukt. Probeer opnieuw.");
                return;
            }
        }

        // Login loop
        while (speler == null) {
            System.out.print("Gebruikersnaam: ");
            String gebruikersnaam = scanner.nextLine();

            System.out.print("Wachtwoord: ");
            String wachtwoord = scanner.nextLine();

            speler = DatabaseService.login(gebruikersnaam, wachtwoord);

            if (speler == null) {
                System.out.println("Ongeldige gebruikersnaam of wachtwoord, probeer opnieuw.");
            }
        }

        // Ingelogde speler instellen
        Speler.setIngelogdeSpeler(speler);
        System.out.println("Succesvol ingelogd! Welkom speler " + speler.getSpelerId());

        GameConsole console = new GameConsole(speler);
        boolean usingApp = true;
        boolean gameStarted = false;

        System.out.println("Welkom bij het spel!");
        System.out.println("Typ 'start spel' om te beginnen.");
        System.out.println("Typ 'help' om een overzicht van alle commando's te zien.");
        System.out.println("Typ 'stop' om het spel te verlaten.\n");

        while (usingApp) {
            String input = scanner.nextLine().toLowerCase();

            switch (input) {
                case "start spel":
                    if (!gameStarted) {
                        gameStarted = true;
                        System.out.println("\n--- Spel is begonnen ---");
                        System.out.println("Typ 'help' om de beschikbare commando's te zien.");
                        System.out.println("Je staat voor een mysterieuze deur: 'Kamer 1'.");
                        System.out.println("Typ 'ga naar kamer 1' om naar binnen te gaan.");
                        console.start();
                    } else {
                        System.out.println("Het spel is al gestart.");
                    }
                    break;

                case "help":
                    System.out.println("\n--- Beschikbare commando's ---");
                    System.out.println("start spel   -> Start het spel");
                    System.out.println("status       -> Bekijk je voortgang");
                    System.out.println("stop         -> Sluit het spel af");
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
