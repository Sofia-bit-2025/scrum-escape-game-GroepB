package voorwerp;

public class Beloning implements Rewardable {
    private String boodschap;

    public Beloning(String boodschap) {
        this.boodschap = boodschap;
    }

    @Override
    public void reward() {
        System.out.println(boodschap);
        System.out.println("snoepje!");
    }
}
