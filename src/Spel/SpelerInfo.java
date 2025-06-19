package Spel;

public class SpelerInfo {
    private int spelerId;
    private String gebruikersnaam;

    public SpelerInfo(int spelerId, String gebruikersnaam) {
        this.spelerId = spelerId;
        this.gebruikersnaam = gebruikersnaam;
    }

    public int getSpelerId() {
        return spelerId;
    }

    public String getGebruikersnaam() {
        return gebruikersnaam;
    }
}
