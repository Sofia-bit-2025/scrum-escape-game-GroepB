package monster;

import Waarnemer.Waarneembaar;

public abstract class MonsterBasis extends Waarneembaar implements Monster {
    private AanvalsStrategie strategie;
    private String naam;

    public MonsterBasis(AanvalsStrategie strategie){
        this.strategie = strategie;
        this.naam = "Monster";
    }

    public void setStrategie(AanvalsStrategie strategie) {
        this.strategie = strategie;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }

    public void valAan(){
        strategie.valAan();
    }

    @Override
    public void verslaan() {
        System.out.println("BAMMM" + getNaam() + " is verslagen!");
        updateWaarnemers();
    }
}
