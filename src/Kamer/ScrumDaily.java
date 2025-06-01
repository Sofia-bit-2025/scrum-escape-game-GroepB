package Kamer;

import Opdracht.OpdrachtStrategy;

/**
 * Een kamer waar je een Daily Scrum oefent.
 * In deze kamer leer je hoe je kort vertelt wat je gedaan hebt, wat je gaat doen
 * en of je ergens tegenaan loopt.
 * <br>De opdracht wordt als strategie meegegeven, zodat het makkelijk te vervangen of te testen is.
 */
public class ScrumDaily extends BasisKamer {


    //Deze constructor maakt een ScrumDaily kamer aan met de naam DailyScrum en een vaste instructie.
    public ScrumDaily(OpdrachtStrategy opdracht) {
        super("DailyScrum", "Iedereen geeft een korte statusupdate.", opdracht);
    }
}
