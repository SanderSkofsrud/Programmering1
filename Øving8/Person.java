package Øving8;

public class Person {

    private final String fornavn, etternavn;
    private final int fodselsaar;

    /**
     * @param fornavn Parameter som inneholder fornavnet til personen
     * @param etternavn Parameter som inneholder etternavnet til personen
     * @param fodselsaar Parameter som inneholder fødselsåret til personen
     */
    public Person (String fornavn, String etternavn, int fodselsaar) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.fodselsaar = fodselsaar;
    }

    /**
     * @return Returnerer fornavn
     */
    public String getFornavn() {
        return fornavn;
    }

    /**
     * @return Returnerer etternavn
     */
    public String getEtternavn() {
        return etternavn;
    }

    /**
     * @return Returnerer alder
     */
    public int getFodselsaar() {
        return fodselsaar;
    }
}