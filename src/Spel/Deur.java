package Spel;

import Waarnemer.Waarnemer;

public class Deur implements Waarnemer {
    private boolean open = false;
    private static int kamerTeller = 1;
    private final int kamerNummer;

    public Deur() {
        this.kamerNummer = kamerTeller++;
    }

    @Override
    public void update() {
        open = true;
        toonOpenDeur();
    }

    public boolean isOpen() {
        return open;
    }

    public void toonGeslotenDeur(){

        System.out.println("+------------------------------------------------+");
        System.out.println("|                                                |");
        System.out.println("|                    ----------                  |");
        System.out.println("|                    |        |                  |");
        System.out.println("|                    |   O    |                  |");
        System.out.println("|                    |        |                  |");
        System.out.println("|--------------------|--------|------------------|");
        System.out.println("\n[DEUR STATUS] De deur is.... GESLOTEN\n");
    }

    public void toonOpenDeur(){

        System.out.println("+------------------------------------------------+");
        System.out.println("|                                                |");
        System.out.println("|                    --- |------                 |");
        System.out.println("|                    |   |     |                 |");
        System.out.println("|                    |   |  o  |                 |");
        System.out.println("|                    |   |     |                 |");
        System.out.println("|--------------------|   |-----|-----------------|");
        System.out.println("\n[DEUR STATUS] De deur is... OPEN\n");
    }


}
