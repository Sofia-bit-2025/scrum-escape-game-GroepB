package Test;

import Spel.Speler;

public class speler {
    private static Speler loggedInUser = null;

    public static Speler getLoggedInUser() {
        return loggedInUser;
    }

    public static void setLoggedInUser(Speler speler) {
        loggedInUser = speler;
    }

    public static void logout() {
        loggedInUser = null;
    }
}