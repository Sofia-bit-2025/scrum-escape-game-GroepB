package Hint;

import java.util.List;
import java.util.Random;

/**
 * HintFactory bepaalt op willekeurige wijze welke concrete HintProvider gekozen wordt.
 * Dit is een toepassing van het Factory Pattern met het Dependency Inversion Principle (DIP).
 * Kamers en opdrachten zijn alleen afhankelijk van de HintProvider-interface.
 */
public class HintFactory {

    private static final List<HintProvider> providers = List.of(
            new HelpHintProvider(),
            new FunnyHintProvider()
    );

    private static final Random random = new Random();

    /**
     * Haalt een hint op die past bij de opgegeven context.
     * Hiervoor wordt willekeurig een provider gekozen, en daarbinnen een hint die de context als prefix heeft.
     *
     * @param context De naam van de kamer of spelsituatie (zoals "ScrumBoard", "SprintPlanning", ...)
     * @return Een willekeurige, contextuele hint. Als er geen passende hint is, een neutrale fallback.
     */
    public static Hint geefRandomHint(String context) {
        if (providers.isEmpty()) {
            return new Hint("Geen hintproviders beschikbaar.", "info");
        }

        HintProvider provider = kiesRandomProvider();
        List<Hint> hints = provider.getHintsForContext(context);

        if (hints == null || hints.isEmpty()) {
            return new Hint("Geen hints voor deze kamer gevonden.", "info");
        }

        return hints.get(random.nextInt(hints.size()));
    }

    /**
     * Selecteert willekeurig een provider uit de lijst.
     * Handig als je toegang tot een concrete HintProvider wilt.
     *
     * @return Een willekeurige HintProvider
     * @throws IllegalStateException als er geen providers zijn
     */
    public static HintProvider createRandomHintProvider() {
        if (providers.isEmpty()) {
            throw new IllegalStateException("Geen HintProviders beschikbaar.");
        }
        return kiesRandomProvider();
    }

    /**
     * Interne helper om willekeurig een provider te kiezen.
     */
    private static HintProvider kiesRandomProvider() {
        return providers.get(random.nextInt(providers.size()));
    }
}
