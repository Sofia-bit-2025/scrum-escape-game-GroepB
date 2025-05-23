package Hint;

import java.util.List;
import java.util.Random;

/**
 * HintFactory bepaalt op willekeurige wijze welke concrete HintProvider gekozen wordt.
 * Dit is een implementatie van het Factory Pattern en past het Dependency Inversion Principle toe.
 * Kamers en opdrachten zijn alleen afhankelijk van de HintProvider-interface.
 */
public class HintFactory {

    // Lijst van beschikbare concrete HintProviders
    private static final List<HintProvider> providers = List.of(
            new HelpHintProvider(),
            new FunnyHintProvider()
            // Je kunt hier eenvoudig nieuwe soorten toevoegen, zoals:
            // new MotivationalHintProvider()
    );

    // Eén gedeelde Random-instantie voor efficiënte en reproduceerbare selectie
    private static final Random random = new Random();

    /**
     * Selecteert willekeurig één van de beschikbare HintProviders.
     *
     * @return een willekeurig gekozen HintProvider (abstractie)
     */
    public static HintProvider createRandomHintProvider() {
        int index = random.nextInt(providers.size());
        HintProvider selected = providers.get(index);

        // Debugregel voor testdoeleinden (zie User Story 20, validatiecriterium 13)
        // System.out.println("HintFactory selecteerde: " + selected.getClass().getSimpleName());

        return selected;
    }
}
