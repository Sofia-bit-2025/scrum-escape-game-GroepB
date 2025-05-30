package monster;

public class SpringStrategie implements AanvalsStrategie {
    @Override
    public void valAan() {
        String[] frames = {
                """
                                                ▄▀               ▀▄
                                                █▄█  █▀█  █▀█  ▄█▄█
                                                ─▀██▄▀▄▀  ▀▄▀▄██▀
                                                ░░▄██▀███▀███▄
                                                ░▐▀█▀██▄▄▄██▀█▀▌
            """,
                """
                                            ▄▀                ▀▄
                                            █▄█   █▀█  █▀█  ▄█▄█---
                                             ─▀██▄▀▄▀  ▀▄▀▄██▀-------
                                              ░░▄██▀███▀███▄------
                                             ░▐▀█▀██▄▄▄██▀█▀▌------
            """,
                """
                               ▄▀                ▀▄
                               █▄█   █▀█  █▀█  ▄█▄█---------------
                                ─▀██▄▀▄▀  ▀▄▀▄██▀--------------
                                ░░▄██▀███▀███▄--------------------------
                                ░▐▀█▀██▄▄▄██▀█▀▌	------------------
            """,
                """
                     ▄▀              ▀▄
                    █▄█  █▀█    █▀█  ▄█▄█------
                      ─▀██▄▀    ▀▄▀▄██▀----------
                       ░▄██▀███▀███▄----------
                     ░▐▀█▀██▄▄▄██▀█▀▌-----------
            """,
                """
               ▄▀              ▀▄
               █▄█ █▀█  █▀█  ▄█▄█-------
              ─▀██▄▀▄▀  ▀▄▀▄██▀--------------
                ░░▄██▀███▀███▄-----------
               ░▐▀█▀██▄▄▄██▀█▀▌	---------
            """,
                """
            ▄▀               ▀▄
            █▄█  █▀█  █▀█  ▄█▄█--
            ─▀██▄▀▄▀  ▀▄▀▄██▀-----
            ░░▄██▀███▀███▄-----------
            ░▐▀█▀██▄▄▄██▀█▀▌	---------
            Het monster springt naar voren!! AAAAAHHHH
            """
        };

        for (String frame : frames) {
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println(frame);
            try {
                Thread.sleep(250);
            } catch (InterruptedException ignored) {}

        }
    }
}

