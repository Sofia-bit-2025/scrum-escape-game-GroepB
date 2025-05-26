import Spel.*;

public class Main {
    public static void main(String[] args) {
        Opstart opstart = new Opstart();

        Speler speler = opstart.start();
        new GameConsole(speler).start();
    }
}
