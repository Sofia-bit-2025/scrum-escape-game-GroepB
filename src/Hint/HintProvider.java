package Hint;

/**
 * Deze interface wordt gebruikt voor alles wat hints kan geven.
 * Elke class die deze interface implementeert, beslist zelf hóe een hint gekozen wordt.
 * <br>Bijvoorbeeld: grappige hints, functionele tips of iets anders — zolang het maar past bij de kamer (zoals "SprintPlanning").
 * <br>De context bepaalt waar je zit, zodat je een hint krijgt die bij dat moment hoort.
 */
public interface HintProvider {

    /**
     * Levert een passende hint op basis van de context.
     * @param context Bijvoorbeeld: "ScrumBoard", "DailyScrum", enz.
     * @return een Hint object met tekst en type
     */
    Hint geefHint(String context);
}
