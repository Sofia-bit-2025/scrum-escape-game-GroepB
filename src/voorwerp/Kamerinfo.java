package voorwerp;

public class Kamerinfo implements Readable {
    private String boodschap;

    public Kamerinfo(String boodschap) {
        this.boodschap = boodschap;
    }

    @Override
    public void showMessage() {
        System.out.println("      __...--~~~~~-._   _.-~~~~~--...__ ");
        System.out.println("    //               `V'               }}");
        System.out.println("   //                 |                 }}");
        System.out.println("  //__...--~~~~~~-._  |  _.-~~~~~~--...__ }} ");
        System.out.println(" //__.....----~~~~~._ | /_.~~~~~----.....__ }} ");
        System.out.println(" ==================={{|//==================== ");
        System.out.println("Kamerinfo: " + boodschap);
    }
}
