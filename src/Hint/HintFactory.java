package Hint;

import java.util.List;
import java.util.Random;

/**
 * HintFactory bepaalt op willekeurige wijze welke concrete HintProvider gekozen wordt.
 */
public class HintFactory {

    private static final List<HintProvider> providers = List.of(
            new HelpHintProvider(),
            new FunnyHintProvider()
    );

    private static final Random random = new Random();

    /**
     * Haalt een hint op die past bij de opgegeven context.
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
