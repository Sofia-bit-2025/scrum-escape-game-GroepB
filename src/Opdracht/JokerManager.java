package Opdracht;

public class JokerManager {
    private static boolean hintJokerGebruikt = false;

    public static boolean magHintJoker() {
        return !hintJokerGebruikt;
    }

    public static void gebruikHint(String hinttekst) {
        if (!hintJokerGebruikt) {
            System.out.println("Hint: " + hinttekst);
            hintJokerGebruikt = true;
        } else {
            System.out.println("Je hebt de HintJoker al gebruikt.");
        }
    }
}
