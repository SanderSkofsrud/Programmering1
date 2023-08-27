import java.util.Scanner;

public class Oppgave2Øving2 {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {

            System.out.printf("Skriv inn vekten til kjøttdeig A: ");
            float aVekt = input.nextFloat();
            System.out.printf("Skriv inn prisen til kjøttdeig A: ");
            float aPris = input.nextFloat();

            float aKilopris = (aPris / aVekt) * 1000;

            System.out.printf("Skriv inn vekten til kjøttdeig B: ");
            float bVekt = input.nextFloat();
            System.out.printf("Skriv inn prisen til kjøttdeig B: ");
            float bPris = input.nextFloat();

            float bKilopris = (bPris / bVekt) * 1000;

            if (aKilopris < bKilopris) {
            	System.out.println("Kjøttdeig A koster minst per kilogram");
            } else {
            	System.out.println("Kjøttdeig B koster minst per kilogram");
            }
            System.out.println("Kiloprisen til kjøttdeig A er " + aKilopris + "kr/kg");
            System.out.println("Kiloprisen til kjøttdeig B er " + bKilopris + "kr/kg");
        }
    }
}
