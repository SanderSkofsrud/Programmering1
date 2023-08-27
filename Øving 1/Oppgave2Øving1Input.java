import java.util.Scanner;

public class Oppgave2Øving1Input {
    public static void main(String[] args) {
        try (Scanner myObj = new Scanner(System.in)) {
            double timer;
            double minutter;
            double sekunder;
            System.out.printf("Skriv inn antal timer: ");
            timer = myObj.nextDouble();
            System.out.printf("Skriv inn antal minutter: ");
            minutter = myObj.nextDouble();
            System.out.printf("Skriv inn antal sekunder: ");
            sekunder = myObj.nextDouble();
            double totSekunder = timer * 3600 + minutter * 60 + sekunder;
            System.out.println(timer + " time(r) " + minutter + " minutt(er) " + sekunder + " sekund(er) er tilsammen "
                    + totSekunder + " sekunder!");
        }
    }
}
