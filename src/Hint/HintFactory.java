package Hint;

import java.util.List;
import java.util.Random;

/**
 * HintFactory bepaalt op willekeurige wijze welke concrete HintProvider gekozen wordt.
 * Dit is een implementatie van het Factory Pattern en past het Dependency Inversion DIP toe.
 * Kamers en opdrachten zijnn alleen afhankelijk van de HintProvider interface.
 */
public class HintFactory {

    // Lijst van beschikbare concrete HintProviders
    private static final List<HintProvider> providers = List.of(
            new HelpHintProvider(),
            new FunnyHintProvider()

    );

    // Eén gedeelde Random instantie voor efficiënte en reproduceerbare selectie
    private static final Random random = new Random();

    /**
     * Selecteert willekeurig één van de beschikbare HintProviders.
     *
     * @return een willekeurig gekozen HintProvider -> abstractie dus
     */
    public static HintProvider createRandomHintProvider() {
        int index = random.nextInt(providers.size());
        HintProvider selected = providers.get(index);



        return selected;
    }
}
