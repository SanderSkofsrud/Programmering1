import java.util.Random;

public class Oppgave2Øving4 {
  public static void main(String[] args) {
    Spiller[] spiller = new Spiller[2];
    spiller[0] = new Spiller(0);
    spiller[1] = new Spiller(0);

    int rundenummer = 0;

    while (!spiller[0].erFerdig(spiller[0].sumPoeng) && !spiller[1].erFerdig(spiller[1].sumPoeng)) {
      spiller[0].sumPoeng = spiller[0].kastTerningen(spiller[0].sumPoeng);
      spiller[1].sumPoeng = spiller[1].kastTerningen(spiller[1].sumPoeng);
      System.out.println("Rundenummer: " + rundenummer + ", Spiller 1: " + spiller[0].sumPoeng + ", Spiller 2: "
          + spiller[1].sumPoeng);
      rundenummer += 1;
    }

    System.out.println("---------------");
    if (spiller[0].erFerdig(spiller[0].sumPoeng)) {
      System.out.println("Spiller 1 vant!");
    } else {
      System.out.println("Spiller 2 vant!");
    }
    System.out.println("---------------");

  }

  static class Spiller {
    int sumPoeng;
    private static Random terning = new Random();

    public Spiller(int poeng) {
      sumPoeng = poeng;
    }

    public int getPoeng() {
      return sumPoeng;
    }

    public int kastTerningen(int poeng) {
      int nySum;

      int n = terning.nextInt(6);
      n += 1;
      if (n == 1) {
        nySum = 0;
      } else {
        nySum = poeng + n;
      }
      return nySum;
    }

    public boolean erFerdig(int poeng) {
      if (poeng == 100) {
        return true;
      } else {
        return false;
      }
    }
  }
}
