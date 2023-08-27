import java.util.*;

public class Oppgave2Øving5 {

    private static Random random = new Random();
    private static Oppgave2Øving5 minRandom = new Oppgave2Øving5();

    public Oppgave2Øving5(){
    }

    public int nesteHeltall(int nedre, int ovre) { // intervallet(nedre, ovre)
        //for (int i = 0; i > 20; i++) {
            int max = ovre - nedre;
            int resultat = random.nextInt(max);
            resultat += nedre;
            return resultat;
        //}
    }


    public double nesteDesimaltall(double nedre, double ovre) { // intervallet>nedre,over>
            double max = ovre - nedre;
            double resultat = random.nextDouble(max);
            resultat += nedre;
            return resultat;
    }

    public static void main(String[] args) {
        kjorMeny();
    }

    public static void kjorMeny() {
        try (Scanner input = new Scanner(System.in)) {
            System.out.printf("Skriv inn det nederste tallet i intervallet: ");
            int nedre = input.nextInt();
            System.out.printf("Skriv inn det øverste tallet i intervallet: ");
            int ovre = input.nextInt();

            System.out.printf("Tast 1 for heltall \n");
            System.out.println("Tast 2 for desimaltall");

            int menyInput = input.nextInt();
            if (menyInput == 1) {
                for (int i = 0; i < 20; i++) {
                    System.out.println(minRandom.nesteHeltall(nedre, ovre));
                }
                    kjorMeny();
            } else if (menyInput == 2) {
                for (int i = 0; i < 20; i++) {
                    System.out.println(minRandom.nesteDesimaltall(nedre, ovre));
                }
                kjorMeny();
            } else {
                System.out.println("Du må taste inn enten 1 eller 2");
                kjorMeny();
                return;
            }
        }
    }
}

