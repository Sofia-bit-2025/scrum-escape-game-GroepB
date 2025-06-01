package Hint;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Deze klasse geeft je een functionele hint die écht helpt met de opdracht.
 * Hij kijkt naar de kamer waar je in zit (zoals "SprintPlanning" of "ScrumBoard")
 * en zoekt dan een hint die daarmee begint. Dat doet hij met een filterstrategie.
 * <br>Als er geen specifieke hint is voor die kamer, krijg je een algemene Scrum-tip.
 * <br>De hints zijn bedoeld om je écht op weg te helpen — dus inhoudelijk en gericht.
 */

//het begin van de HelpHintProvider-klasse
    //random wordt gebruikt om later willekeurig een hint te kiezen.
    //TYPE is gewoon een label dat meegegeven wordt aan de hint
public class HelpHintProvider implements HintProvider {

    private static final Random random = new Random();
    private static final String TYPE = "functioneel";




    //Deze lijst bevat alle beschikbare functionele hints.
    // Elke hint begint met een kamernaam
    //zodat later gefilterd kan worden op welke hints passen bij de kamer waar je in zit.
    private final List<String> hints = List.of(
            "ScrumBoard: check je kolommen: To Do, Doing, Done.",
            "DailyScrum: Gebruik de drie standaardvragen.",
            "SprintPlanning: Gebruik de velocity van het team om realistisch te plannen.",
            "SprintReview: Feedback van stakeholders hoort bij de Review.",
            "TiaFinaleKamer: Scrum is iteratief zodat je kunt bijsturen.",
            "Algemeen: Transparantie en inspectie vormen de kern van Scrum."
    );




    //Deze variabele slaat de strategie op die bepaalt welke hints passen bij een bepaalde kamer.
    private final HintFilterStrategy filter;


    //Deze constructor zorgt dat de HelpHintProvider een filter krijgt meegegeven
    // die hij later gebruikt om te checken
    // of een hint bij de juiste kamer (context) past.
    public HelpHintProvider(HintFilterStrategy filter) {
        this.filter = filter;
    }




    //Deze regel zoekt in de lijst van hints alleen de hints
    // die passen bij de opgegeven kamer (context).
    @Override
    public Hint geefHint(String context) {
        List<String> gefilterd = hints.stream()
                .filter(h -> filter.accepteert(h, context))
                .collect(Collectors.toList());



        //Als er geen hints specifiek bij de kamer passen, dan zoekt deze code naar algemene hints
        //Zo krijgt de speler toch nog iets bruikbaars, ook al is er geen match met de context
        if (gefilterd.isEmpty()) {
            gefilterd = hints.stream()
                    .filter(h -> h.startsWith("Algemeen:"))
                    .collect(Collectors.toList());
        }



        //Als er echt helemaal geen hints zijn gevonden
        // ook geen algemene dan gooit deze regel een foutmelding.
        if (gefilterd.isEmpty()) {
            throw new IllegalStateException("Geen hints beschikbaar voor context: " + context);
        }


        //Hier kiest het systeem willekeurig één hint uit de gefilterde lijst random.nextInt(...)
        //haalt de tekst ná het dubbelepunt : eruit want dat stuk is de echte hint
        String gekozen = gefilterd.get(random.nextInt(gefilterd.size()));
        String tekst = gekozen.substring(gekozen.indexOf(":") + 1).trim();
        return new Hint(tekst, TYPE);
    }
}
