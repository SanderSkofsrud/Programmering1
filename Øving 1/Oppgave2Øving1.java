public class Oppgave2Øving1 {
    public static void main(String args[]) {
        double timer = 1;
        double minutter = 2;
        double sekunder = 3;
        double totSekunder = timer * 3600 + minutter * 60 + sekunder;
        System.out.println(timer + " time(r) " + minutter + " minutt(er) " + sekunder + " sekund(er) er tilsammen "
                + totSekunder + " sekunder!");
    }
}
