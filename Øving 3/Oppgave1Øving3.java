import java.util.Scanner;

public class Oppgave1Øving3 {
    public static void main(String args[]) {

        try (Scanner myObj = new Scanner(System.in)) {
            int gangeMin;
            int gangeMax;
            System.out.printf("Skriv inn den laveste gangetabellen du ønsker å se: ");
            gangeMin = myObj.nextInt();
            System.out.printf("Skriv inn den høyeste gangetabellen du ønsker å se: ");
            gangeMax = myObj.nextInt();
            for (int i = gangeMin; i <= gangeMax; i++) {
                for (int gange = 1; gange < 11; gange++) {
                    System.out.println(i + " x " + gange + " = " + gange * i);
                }
            }

        }
    }
}
