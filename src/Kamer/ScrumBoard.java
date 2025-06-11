    package Kamer;

    import Opdracht.Joker;
    import Opdracht.OpdrachtStrategy;

    /**
     * Kamer waarin de speler leert hoe een Scrum Board werkt.
     * De speler moet de opdracht correct uitvoeren om verder te mogen.
     */
    public class ScrumBoard extends Kamer {
        private final String instructie;
        private final OpdrachtStrategy opdracht;

        /**
         * Constructor voor de ScrumBoard-kamer.
         */
        public ScrumBoard(OpdrachtStrategy opdracht) {
            super("Scrum Board");
            this.instructie = "Richt het bord in met taken en user stories.";
            this.opdracht = opdracht; // Geen concrete opdracht maken hier dus wegens DIP
        }

        /**
         * Laat de speler weten dat hij in de ScrumBoard kamer is.
         */
        @Override
        public void betreed() {
            System.out.println("Je betreedt: " + getNaam());
            System.out.println(instructie);
        }

        /**
         * Voert de opdracht in deze kamer uit.
         *
         * @param gekozenJoker de joker die de speler heeft gekozen
         * @return true als opdracht succesvol werd uitgevoerd
         */
        @Override
        public boolean start(Joker gekozenJoker) {
            return opdracht.voerUit(this, gekozenJoker);  // Strategy Pattern toegepast hier
        }
    }
