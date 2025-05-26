package monster;

public class ScopeCreep extends MonsterBasis {

    public ScopeCreep(AanvalsStrategie strategie) {
        super(strategie);
    }

    @Override
    public String getNaam() {
        return "Scope Creep";
    }

    @Override
    public String getEffect() {
        return "Je hebt te veel werk gepland.";
    }
}
