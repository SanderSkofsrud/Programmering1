package Øving10;

import java.util.*;

public class ArrangementRegister {

    public ArrayList<Arrangement> arrangementer;

    public ArrangementRegister() {
        arrangementer = new ArrayList<Arrangement>();
    }

    /**
     * @param navn Parameter som inneholder navnet til arrangementet
     * @param sted Parameter som inneholder stedet arrangementet skal finne sted
     * @param arrangor Parameter som inneholder arrangøren til arrangementet
     * @param type Parameter som inneholder typen arrangement det skal være
     * @param tidspunkt Parameter som inneholder tidspuktet arrangementet skal finne sted
     * @return returnerer all dataen i det gitte arrangementet
     */
    public Arrangement nyttArrangement(String navn, String sted, String arrangor, String type, double tidspunkt) {
        int id = arrangementer.size();
        Arrangement arrangement = new Arrangement(id, navn, sted, arrangor, type, tidspunkt);
        return arrangement;
    }

    /**
     * @param sted Parameter som inneholder stedet et arrangement skal foregå
     * @return Returnerer alle arrangementene som skal finne plass på et gitt sted
     */
    public ArrayList<Arrangement> listeStedArrangementer(String sted) {
        ArrayList<Arrangement> stedArr = new ArrayList<Arrangement>();
        for (int i = 0; i < arrangementer.size(); i++) {
            if (arrangementer.get(i).getSted().equals(sted)) {
                stedArr.add(arrangementer.get(i));
            }
        }
        return stedArr;
    }

    /**
     * @param dato Parameter som inneholder datoen et arrangement skal foregå
     * @return Returnerer alle arrangementene som skal finne plass på en gitt dato
     */
    public ArrayList<Arrangement> listeDatoArrangementer(double dato) {
        ArrayList<Arrangement> datoArr = new ArrayList<Arrangement>();
        for (int i = 0; i < arrangementer.size(); i++) {
            int arrangementDato = (int)Math.floor(arrangementer.get(i).getTidspunkt() / 10000);
            if (arrangementDato == (int)dato) {
                datoArr.add(arrangementer.get(i));
            }
        }
        return datoArr;
    }

    /**
     * @param dato1 Parameter som inneholder den første datoen det skal sjekkes fra
     * @param dato2 Parameter som inneholder den andre datoen det skal sjekkes fra
     * @return Returnerer alle arrangementene som finner sted mellom de to gitte datoene
     */
    public ArrayList<Arrangement> listeMellomDatoerArrangementer(double dato1, double dato2) {
        ArrayList<Arrangement> datoArr = new ArrayList<Arrangement>();
        for (int i = 0; i < arrangementer.size(); i++) {
            int arrangementDato = (int)Math.floor(arrangementer.get(i).getTidspunkt() / 10000);
            if (arrangementDato >= (int)dato1 && arrangementDato <= (int)dato2) {
                datoArr.add(arrangementer.get(i));
            }
        }
        Comparator<Arrangement> sorterEtterTid = Comparator.comparingInt((Arrangement a) -> (int) a.getTidspunkt());
        datoArr.sort(sorterEtterTid);
        return datoArr;
    }
}