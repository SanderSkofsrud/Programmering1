package Øving10;

public class Arrangement {

    private final int id;
    private final double tidspunkt;
    private final String navn, sted, arrangor, type;

    private int AntId = 1;

    /**
     *
     * Klasse som definerer ett arrangement og inneholder alle parameterene som kreves
     *
     * @param id Parameter som inneholder id-en til arrangementet
     * @param navn Parameter som inneholder navnet til arrangementet
     * @param sted Parameter som inneholder stedet arrangementet skal finne sted
     * @param arrangor Parameter som inneholder arrangøren til arrangementet
     * @param type Parameter som inneholder typen arrangement det skal være
     * @param tidspunkt Parameter som inneholder tidspuktet arrangementet skal finne sted
     */
    public Arrangement(int id, String navn, String sted, String arrangor, String type, double tidspunkt) {
        this.id = id;
        this.navn = navn;
        this.sted = sted;
        this.arrangor = arrangor;
        this.type = type;
        this.tidspunkt =tidspunkt;
    }

    /**
     * @return Returnerer id-en til det gitte arrangementet
     */
    public int getId() {
        return id;
    }

    /**
     * @return Returnerer navnet til det gitte arrangementet
     */
    public String getNavn() {
        return navn;
    }

    /**
     * @return Returnerer stedet arrangementet skal finne sted
     */
    public String getSted() {
        return sted;
    }

    /**
     * @return Returnerer arrangøren til det gitte arrangementet
     */
    public String getArrangor() {
        return arrangor;
    }

    /**
     * @return Returnerer typen til det gitte arrangementet
     */
    public String getType() {
        return type;
    }

    /**
     * @return Returnerer tidspunktet arrangementet skal finne sted
     */
    public double getTidspunkt() {
        return tidspunkt;
    }

    /**
     * @return Returnerer all dataen i en string formulert på riktig måte
     */
    public String toString() {
        String t = String.format("%.1f", this.getTidspunkt());
        String tid = t.substring(6, 8) + "." + t.substring(4, 6) + "." + t.substring(0, 4) + " kl. " + t.substring(8, 10) + ":" + t.substring(10, 12);
        return "Id: " + this.getId() + ", navn: " + this.getNavn() + ", sted: " + this.getSted() + ", arrangør: " + this.getArrangor() + ", type: " + this.getType() + ", tidspunkt: " + tid;
    }
}