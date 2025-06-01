package Spel;

import Kamer.Kamer;
import monster.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Hoofdklasse voor de Scrum Escape Game CLI.
 * Stuurt login, kamerlogica, hints, monsters, deuren en spelerstatus aan.
 */
public class GameConsole1 {
    private final Scanner scanner = new Scanner(System.in);
    private final Speler speler;
    private final SpelerService spelerService;
    private final Map<Integer, Kamer> kamers;
    private final Map<Integer, Deur> deuren = new HashMap<>();
    private final SpelerStatus spelerStatus;
    private final KamerCommando kamerCommando;
    private final HelpMenu helpMenu = new HelpMenu();

    // Monsters per kamer  gekoppeld aan fout gedrag
    private final Map<Integer, Monster> monsters = new HashMap<>();

    public GameConsole1() {
        this.speler = new Opstart().start(); // login of registratie
        this.spelerService = new SpelerService(speler);
        this.kamers = FactoryKamer.maakKamers();
        this.spelerStatus = new SpelerStatus(speler);

        // Maak deuren en monsters per kamer
        for (int kamerNr : kamers.keySet()) {
            Deur deur = new Deur();
            deuren.put(kamerNr, deur);

            // Monster koppelen (per kamer)
            Monster monster = new ScopeCreep(StrategieFactory.maakStrategie("spring"));
            monsters.put(kamerNr, monster);

            // Koppel deur als waarnemer aan monster
            if (monster instanceof MonsterBasis m) {
                m.voegWaarnemersToe(deur);
                // Observer pattern
            }
        }

        this.kamerCommando = new KamerCommando(kamers, deuren, spelerService, scanner);
    }

    public void start() {
        System.out.println("\nWelkom bij SCRUM ESCAPE: De Kameruitdaging!");
        helpMenu.toonHelpMenu();

        while (true) {
            System.out.print("\n> ");
            String input = scanner.nextLine().trim().toLowerCase();

            switch (input) {
                case "stop" -> {
                    System.out.println("Spel afgesloten. Tot de volgende sprint!");
                    return;
                }
                case "help" -> helpMenu.toonHelpMenu();
                case "status" -> spelerStatus.toonStatus();
                default -> {
                    if (input.startsWith("ga naar kamer")) {
                        int kamerNr = haalKamernummerUitInput(input);
                        if (kamerNr != -1) {
                            boolean succes = verwerkKamer(kamerNr);
                            if (!succes) {
                                activeerMonster(kamerNr);
                            }
                        }
                    } else {
                        System.out.println("Onbekend commando. Typ 'help' voor beschikbare opties.");
                    }
                }
            }
        }
    }

    private int haalKamernummerUitInput(String input) {
        try {
            return Integer.parseInt(input.replaceAll("\\D+", ""));
        } catch (NumberFormatException e) {
            System.out.println("Ongeldige invoer. Gebruik: 'ga naar kamer [nummer]'.");
            return -1;
        }
    }

    private boolean verwerkKamer(int nummer) {
        if (!kamers.containsKey(nummer)) {
            System.out.println("Kamer " + nummer + " bestaat niet.");
            return false;
        }
        if (!spelerService.magNaarKamer(nummer)) {
            System.out.println("Je moet eerst eerdere kamers voltooien.");
            return false;
        }

        Kamer kamer = kamers.get(nummer);
        Deur deur = deuren.get(nummer);

        deur.toonGeslotenDeur();
        kamer.betreed();
        boolean gelukt = kamer.start();

        if (gelukt) {
            spelerService.kamerGehaald(nummer);
            deur.update();

            SpelStatusDatabase.slaStatusOp(
                    speler.getSpelerId(),
                    "Kamer " + nummer,
                    speler.getGehaaldeKamers().toString()
            );

            System.out.println("Kamer " + nummer + " is behaald!");
        } else {
            System.out.println("Opdracht niet geslaagd.");
        }

        return gelukt;
    }

    private void activeerMonster(int kamerNr) {
        Monster monster = monsters.get(kamerNr);
        if (monster != null && monster instanceof MonsterBasis m) {
            m.valAan(); // Toon animatie
        }
    }

    public static void main(String[] args) {
        new GameConsole1().start();
    }

}
