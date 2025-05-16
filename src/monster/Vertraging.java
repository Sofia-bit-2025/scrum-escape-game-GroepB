package monster;

/**
 * Vertraging is een monster dat optreedt wanneer de voortgang stagneert.
 * Bijvoorbeeld door slechte communicatie of onverwachte obstakels.
 */
public class Vertraging implements Monster {
    private final String naam = "Vertraging";
    private final String effect = "Het team is vertraagd door slechte communicatie.";

    @Override
    public String getNaam() {
        return naam;
    }

    @Override
    public String getEffect() {
        return effect;
    }

    @Override
    public void verslaan() {
        System.out.println("Je hebt het monster " + naam + " verslagen!");
        System.out.println("De samenwerking in het team is verbeterd.");
    }


}
