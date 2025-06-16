package voorwerp;

import monster.MonsterBasis;

import java.util.Scanner;

public class Zwaard implements Weapon {
    private String naam;

    public Zwaard(String naam){
        this.naam = naam;
    }


    @Override
    public void attack(){

        Scanner scanner = new Scanner(System.in);

        String[] frames = {
                """
        \n PAK HET ZWAARD!!!
        """,
                """
        \n                         █▄█   █▀█  █▀█  ▄█▄█
              ||                   ▀██▄ ▀▄▀  ▀▄▀ ▄██▀
        O|@@@|* >=============>>>     ▄██▀███▀███▄
              ||                      ▀█▀██▄▄▄██▀█▀▌
        """,
                """
        \n              █▄█   █▀█  █▀█  ▄█▄█
              ||        ▀██▄ ▀▄▀  ▀▄▀ ▄██▀
        O|@@@|* >==========▄██▀███▀███▄
              ||          ▐▀█▀██▄▄▄██▀█▀▌
        """,
                """
        \n         █▄█   █▀█  █▀█  ▄█▄█
              ||   ▀██▄ ▀▄▀  ▀▄▀ ▄██▀
        O|@@@|* >=====▄██▀███▀███▄
              ||     ▐▀█▀██▄▄▄██▀█▀▌
        """,

                """
        \n         
        RIP.....
        
        """
        };

        for (String frame : frames) {
            System.out.println(frame);
            scanner.nextLine();
        }


    }

    @Override
    public void gebruikOp(MonsterBasis monster) {
        attack();
        System.out.println("Je raakt het monster!");
        monster.verslaan();
    }
}
