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

    // Monsters per kamer ..
    private final Map<Integer, MonsterBasis> monsters = new HashMap<>();

    public GameConsole1() {
        this.speler = new Opstart().start();
        this.spelerService = new SpelerService(speler);
        this.kamers = FactoryKamer.maakKamers();
        this.spelerStatus = new SpelerStatus(speler);

        for (int kamerNr : kamers.keySet()) {
            Deur deur = new Deur();
            deuren.put(kamerNr, deur);

            // alleen MonsterBasis gebruiken
            MonsterBasis monster = new ScopeCreep(StrategieFactory.maakStrategie("spring"));
            monsters.put(kamerNr, monster);

            // koppel deur als waarnemer aan monster
            monster.voegWaarnemersToe(deur);
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
                default -> kamerCommando.verwerkKamerCommando(input);
            }
        }
    }

    public static void main(String[] args) {
        new GameConsole1().start();
    }
}
