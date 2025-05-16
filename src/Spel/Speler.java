package Spel;

import monster.Monster;

import java.util.*;

public class Speler {

    private int huidigeKamer = 0; // De huidige kamer waarin de speler zich bevindt
    private final Set<Integer> voltooideKamers = new HashSet<>(); // Kamers die al gehaald zijn
    private final List<Monster> actieveMonsters = new ArrayList<>(); // Monsters die actief zijn (fouten of obstakels)

    // Wordt aangeroepen als een kamer succesvol is voltooid
    public void kamerGehaald(int kamerNummer) {
        voltooideKamers.add(kamerNummer);
        huidigeKamer = kamerNummer;
    }

    // Controleert of speler naar de volgende kamer mag
    public boolean magNaarKamer(int kamerNummer) {
        return kamerNummer == 1 || voltooideKamers.contains(kamerNummer - 1);
    }

    // Voeg een actief monster toe na een fout antwoord
    public void voegMonsterToe(Monster monster) {
        actieveMonsters.add(monster);
    }

    // Print de huidige status naar de CLI
    public void toonStatus() {
        System.out.println("Je bent nu bij kamer: " + huidigeKamer);
        System.out.println(" Kamers gehaald: " + voltooideKamers);

        if (actieveMonsters.isEmpty()) {
            System.out.println("Geen actieve monsters.");
        } else {
            System.out.println("Actieve monsters:");
            for (Monster monster : actieveMonsters) {
                System.out.println("- " + monster.getNaam());
            }
        }
    }
}
