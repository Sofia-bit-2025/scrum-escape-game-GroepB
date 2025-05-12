package Opdracht;

// Interface implementeren
public class ScrumBoardOpdracht implements OpdrachtStrategy {
    @Override
    public void voerUit() {
        System.out.println("Opdracht: Plaats taken in de juiste kolommen van het Scrum Board.");
        System.out.println("Bijvoorbeeld: 'Test feature' hoort bij 'doing'.");
    }
}
