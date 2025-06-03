package Opdracht;

import Kamer.Kamer;
import java.util.Set;

public class KeyJoker implements Joker {
    private boolean used = false;
    private static final Set<String> TOEGESTANE_KAMERS = Set.of("Daily Scrum", "Review");

    @Override
    public boolean isAvailableFor(Kamer kamer) {
        return !used && TOEGESTANE_KAMERS.contains(kamer.getNaam());
    }

    @Override
    public void useIn(Kamer kamer) {
        if (used) return;
        System.out.println("Sleutel gebruikt in kamer " + kamer.getNaam() + "! Je ontgrendelt een speciale toegang.");
        used = true;
    }

    @Override
    public boolean isUsed() {
        return used;
    }
}
