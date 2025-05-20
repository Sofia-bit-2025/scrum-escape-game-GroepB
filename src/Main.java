import Spel.*;

import java.util.Scanner;
import Kamer.*;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Speler speler = null;

        System.out.println("Welkom bij Scrum Escape Game!");

        while (speler == null) {
            System.out.print("1. Login\n2. Registreren\nKies (1/2): ");
            String keuze = scanner.nextLine();

            System.out.print("Gebruikersnaam: ");
            String gebruikersnaam = scanner.nextLine();
            System.out.print("Wachtwoord: ");
            String wachtwoord = scanner.nextLine();

            switch (keuze) {
                case "1":
                    speler = AuthService.login(gebruikersnaam, wachtwoord);
                    if (speler == null) {
                        System.out.println("Ongeldige gegevens. Probeer opnieuw.\n");
                    }
                    break;
                case "2":
                    boolean gelukt = AuthService.registreer(gebruikersnaam, wachtwoord);
                    if (gelukt) {
                        speler = AuthService.login(gebruikersnaam, wachtwoord);
                    } else {
                        System.out.println("Registratie mislukt. Probeer opnieuw.\n");
                    }
                    break;
                default:
                    System.out.println("Ongeldige keuze. Kies 1 of 2.\n");
                    break;
            }
        }

        System.out.println("Succesvol ingelogd als: " + speler.getGebruikersnaam());

        new GameConsole(speler).start();
    }
}
