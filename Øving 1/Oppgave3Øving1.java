public class Oppgave3Øving1 {
    public static void main(String args[]) {
        int totSekunder = 3723;
        int timer = totSekunder / 3600;
        int minutter = (totSekunder % 3600) / 60;
        int sekunder = totSekunder % 60;

        System.out.println(totSekunder + " sekunder tilsvarer: " + timer + " timer, "
                + minutter + " minutter og " + sekunder + " sekunder");
    }
}
