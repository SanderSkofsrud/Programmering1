import java.util.Scanner;

public class Oppgave1Øving4 {

    public static void main(String[] args) {
        String[] meny = { "dollar", "euro", "sek", "avslutt" };
        String[] meny2 = {"Konvertere fra nok", "Konvertere til nok"};
        Valuta svensk = new Valuta(1.02, "sek");
        Valuta dollar = new Valuta(9.5, "dollar");
        Valuta euro = new Valuta(10, "euro");

        try (Scanner input = new Scanner(System.in)) {
            for (int i = 1; i <= meny.length; i++) {
                System.out.println(i + ". " + meny[i - 1]);
            }
            System.out.printf("Velg hvilken valuta du ønsker å konvertere ");

            int index = input.nextInt() - 1;
            if (index >= 3 || index < 0) {
                System.out.println("Du har valgt å skru av programmet");
            } else {
                System.out.printf("Ønsker du å konvertere " + meny[index] + " til eller fra nok? \n");

                for (int i = 1; i <= meny2.length; i++) {
                    System.out.println(i + ". " + meny2[i - 1]);
                }

                int index2 = input.nextInt() - 1;

                if (index == 0){
                    System.out.printf("Hvor mange " + meny[index] + " ønsker du å konvertere til nok? ");

                    double antall = input.nextDouble();
                    System.out.println("Du har " + antall + " " + meny[index]);
                    double nok;
                    if (index == 0) {
                        nok = dollar.konverterTilNok(antall);
                        System.out.println("Det tilsvarer " + nok + " nok!");
                    } else if (index == 1) {
                        nok = euro.konverterTilNok(antall);
                        System.out.println("Det tilsvarer " + nok + " nok!");
                    } else if (index == 2) {
                        nok = svensk.konverterTilNok(antall);
                        System.out.println("Det tilsvarer " + nok + " nok!");
                    }
                } else if (index == 1){
                    System.out.printf("Hvor mange " + meny[index] + " ønsker du å konvertere fra nok? ");

                    double antall = input.nextDouble();
                    System.out.println("Du har " + antall + " " + meny[index]);
                    double resultat;
                    if (index == 0) {
                        resultat = dollar.konverterFraNok(antall);
                        System.out.println("Det tilsvarer " + resultat + " dollar!");
                    } else if (index == 1) {
                        resultat = euro.konverterFraNok(antall);
                        System.out.println("Det tilsvarer " + resultat + " euro!");
                    } else if (index == 2) {
                        resultat = svensk.konverterFraNok(antall);
                        System.out.println("Det tilsvarer " + resultat + " sek!");
                    }
                } else {
                    System.out.println("Du er tulling");
                }
            }
        }
    }

    static class Valuta {
        double kurs;
        String navn;

        Valuta(double kurs, String navn) {
            this.kurs = kurs;
            this.navn = navn;
        }

        double konverterTilNok(double antall) { return antall * kurs; }
        double konverterFraNok(double antall) { return antall / kurs; }
    }
}