package Øving7;

import java.util.*;

class Tekst {

    private final String setning;
    private static Scanner in = new Scanner(System.in);

    public Tekst(String text) {
        this.setning = text;
    }


    private void statistikk() {
        String setning = this.setning;
        String regex = "([^a-zA-ZÆØÅæøå']+)'*\\1*";
        String[] ord = setning.split(regex);
        double antallOrd = ord.length;

        double bokstaver = 0.0;
        for (int i = 0; i < ord.length; i++) {
            bokstaver += ord[i].length();
        }
        double ordlengde = bokstaver / antallOrd;

        String regexTegn = "[.!:?]";

        double snittPerPeriode = 0.0;
        String[] perioder = setning.split(regexTegn);
        snittPerPeriode = antallOrd / perioder.length;

        System.out.println("-----------");
        System.out.println("Antall ord: " + antallOrd);
        System.out.println("Den gjennomsnittlige ordlengden er : " + ordlengde);
        System.out.println("Det er i snitt " + snittPerPeriode + " ord per periode");
        System.out.println("-----------");

    }

    private String skiftUt(String ord1, String ord2) {
        String setning = this.setning;
        String nySetning = setning.replaceAll(ord1, ord2);
        return nySetning;
    }


    public static void main(String[] args) {
        inputTekst();
    }

    public static void inputTekst() {
        System.out.println("----------");
        System.out.printf("Skriv inn tekst: ");
        String input = in.nextLine();
        Tekst a = new Tekst(input);
        System.out.println("----------");
        visMeny(a);
    }

    private String seSetning() {
        System.out.println("----------");
        return this.setning;
    }
    private String storTekst() {
        String setning = this.setning;
        setning = setning.toUpperCase();
        System.out.println("----------");
        return setning;
    }

    public static void visMeny(Tekst a) {
        System.out.println("Tast 1 for å vise statistikk");
        System.out.println("Tast 2 for å skifte ut ord med et annet");
        System.out.println("Tast 3 for å se teksten");
        System.out.println("Tast 4 for å gjøre alle bokstaver store");
        System.out.println("Tast 5 for å skrive inn ny setning");
        System.out.println("----------");
        System.out.printf("Tast tall her: ");

        int menyInput = in.nextInt();
        switch (menyInput) {
            case 1:
                a.statistikk();
                //visMeny(a);
                break;
            case 2:
                System.out.println("-----------");
                System.out.print("Skriv inn ord som skal byttes ut: ");
                String ord1 = in.next();
                System.out.print("Skriv inn det nye ordet: ");
                String ord2 = in.next();
                System.out.println(a.skiftUt(ord1, ord2));
                System.out.println("-----------");
                //visMeny(a);
                break;
            case 3: System.out.println(a.seSetning());
                //visMeny(a);
                break;
            case 4: System.out.println(a.storTekst());
                //visMeny(a);
                break;
            case 5: inputTekst();
                break;

            default:
                System.out.println("Du må skrive inn et tall fra 1 til 5");
                visMeny(a);
                break;
        }
    }
}