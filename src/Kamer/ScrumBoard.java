package Kamer;

import Opdracht.OpdrachtStrategy;

/**
 * Een kamer waar je leert hoe een Scrum Board werkt.
 * Je ziet hier een korte uitleg over het bord (To Do, Doing, Done),
 * en voert daarna een opdracht uit die daarbij hoort.
 * <br>De opdracht zelf wordt los meegegeven via een strategie, dus je kunt dit makkelijk aanpassen of testen.
 */
public class ScrumBoard extends BasisKamer {


    //Deze constructor maakt een ScrumBoard kamer aan met een bijbehorende opdrachtstrategie
    public ScrumBoard(OpdrachtStrategy opdracht) {
        super("ScrumBoard", "Richt het bord in met taken en user stories.", opdracht);
    }
}
