package Kamer;

import Opdracht.OpdrachtStrategy;

/**
 * Een kamer waarin je leert hoe je een sprint moet plannen.
 * Hier ontdek je hoe je als team keuzes maakt over wat haalbaar is binnen de sprinttijd.
 * <br>De opdracht wordt via een strategie meegegeven, zodat je dit flexibel kunt aanpassen.
 */
public class SprintPlanning extends BasisKamer {


    //Deze constructor maakt een SprintPlanning-kamer aan.
    // Hij stelt de naam in als SprintPlanning  en geeft een instructie mee.
    public SprintPlanning(OpdrachtStrategy opdracht) {
        super("SprintPlanning", "Plan de sprint.", opdracht);
    }
}
