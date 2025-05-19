import Spel.AuthService;
import Spel.DatabaseService;
import Spel.GameConsole;
import Spel.Speler;


import java.util.Scanner;

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

            if (keuze.equals("1")) {
                speler = AuthService.login(gebruikersnaam, wachtwoord);
                if (speler == null) {
                    System.out.println("Ongeldige gegevens. Probeer opnieuw.\n");
                }
            } else if (keuze.equals("2")) {
                boolean gelukt = AuthService.registreer(gebruikersnaam, wachtwoord);
                if (gelukt) {
                    speler = AuthService.login(gebruikersnaam, wachtwoord);
                } else {
                    System.out.println("Registratie mislukt. Probeer opnieuw.\n");
                }
            }
        }

        System.out.println("Succesvol ingelogd als: " + speler.getGebruikersnaam());
        new GameConsole(speler).start();
    }
}
