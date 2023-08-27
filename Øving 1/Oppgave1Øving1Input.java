import java.util.Scanner;

public class Oppgave1Øving1Input {
    public static void main(String args[]) {
        try (Scanner myObj = new Scanner(System.in)) {
            double lengde;
            System.out.printf("Skriv inn lengde i centimeter: ");
            lengde = myObj.nextDouble();
            double tomme = 2.54;
            double omgjort = lengde / tomme;
            System.out.println(lengde + " centimeter omgjort til tommer er " + omgjort + "tommer");
        }
    }
}
