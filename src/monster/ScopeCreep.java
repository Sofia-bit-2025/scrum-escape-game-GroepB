
package monster;

public class ScopeCreep implements Monster {
    private final String naam = "Scope Creep";
    private final String effect = "Je hebt te veel werk gepland.";

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
        System.out.println("Je verslaat " + naam + ": " + effect);
    }
}