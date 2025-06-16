package Spel;

import java.util.Scanner;

public class Opstart {
    private Scanner scanner = new Scanner(System.in);

    public Speler start() {
        Speler speler = null;

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

        if (!speler.isHeeftIntroGezien()){
            toonIntroVerhaal();
            speler.markeerIntroGezien();
        }

        return speler;
    }
    private void toonIntroVerhaal() {
        String[] verhaal = {
                "Welkom bij Scrum Escape! \n Je zit opgesloten in een mysterieus gebouw… maar er is een uitweg.",
                "De kamers waarin je je bevindt zijn geen gewone kamers – ze zijn gebouwd rondom de belangrijkste onderdelen van Scrum! \n Jouw missie: Doorloop alle kamers door opdrachten uit te voeren en vragen correct te beantwoorden. \n Elke kamer draait om een essentieel Scrum-element, zoals de Sprint Planning, de Daily Scrum of het Scrum Board.",
                "Let op! Een fout antwoord roept een monster op die je moet verslaan voordat je verder kunt.",
                "Je leert tijdens dit spel spelenderwijs: \n - Wat Scrum is \n - Hoe de verschillende onderdelen samenwerken \n - Wat jouw rol als teamlid kan zijn",
                "Zo speel je het spel: \n Typ het commando `ga naar kamer X` om naar een kamer te gaan. \n In elke kamer wacht een uitdaging. Typ `help` om hulp te krijgen met commando’s.",
                "Ben jij klaar om de Scrum te ontsnappen? \n Typ `start` om te beginnen..."
        };

        for (String regel : verhaal) {
            System.out.println(regel);
            scanner.nextLine();
        }
    }
}
