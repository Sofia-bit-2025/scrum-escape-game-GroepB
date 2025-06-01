package Kamer;

import Opdracht.OpdrachtStrategy;


/**
 * Een kamer waarin je terugkijkt op wat het team in de sprint heeft gedaan.
 * Je beoordeelt hier het resultaat, bespreekt wat goed ging, en verwerkt feedback van stakeholders.
 * <br>De opdracht is flexibel via een strategie meegegeven.
 */
public class SprintReview extends BasisKamer {



    //Deze constructor maakt een SprintReview kamer aan.
    // Hij geeft de kamer een vaste naam en instructie
    //en koppelt een specifieke opdrachtstrategie eraan
    public SprintReview(OpdrachtStrategy opdracht) {
        super("SprintReview", "Beoordeel het resultaat.", opdracht);
    }
}
