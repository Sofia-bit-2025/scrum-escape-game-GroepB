package Assistent;


public class DefaultMotivatieProvider implements MotivatieProvider {
    @Override
    public String geefMotivatie(String context) {
        return switch (context.toLowerCase()) {
            case "scrumboard" -> "Je hebt overzicht. Gebruik dat om slimme keuzes te maken!";
            case "sprintplanning" -> "Je plant als een echte Product Owner!";
            case "dailyscrum" -> "Samen sta je sterker. Blijf communiceren.";
            case "sprintreview" -> "Feedback is je brandstof om te groeien!";
            case "finale kamer: tia" -> "Je bent bijna bij het eind — doorzetten!";
            default -> "Jij hebt controle.";
        };
    }
}
