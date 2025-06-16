package Spel;

import Hint.Hint;
import Hint.HintFactory;
import Kamer.Kamer;
import Opdracht.Joker;
import monster.MonsterBasis;
import voorwerp.Weapon;


import java.util.Map;
import java.util.Scanner;

public class KamerCommando {

    private final Map<Integer, Kamer> kamers;
    private final Map<Integer, Deur> deuren;
    private final SpelerService spelerService;
    private final Scanner scanner;
    private final Map<Integer, MonsterBasis> monsters;
    private final Joker gekozenJoker;

    public KamerCommando(Map<Integer, Kamer> kamers,
                         Map<Integer, Deur> deuren,
                         SpelerService spelerService,
                         Scanner scanner,
                         Map<Integer, MonsterBasis> monsters,
                         Joker gekozenJoker) {
        this.kamers = kamers;
        this.deuren = deuren;
        this.spelerService = spelerService;
        this.scanner = scanner;
        this.monsters = monsters;
        this.gekozenJoker = gekozenJoker;
    }

    /**
     * Verwerkt het invoercommando om naar een kamer te gaan.
     * @param input bijv. "ga naar kamer 2"
     * @return true als kameropdracht geslaagd is, anders false
     */
    public boolean verwerkKamerCommando(String input) {
        if (!input.startsWith("ga naar kamer")) {
            System.out.println("Onbekend commando. Typ 'help' voor opties.");
            return true;
        }

        try {
            int kamerNr = Integer.parseInt(input.replaceAll("\\D+", ""));
            if (!kamers.containsKey(kamerNr)) {
                System.out.println("Die kamer bestaat niet.");
                return false;
            }

            if (!spelerService.magNaarKamer(kamerNr)) {
                System.out.println("Je moet eerst eerdere kamer(s) halen.");
                return false;
            }

            spelerService.getSpeler().setHuidigeKamer(kamerNr);

            Kamer kamer = kamers.get(kamerNr);
            Deur deur = deuren.get(kamerNr);
            deur.toonGeslotenDeur();

            kamer.betreed();
            boolean geslaagd = kamer.start(gekozenJoker);

            if (geslaagd) {
                System.out.println("Opdracht geslaagd! Kamer " + kamerNr + " gehaald.");
                spelerService.kamerGehaald(kamerNr);
                deur.update();

                SpelStatusDatabase.slaStatusOp(
                        spelerService.getSpelerId(),
                        "Kamer " + kamerNr,
                        spelerService.getSpeler().getGehaaldeKamers().toString()
                );
                return true;
            } else {
                if (monsters.containsKey(kamerNr)) {
                    MonsterBasis monster = monsters.get(kamerNr);
                    monster.valAan();

                    Weapon wapen = spelerService.getSpeler().getWapen();
                    if (wapen != null) {
                        wapen.gebruikOp(monster);
                    } else {
                        System.out.println("Je hebt geen wapen om je te verdedigen!");
                    }
                    System.out.print("Wil je een hint? (ja/nee): ");
                    String antwoord = scanner.nextLine();
                    if (antwoord.equalsIgnoreCase("ja")) {
                        Hint hint = HintFactory.geefRandomHint(kamer.getNaam());
                        System.out.println("Hint: " + hint.getTekst());
                    }
                }
                return false;
            }

        } catch (NumberFormatException e) {
            System.out.println("Ongeldig kamernummer.");
            return false;
        }
    }
}
