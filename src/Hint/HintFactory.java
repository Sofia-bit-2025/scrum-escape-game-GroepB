package Hint;

import java.util.*;

/**
 * HintFactory maakt willekeurige HintProviders aan op basis van het Factory Pattern.
 * Ondersteunt SOLID via DIP, open/closed voor uitbreiding, en strategie-injectie via filters.
 */



//regelt het kiezen van een hint.
    //providers: een lijst met alle beschikbare hintleveranciers
    //random: wordt gebruikt om later willekeurig een van die providers te kiezen.
public class HintFactory {
    private static final List<HintProvider> providers = new ArrayList<>();
    private static final Random random = new Random();



    //Dit is de standaardfilter die bepaalt welke hints passen bij een kamer.
    private static HintFilterStrategy standaardFilter = new ContextPrefixFilter();


    //Dit stuk code wordt automatisch uitgevoerd als de HintFactory wordt geladen.
    //Hier worden twee hintleveranciers toegevoegd aan de lijst.
    //Ze gebruiken allebei de standaardfilter zodat de hints context specifiek zijn
    static {
        registreerProvider(new HelpHintProvider(standaardFilter));
        registreerProvider(new FunnyHintProvider(standaardFilter));
    }


    //Deze methode geeft een willekeurige hint terug, gebaseerd op de context
    //Eerst checkt hij of er überhaupt hintproviders zijn
    //als de lijst leeg is, gooit hij een fout.
    public static Hint geefRandomHint(String context) {
        if (providers.isEmpty()) {
            throw new IllegalStateException("Geen hintproviders geregistreerd.");
        }


        //checkt of de context die je meegeeft wel bestaat.
        //Als het null of leeg is, gooit hij een foutmelding
        if (context == null || context.isBlank()) {
            throw new IllegalArgumentException("Context mag niet null of leeg zijn.");
        }


        //kiezen willekeurig één hintprovider uit de lijst
        //en vragen die om een hint te geven die past bij de meegegeven context
        HintProvider provider = providers.get(random.nextInt(providers.size()));
        return provider.geefHint(context);
    }



    //Deze methode voegt een hintprovider toe aan de lijst van beschikbare providers
    //alleen als die niet null is.
    public static void registreerProvider(HintProvider provider) {
        if (provider == null) return;
        providers.add(provider);
    }


    //Deze methode vervangt de huidige lijst van hintproviders met een nieuwe lijst.
    //Eerst maakt hij de lijst leeg, en als je een nieuwe lijst meegeeft, voegt hij die toe
    public static void resetProviders(List<HintProvider> customProviders) {
        providers.clear();
        if (customProviders != null) {
            providers.addAll(customProviders);
        }
    }


    //Geeft een niet-aanpasbare read-only versie terug van alle geregistreerde hintproviders
    //Zo kun je wel zien wat er actief is, maar je kunt de originele lijst niet per ongeluk veranderen
    public static List<HintProvider> getGeregistreerdeProviders() {
        return Collections.unmodifiableList(providers);
    }

    //Stelt een nieuwe standaard filterstrategie in voor het selecteren van hints.
    //Als je een andere manier wilt gebruiken om hints te filteren
    //kun je dat hiermee instellen — zolang de meegegeven filter niet null is
    public static void setStandaardFilter(HintFilterStrategy filter) {
        if (filter != null) {
            standaardFilter = filter;
        }
    }



    //Geeft de standaard filterstrategie terug die wordt gebruikt om hints te selecteren.
    //als je wilt weten of aanpassen welke logica nu actief is voor het filteren van hints
    public static HintFilterStrategy getStandaardFilter() {
        return standaardFilter;
    }
}
