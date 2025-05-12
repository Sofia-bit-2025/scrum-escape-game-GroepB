package Opdracht;


public class ScrumDailyOpdracht implements OpdrachtStrategy {
    @Override
    public void voerUit() {
        System.out.println("Opdracht: Geef aan wat elk teamlid gisteren gedaan heeft, vandaag gaat doen en of er blokkades zijn.");
    }
}
