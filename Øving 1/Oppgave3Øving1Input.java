import java.util.Scanner;

public class Oppgave3Øving1Input {
    public static void main(String args[]) {
        try (Scanner myObj = new Scanner(System.in)) {
            int totSekunder;
            System.out.printf("Skriv inn antal sekunder: ");
            totSekunder = myObj.nextInt();
            int timer = totSekunder / 3600;
            int minutter = (totSekunder % 3600) / 60;
            int sekunder = totSekunder % 60;

            System.out.println(totSekunder + " sekunder tilsvarer: " + timer + " timer, "
                    + minutter + " minutter og " + sekunder + " sekunder");
        }
    }
}
