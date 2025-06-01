package Kamer;

import Opdracht.OpdrachtStrategy;

/**
 * Dit is de laatste kamer van het spel – de grote afsluiter.
 * Hier test je of je echt hebt begrepen hoe Scrum werkt, vooral waarom het iteratief is.
 * <br>Perfect om alles wat je geleerd hebt samen te brengen.
 */
public class TiaFinaleKamer extends BasisKamer {


    //Deze constructor maakt de laatste kamer van het spel aan
    //geeft een vaste naam en instructie mee
    //zorgt dat de juiste opdrachtstrategie uitgevoerd wordt wanneer de speler deze eindronde ingaat.
    public TiaFinaleKamer(OpdrachtStrategy opdracht) {
        super("TiaFinaleKamer", "Beantwoord finale vragen over Scrum.", opdracht);
    }
}
