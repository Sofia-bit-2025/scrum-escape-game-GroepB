package monster;

import Waarnemer.Waarneembaar;

public abstract class MonsterBasis extends Waarneembaar implements Monster {
    private AanvalsStrategie strategie;

    public MonsterBasis(AanvalsStrategie strategie){
        this.strategie = strategie;

    }

    public void setStrategie (AanvalsStrategie strategie) {
        this.strategie = strategie;
    }

    public void valAan(){
        strategie.valAan();
    }

    @Override
    public void verslaan(){
        System.out.println(getNaam()+ " is verslagen!");
        updateWaarnemers();

    }
}
