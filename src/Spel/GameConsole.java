    package Spel;

    import Kamer.*;

    import java.util.Map;
    import java.util.Scanner;

    public class GameConsole {
        private final Scanner scanner = new Scanner(System.in);
        private final Speler speler;

        private final Map<Integer, Kamer> kamers = Map.of(
                1, new SprintPlanning(),
                2, new ScrumBoard(),
                3, new ScrumDaily(),
                4, new SprintReview(),
                5, new TiaFinaleKamer()
        );

        public GameConsole(Speler speler) {
            this.speler = speler;
        }

        public void start() {
            System.out.println("Welkom bij Scrum Escape Game!");
            toonHelpMenu();

            while (true) {
                System.out.print("\n> ");
                String input = scanner.nextLine().toLowerCase();

                switch (input) {
                    case "help" -> toonHelpMenu();
                    case "status" -> {
                        speler.toonHuidigeKamer();
                        speler.toonGehaaldeKamers();
                    }
                    case "stop" -> {
                        System.out.println("Tot de volgende keer!");
                        return;
                    }
                    default -> verwerkKamerCommando(input);
                }
            }
        }

        private void verwerkKamerCommando(String input) {
            if (input.startsWith("ga naar kamer")) {
                try {
                    int nummer = Integer.parseInt(input.replaceAll("\\D+", ""));
                    if (!kamers.containsKey(nummer)) {
                        System.out.println("Die kamer bestaat niet.");
                        return;
                    }
                    if (!speler.magNaarKamer(nummer)) {
                        System.out.println("Je moet eerst eerdere kamer(s) halen.");
                        return;
                    }

                    Kamer kamer = kamers.get(nummer);
                    kamer.betreed();
                    kamer.actieUitvoeren();
                    speler.kamerGehaald(nummer);

                    SpelStatusDatabase.slaStatusOp(
                            speler.getSpelerId(),
                            "Kamer " + nummer,
                            speler.getGehaaldeKamersString()
                    );

                } catch (NumberFormatException e) {
                    System.out.println("Ongeldig kamernummer.");
                }
            }
        }

        private void toonHelpMenu() {
            System.out.println("\n--- Beschikbare commando's ---");
            System.out.println("ga naar kamer [nummer]");
            System.out.println("status");
            System.out.println("help");
            System.out.println("stop");
        }
    }
