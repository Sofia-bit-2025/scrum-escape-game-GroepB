package Opdracht;

import Kamer.Kamer;

public interface Joker {
    boolean isAvailableFor(Kamer kamer);
    void useIn(Kamer kamer);
    boolean isUsed();
}
