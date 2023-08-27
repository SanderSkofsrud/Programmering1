package Øving10;

public class Rett {

    private String navn, type, oppskrift;
    private double pris;

    /**
     * @param navn Parameter som inneholder navnet på retten
     * @param type Parameter som inneholder hvilken type rett det er
     * @param pris Parameter som inneholder priset på retten
     * @param oppskrift Parameter som inneholder oppskriften til retten
     */
    public Rett (String navn, String type, double pris, String oppskrift) {
        this.navn = navn;
        this.type = type;
        this.pris = pris;
        this.oppskrift = oppskrift;
    }

    /**
     * @return Returnerer navnet til den gitte retten
     */
    public String getNavn() {
        return navn;
    }

    /**
     * @return Returnerer typen til den gitte retten
     */
    public String getType() {
        return type;
    }

    /**
     * @return Returnerer prisen til den gitte retten
     */
    public double getPris() {
        return pris;
    }

    /**
     * @return Returnerer oppskriften til den gitte retten
     */
    public String getOppskrift() {
        return oppskrift;
    }

    /**
     * @return Returnerer all infoen til den gitte retten omgjort til en string og formulert på riktig måte
     */
    public String toString() {
        return "Navn: " + this.getNavn() + ", type: " + this.getType() + ", pris: " + this.getPris() + ", oppskrift: " + this.getOppskrift();
    }
    public String toSmallString() {
        return this.getNavn() + " (" + this.getPris() + " kr)";
    }
}
