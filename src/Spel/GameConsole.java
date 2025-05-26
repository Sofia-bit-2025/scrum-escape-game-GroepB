package Spel;

import Kamer.Kamer;
import Opdracht.HintJoker;

import java.util.Map;
import java.util.Scanner;

public class GameConsole {
    private final Scanner scanner = new Scanner(System.in);
    private final SpelerService spelerService;
    private final Map<Integer, Kamer> kamers;
    private final SpelerStatus spelerStatus;
    private final HelpMenu helpMenu = new HelpMenu();
    private final KamerCommando kamerCommando;
    HintJoker hintJoker = new HintJoker();

    public GameConsole(Speler speler) {
        this.spelerService = new SpelerService(speler);
        this.kamers = FactoryKamer.maakKamers();
        this.spelerStatus = new SpelerStatus(speler);
        this.kamerCommando = new KamerCommando(kamers, spelerService, scanner);
    }

    public void start() {
        System.out.println("Welkom bij Scrum Escape Game!");
        helpMenu.toonHelpMenu();

        while (true) {
            System.out.print("\n> ");
            String input = scanner.nextLine().toLowerCase();

            switch (input) {
                case "help" -> helpMenu.toonHelpMenu();
                case "status" -> {
                    spelerStatus.toonStatus();
                }
                case "stop" -> {
                    System.out.println("Tot de volgende keer!");
                    return;
                }
                default -> kamerCommando.verwerkKamerCommando(input);
            }
        }
    }
}