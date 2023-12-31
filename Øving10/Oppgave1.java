package Øving10;

import java.util.*;

public class Oppgave1 {

    private Scanner in = new Scanner(System.in);
    private ArrangementRegister register = new ArrangementRegister();

    public static void main(String[] args) {
        Oppgave1 o = new Oppgave1();
        o.testData();
        while (true) {
            o.visMeny();
        }
    }

    public void testData() {
        register.nyttArrangement("Vors på kontoret", "Tihlde-kontoret", "Malin", "Vors", 202211031500L);
        register.nyttArrangement("Konsert med Undergrunn", "Samf", "Samf", "Konsert", 202210282100L);
        register.nyttArrangement("Øving Programmering", "Klasserommet", "NTNU", "Øving", 202211031200L);
        register.nyttArrangement("Øving Matte", "Klasserommet", "NTNU", "Øving", 202211021200L);
        register.nyttArrangement("Pizzatid", "Telenorbygget", "Telenor", "Bedpress", 202109171800L);
        register.nyttArrangement("Gratis kake i kiosken", "Kake", "Kiosken", "Gratis", 201901010100L);
    }
    public void visMeny() {
        System.out.println("");
        System.out.println("Tast 1 for å registrere nytt arrangement");
        System.out.println("Tast 2 for å finne alle arrangementer på et sted");
        System.out.println("Tast 3 for å finne alle arrangementer på en dato");
        System.out.println("Tast 4 for å finne alle arrangementer innenfor et tidsintervall");
        System.out.println("Tast 5 for å se alle arrangementer sortert");
        System.out.println("Tast 6 for å avslutte programmet");

        int menyInput = in.nextInt();
        switch (menyInput) {
            case 1 -> lagArrangement();
            case 2 -> stedArrangementer();
            case 3 -> datoArrangementer();
            case 4 -> mellomDatoArrangementer();
            case 5 -> alleArrangementer();
            case 6 -> System.exit(0);
            default -> System.out.println("Du må skrive et tall fra 1-6");
        }
    }

    /**
     * @param liste Parameter som inneholder en liste over alle de registrerte arrangementene
     */
    public void skrivUtArrangementer(ArrayList<Arrangement> liste) {
        System.out.println("");
        if (liste.size() > 0) {
            for (Arrangement arrangement : liste) {
                System.out.println(arrangement.toString());
            }
        } else {
            System.out.println("Fant ingen arrangementer");
        }
    }

    private void lagArrangement() {
        in.nextLine();
        System.out.print("Navn: "); String navn = in.nextLine();
        System.out.print("Sted: "); String sted = in.nextLine();
        System.out.print("Arrangør: "); String arrangor = in.nextLine();
        System.out.print("Type: "); String type = in.nextLine();
        System.out.print("Tidspunkt (YYYYMMDDTTMM): "); double tidspunkt = in.nextDouble();
        Arrangement a = register.nyttArrangement(navn, sted, arrangor, type, tidspunkt);
        register.arrangementer.add(a);
    }
    private void stedArrangementer() {
        in.nextLine();
        System.out.print("Sted: "); String sted = in.nextLine();
        skrivUtArrangementer(register.listeStedArrangementer(sted));
    }
    private void datoArrangementer() {
        System.out.print("Dato (YYYYMMDD): "); double dato = in.nextDouble();
        skrivUtArrangementer(register.listeDatoArrangementer(dato));
    }
    private void mellomDatoArrangementer() {
        System.out.print("Startdato (YYYYMMDD): "); double dato1 = in.nextDouble();
        System.out.print("Sluttdato (YYYYMMDD): "); double dato2 = in.nextDouble();
        if (dato1 < dato2) {
            skrivUtArrangementer(register.listeMellomDatoerArrangementer(dato1, dato2));
        } else {
            System.out.println("Sluttdatoen må komme etter startdatoen!");
        }
    }
    private void alleArrangementer() {
        System.out.println("Tast 1 for å sortere etter sted");
        System.out.println("Tast 2 for å sortere etter type");
        System.out.println("Tast 3 for å sortere etter tidspunkt");
        int aInput = in.nextInt();
        switch (aInput) {
            case 1:
                //Comparator<Arrangement> sorterEtterSted = (Arrangement a1, Arrangement a2) -> a1.getSted().compareTo(a2.getSted());
                ArrayList<Arrangement> ar1 = register.arrangementer;
                ar1.sort(Comparator.comparing(Arrangement::getSted));
                skrivUtArrangementer(ar1);
                break;
            case 2:
                //Comparator<Arrangement> sorterEtterType = (Arrangement a1, Arrangement a2) -> a1.getType().compareTo(a2.getType());
                ArrayList<Arrangement> ar2 = register.arrangementer;
                ar2.sort(Comparator.comparing(Arrangement::getType));
                skrivUtArrangementer(ar2);
                break;
            case 3:
                //Comparator<Arrangement> sorterEtterTid = (Arrangement a1, Arrangement a2) -> (int)a1.getTidspunkt() - (int)a2.getTidspunkt();
                ArrayList<Arrangement> ar3 = register.arrangementer;
                ar3.sort(Comparator.comparing(Arrangement::getTidspunkt));
                skrivUtArrangementer(ar3);
                break;
            default:
                System.out.println("Du må taste et tall fra 1-3");
                alleArrangementer();
                break;
        }
    }
}