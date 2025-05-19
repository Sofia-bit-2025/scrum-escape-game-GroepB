//de speler leert wat een Sprint Review inhoudt:
//Het beoordelen van opgeleverd werk;
//Het evalueren van feedback van stakeholders;

package Kamer;

public class SprintReview implements Kamer {
    private final String naam;//Naam van deze kamer,
    private final String instructie;//Instructie die uitlegt wat de speler moet doen


    //Constructor die naam en instructie initialiseert.
    public SprintReview() {
        this.naam = "Sprint Review";
        this.instructie = "Beoordeel het resultaat.";
    }


    //wordt aangeroepen wanneer de speler deze kamer binnenkomt.
    // Toont naam + instructie.
    @Override
    public void betreed() {
        System.out.println("Je betreedt: " + naam);
        System.out.println(instructie);
    }



    //Roept de specifieke opdracht van deze kamer aan
    @Override
    public void actieUitvoeren() {
        System.out.println("Evalueer de feedback van stakeholders");
    }


    //Retourneert de kamernaam voor gebrui
    @Override
    public String getNaam() {
        return naam;
    }
}
