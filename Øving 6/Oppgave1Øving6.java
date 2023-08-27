import java.util.*;

public class Oppgave1Øving6 {
    private static Random random = new Random();
    private static int[] antall = new int[10];

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            int tall = random.nextInt(10);
            antall[tall]++;
        }

        for (int i = 0; i < 10; i++) {
            int sum = antall[i];
            long stjerner = Math.round(sum / (1000 / 100.0));
            String stjerne = "";
            for (int j = 0; j < stjerner; j++) {
                stjerne += "*";
            }
            System.out.println("Tall " + i + ": " + sum + " " + stjerne);
        }
    }
}