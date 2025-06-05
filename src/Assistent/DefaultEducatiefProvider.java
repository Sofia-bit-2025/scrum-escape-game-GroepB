package Assistent;


public class DefaultEducatiefProvider implements EducatiefHulpmiddelProvider {
    @Override
    public String geefUitleg(String context) {
        return switch (context.toLowerCase()) {
            case "scrumboard" -> "Scrum Board helpt je taken visueel te ordenen in kolommen: To Do, Doing, Done.";
            case "sprintplanning" -> "Sprint Planning zorgt ervoor dat je niet te veel tegelijk probeert te doen.";
            case "dailyscrum" -> "Daily Scrum is bedoeld om je team dagelijks te synchroniseren.";
            case "sprintreview" -> "Sprint Review geeft je feedback van stakeholders.";
            case "finale kamer: tia" -> "In de finale toets je je Scrum-kennis over het hele proces.";
            default -> "Gebruik Scrum om iteratief en transparant samen te werken.";
        };
    }
}
