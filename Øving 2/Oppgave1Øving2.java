import java.util.Scanner;

public class Oppgave1Øving2 {
  public static void main(String[] args) {
    try (Scanner input = new Scanner(System.in)) {
      int aar;
      System.out.printf("Skriv inn år: ");
      aar = input.nextInt();
      if (aar % 4 == 0 && aar % 100 != 0 || aar % 400 == 0) {
        System.out.println(aar + " er et skuddår");
      } else {
        System.out.println(aar + " er ikke et skuddår");
      }
    }
  }
}