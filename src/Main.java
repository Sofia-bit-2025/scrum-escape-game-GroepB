import Spel.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Opstart opstart = new Opstart();
        Speler speler = opstart.start();
        new GameConsole(speler).start();
    }
}
