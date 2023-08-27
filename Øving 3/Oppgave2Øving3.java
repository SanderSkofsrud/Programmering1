import java.util.Scanner;

public class Oppgave2Øving3 {

    public static void main(String args[]) {

        try (Scanner myObj = new Scanner(System.in)) {
            while (true) {

                int tall = 0;
                System.out.printf("Skriv inn et tall du ønsker å sjekke om er et primtall: ");
                tall = myObj.nextInt();
                boolean primtall = true;
                for (int i = 2; i <= tall / 2; i++) {
                    if (tall % i == 0) {
                        primtall = false;
                        break;
                    }
                }

                if (primtall) {
                    System.out.println(tall + " er et primtall.\n");
                } else {
                    System.out.println(tall + " er ikke et primtall.\n");
                }
            }
        }
    }

}
