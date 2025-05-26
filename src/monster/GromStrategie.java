package monster;

public class GromStrategie implements AanvalsStrategie {
    @Override
    public void valAan() {
        System.out.println("▄▀                ▀▄");
        System.out.println("█▄█   █▀█  █▀█  ▄█▄█");
        System.out.println(" ▀██▄ ▀▄▀  ▀▄▀ ▄██▀");
        System.out.println("   ▄██▀███▀███▄");
        System.out.println("  ▐▀█▀██▄▄▄██▀█▀▌");
        System.out.println("Het monster gromt GRRRRR!");
    }

}
