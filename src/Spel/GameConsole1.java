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
    public static void main(String[] args) {
        new GameConsole1().start();
    }

    private final Scanner scanner = new Scanner(System.in);
    private final Speler speler;
    private final SpelerService spelerService;
    private final Map<Integer, Kamer> kamers;
    private final Map<Integer, Deur> deuren = new HashMap<>();
    private final SpelerStatus spelerStatus;
    private final KamerCommando kamerCommando;
    private final HelpMenu helpMenu = new HelpMenu();

    //  monster activeert deur na fout
    private final Map<Integer, MonsterBasis> monsters = new HashMap<>();

    public GameConsole1() {
        this.speler = new Opstart().start();
        this.spelerService = new SpelerService(speler);
        this.kamers = FactoryKamer.maakKamers();  // Elke kamer krijgt een opdracht met hint
        this.spelerStatus = new SpelerStatus(speler);

        for (int kamerNr : kamers.keySet()) {
            Deur deur = new Deur();
            deuren.put(kamerNr, deur);

            // Monster koppelen aan deur via observerpattern
            MonsterBasis monster = new ScopeCreep(StrategieFactory.maakStrategie("spring"));
            monster.voegWaarnemersToe(deur);
            monsters.put(kamerNr, monster);
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
                    boolean geslaagd = kamerCommando.verwerkKamerCommando(input);
                    if (!geslaagd) {
                        int kamerNr = haalKamernummerUitInput(input);
                        if (kamerNr != -1 && monsters.containsKey(kamerNr)) {
                            monsters.get(kamerNr).valAan(); // activeer monster bij fout
                        }
                    }
                }
            }
        }
    }

    private int haalKamernummerUitInput(String input) {
        try {
            return Integer.parseInt(input.replaceAll("\\D+", ""));
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
