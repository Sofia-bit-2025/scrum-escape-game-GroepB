package Opdracht;

/**
 * Interface voor opdrachten die je in een kamer uitvoert.
 * Maakt het mogelijk om verschillende soorten opdrachten flexibel toe te passen.
 * <br>Elke kamer kiest zelf welke opdrachtstrategie erbij hoort.
 * <br>Past het Strategy Pattern toe: je kunt makkelijk nieuwe soorten opdrachten toevoegen zonder iets aan te passen.
 */
public interface OpdrachtStrategy {


    //Deze methode (voerUit) wordt gebruikt om een opdracht uit te voeren.
    //Als je dit aanroept, laat hij bijv. een vraag zien,
    boolean voerUit();
}
