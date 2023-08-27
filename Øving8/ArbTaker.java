package Øving8;

import java.util.*;

public class ArbTaker {

    private final Person personalia;
    private final int arbtakernr, ansettelsesaar;
    private static double manedslonn, skatteprosent;
    GregorianCalendar kalender = new GregorianCalendar();


    /**
     * @param personalia Parameter som inneholder informasjon om personen, fornavn, etternavn og alder
     * @param arbtakernr Parameter som inneholder arbeidstaker-nummeret til personen
     * @param ansettelsesaar Parameter som inneholder året personen ble ansatt
     * @param manedslonn Parameter som inneholder månedslønnen til personen
     * @param skatteprosent Parameter som inneholder skatteprosenten til personen
     */
    public ArbTaker (Person personalia, int arbtakernr, int ansettelsesaar, double manedslonn, double skatteprosent) {
        this.personalia = personalia;
        this.arbtakernr = arbtakernr;
        this.ansettelsesaar = ansettelsesaar;
        this.manedslonn = manedslonn;
        this.skatteprosent = skatteprosent;
    }

    /**
     * @return Returnerer personalia
     */
    public Person getPersonalia() {
        return personalia;
    }

    /**
     * @return Returnerer arbeidstakernummeret
     */
    public int getArbtakernr() {
        return arbtakernr;
    }

    /**
     * @return Returner ansettelsesåret
     */
    public int getAnsettelsesaar() {
        return ansettelsesaar;
    }

    /**
     * @return Returnerer månedslønnen
     */
    public double getManedslonn() {
        return manedslonn;
    }

    /**
     * @return Returnerer skatteprosenten
     */
    public double getSkatteprosent() {
        return skatteprosent;
    }

    /**
     * @param nyLonn Parameter hvor verdien til manedslonn blir erstattet med nyLonn
     */
    void setManedslonn(double nyLonn) {
        this.manedslonn = nyLonn;
    }

    /**
     * @param nySkatteprosent Parameter hvor verdien til skatteprosent blir erstattet med nySkatteprosent
     */
    void setSkatteprosent(double nySkatteprosent) {
        this.skatteprosent = nySkatteprosent;
    }


    /**
     * @return Returnerer skatt per måned i kroner
     */
    double getSkattPerManed() {
        double skatt = this.getManedslonn() * (this.getSkatteprosent() / 100);
        return skatt;
    }

    /**
     * @return Returnerer bruttolønnen per år i kroner
     */
    double getBruttoLonnAar() {
        double bruttoLonn = this.getManedslonn() * 12;
        return bruttoLonn;
    }

    /**
     * @return Returnerer   skatt per år i kromer
     */
    double getSkattPerAar() {
        double tiManeder = this.getSkattPerManed() * 10;
        double skattetrekk = tiManeder + (this.getSkattPerManed() * 0.5);
        return skattetrekk;
    }

    /**
     * @return Returnerer etternavnet og fornavnet til personen
     */
    String getNavn() {
        String navn = this.getPersonalia().getEtternavn() + ", " + this.getPersonalia().getFornavn();
        return navn;
    }

    /**
     * @return Returnerer alderen til personen
     */
    int getAlder() {
        int aarNa = kalender.get(java.util.Calendar.YEAR);
        int alder = aarNa - this.getPersonalia().getFodselsaar();
        return alder;
    }

    /**
     * @return Returnerer antall år personen er ansatt
     */
    int getAarAnsatt() {
        int aarNa = kalender.get(Calendar.YEAR);
        int aarAnsatt = aarNa - this.getAnsettelsesaar();
        return aarAnsatt;
    }

    /**
     * @param antallAar Parameter som sier hvor mange år den ansatte må være ansatt lenger enn, i dette tilfellet 10
     * @return Returnerer true eller false ut ifra om personen har jobbet mer eller mindre enn 10 år
     */
    boolean getAnsattMerEnn(int antallAar) {
        boolean merEnn = false;
        if (this.getAarAnsatt() >= antallAar) {
            merEnn = true;
        }
        return merEnn;
    }


}