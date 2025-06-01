package Hint;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Deze klasse geeft je een grappige hint op basis van waar je bent in het spel.
 * Hij zoekt eerst naar grappen die passen bij de naam van de kamer (bijv. "SprintPlanning").
 * <br>Vindt hij niks? Dan krijg je gewoon een algemene mop over Scrum.
 * Handig voor wat humor tijdens het spelen, en hij gebruikt een filter om alleen relevante hints te tonen.
 */


//Eerst filtert hij op wat past bij de kamer,
// anders neemt hij een algemene grap, en dan kiest hij er willekeurig één uit.
public class FunnyHintProvider implements HintProvider {

    private static final Random random = new Random();
    private static final String TYPE = "Funny";

    //een vaste lijst met grappige hints.
    // Elke hint begint met een contextnaam
    //gevolgd door een mop of opmerking
    //Zo weet het systeem later welke hint bij welke kamer hoort
    private final List<String> hints = List.of(
            "ScrumBoard: Je hebt 'Doing' gehoord, maar doet nog niks.",
            "DailyScrum: Je bent niet op een Daily Scrum, je bent op een dagdroom.",
            "SprintPlanning: Alles in de backlog plannen? Rustig aan, held!",
            "SprintReview: Review zonder discussie? Je hebt gewoon een PowerPointshow gedaan.",
            "TiaFinaleKamer: Als je dit verpest, noemen we het een retrospectieve oefening.",
            "Algemeen: Een fout is gewoon een user story met een twist."
    );

    //bewaart een filterstrategie die bepaalt welke hints wel of niet getoond mogen worden
    private final HintFilterStrategy filter;

    //Deze constructor geeft het filter door dat later gebruikt wordt om passende hints te kiezen.
    public FunnyHintProvider(HintFilterStrategy filter) {
        this.filter = filter;
    }


    //Deze methode zoekt alle hints die passen bij de kamer (context)
    //checkt per hint of die begint met de naam van de kamer
    @Override
    public Hint geefHint(String context) {
        List<String> gefilterd = hints.stream()
                .filter(h -> filter.accepteert(h, context))
                .collect(Collectors.toList());



        //Als er geen hints zijn die passen bij de kamer, dan pakt hij een algemene hint als backup.
        //Zo krijg je altijd iets te zien
        if (gefilterd.isEmpty()) {
            gefilterd = hints.stream()
                    .filter(h -> h.startsWith("Algemeen:"))
                    .collect(Collectors.toList());
        }


        //Als zelfs geen algemene hints beschikbaar zijn, gooit hij een foutmelding.
        //Zo weet je meteen dat er iets mis is met de hints of de context
        if (gefilterd.isEmpty()) {
            throw new IllegalStateException("Geen hints beschikbaar voor context: " + context);
        }



        //Hier kiest hij willekeurig één hint uit de gefilterde lijst.
        //Daarna knipt hij het stukje vóór de :weg zodat je alleen de echte hinttekst ziet.
        //Die tekst stopt hij samen met het type "Funny" in een nieuw Hint object.
        String gekozen = gefilterd.get(random.nextInt(gefilterd.size()));
        String tekst = gekozen.substring(gekozen.indexOf(":") + 1).trim();
        return new Hint(tekst, TYPE);
    }
}
