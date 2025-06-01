package voorwerp;

public class Zwaard implements Weapon {
    private String naam;

    public Zwaard(String naam){
        this.naam = naam;
    }


    @Override
    public void attack(){

        System.out.println("      ||");
        System.out.println("O|@@@|* >=============>>");
        System.out.println("      ||");
        System.out.println(naam + "chop chop!");

    }
}
