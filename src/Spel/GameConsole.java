package Spel;

import Kamer.Kamer;
import monster.*;
import Opdracht.*;
import Kamer.BasisKamer;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import Assistent.*;

/**
 * Hoofdklasse voor de Scrum Escape Game CLI.
 * Stuurt login, kamerlogica, hints, monsters, deuren en spelerstatus aan.
 */
public class GameConsole {

    private final Scanner scanner = new Scanner(System.in);
    private final Speler speler;
    private final SpelerService spelerService;
    private final Map<Integer, Kamer> kamers;
    private final Map<Integer, Deur> deuren = new HashMap<>();
    private final SpelerStatus spelerStatus;
    private final KamerCommando kamerCommando;
    private final HelpMenu helpMenu = new HelpMenu();
    private final Joker gekozenJoker;
    private final Map<Integer, MonsterBasis> monsters = new HashMap<>();

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


        JokerSelector selector = new JokerSelector(scanner);
        this.gekozenJoker = selector.kiesJoker();


        this.kamerCommando = new KamerCommando(
                kamers,
                deuren,
                spelerService,
                scanner,
                monsters,
                gekozenJoker
        );
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
                case "assistent" -> gebruikHuidigeAssistent();
                case "joker" -> gebruikJoker();
                default -> {
                    boolean geslaagd = kamerCommando.verwerkKamerCommando(input);
                    if (!geslaagd) {
                        int kamerNr = speler.getLaatsteBezochteKamer();
                        if (kamerNr != -1 && monsters.containsKey(kamerNr)) {
                            monsters.get(kamerNr).valAan();
                        }
                    }
                }
            }
        }
    }

    private void gebruikHuidigeAssistent() {
        int huidigeKamerNr = speler.getLaatsteBezochteKamer();
        Kamer kamer = kamers.get(huidigeKamerNr);

        if (kamer instanceof BasisKamer basisKamer) {
            basisKamer.gebruikAssistent();
        } else {
            System.out.println("Deze kamer heeft geen assistentfunctie.");
        }
    }

    private void gebruikJoker() {
        int kamerNr = speler.getHuidigeKamer();
        Kamer kamer = kamers.get(kamerNr);

        if (gekozenJoker.isAvailableFor(kamer)) {
            gekozenJoker.useIn(kamer);
        } else {
            System.out.println("De joker kan hier niet worden gebruikt of is al opgebruikt.");
        }
    }
}
