package Spel;

import Kamer.Kamer;
import monster.*;
import Opdracht.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class GameConsole {

    private final Scanner scanner = new Scanner(System.in);
    private final Speler speler;
    private final SpelerService spelerService;
    private final Map<Integer, Kamer> kamers;
    private final Map<Integer, Deur> deuren = new HashMap<>();
    private final SpelerStatus spelerStatus;
    private final KamerCommando kamerCommando;
    private final HelpMenu helpMenu = new HelpMenu();

    private final Map<Integer, MonsterBasis> monsters = new HashMap<>();

    private final Joker gekozenJoker;  // gekozen joker via aparte selector

    public GameConsole() {
        this.speler = new Opstart().start();
        this.spelerService = new SpelerService(speler);
        this.kamers = FactoryKamer.maakKamers();
        this.spelerStatus = new SpelerStatus(speler);

        for (int kamerNr : kamers.keySet()) {
            Deur deur = new Deur();
            deuren.put(kamerNr, deur);

            MonsterBasis monster = new ScopeCreep(StrategieFactory.maakStrategie("spring"));
            monster.voegWaarnemersToe(deur);
            monsters.put(kamerNr, monster);
        }

        // ➔ Joker kiezen vóórdat we de kamerCommando aanmaken
        JokerSelector selector = new JokerSelector(scanner);
        this.gekozenJoker = selector.kiesJoker();

        this.kamerCommando = new KamerCommando(kamers, deuren, spelerService, scanner, monsters, gekozenJoker);
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
                case "joker" -> gebruikJoker();
                default -> kamerCommando.verwerkKamerCommando(input);
            }
        }
    }

    private void gebruikJoker() {
        int kamerNr = speler.getHuidigeKamer();
        if (kamerNr == 0) {
            System.out.println("Je bevindt je niet in een kamer.");
            return;
        }

        Kamer huidigeKamer = kamers.get(kamerNr);
        if (huidigeKamer == null) {
            System.out.println("Ongeldige kamer.");
            return;
        }

        if (gekozenJoker.isAvailableFor(huidigeKamer)) {
            gekozenJoker.useIn(huidigeKamer);
        } else {
            System.out.println("De joker kan hier niet worden gebruikt of is al opgebruikt.");
        }
    }
}
