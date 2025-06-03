package Opdracht;

import Kamer.Kamer;

public class HintJoker implements Joker {
    private boolean used = false;

    @Override
    public boolean isAvailableFor(Kamer kamer) {
        return !used; // altijd beschikbaar zolang niet gebruikt
    }

    @Override
    public void useIn(Kamer kamer) {
        if (used) return;
        System.out.println("Hint voor kamer " + kamer.getNaam() + ": Let goed op de opdrachtinstructies!");
        used = true;
    }

    @Override
    public boolean isUsed() {
        return used;
    }
}
