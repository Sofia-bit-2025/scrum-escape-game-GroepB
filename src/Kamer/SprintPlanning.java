package Kamer;


public class SprintPlanning implements Kamer {
    private final String naam;
    private final String instructie;

    public SprintPlanning() {
        this.naam = "Sprint Planning";
        this.instructie = "Plan wat haalbaar is in de sprint.";
    }

    @Override
    public void betreed() {
        System.out.println("Je betreedt: " + naam);
        System.out.println(instructie);
    }

    @Override
    public void actieUitvoeren() {
        System.out.println("Actie: beantwoord de vraag over inschatting van taken");
        //  logica hier toevoegen en codes uitbereiden




    }
}
