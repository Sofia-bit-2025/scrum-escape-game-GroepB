package Test;

//je gebruikt een stub als vervanging van iets waar je nog niet bij kan (bvb nog geen database) om gedrag van andere code daaromheen te testen
public class LoginSimulatieStub {

    public boolean isIngelogd(String gebruikersnaam, String wachtwoord) {
        return "stub".equals(gebruikersnaam) && "stub123".equals(wachtwoord);
    }

    public static void main(String[] args) {
        LoginSimulatieStub stub = new LoginSimulatieStub();

        if (stub.isIngelogd("stub", "stub123")) {
            System.out.println("Ingelogd met stub");
        } else {
            System.out.println("Login mislukt");
        }
    }
}
