package Øving9;

import java.util.*;

public class Student {

    private final String navn;
    private int antOppg;

    /**
     * @param navn Parameter som inneholder navnet til studenten
     * @param antOppg Parameter som inneholder antall løste oppgaver av studenten
     */
    public Student(String navn, int antOppg) {
        this.navn = navn;
        this.antOppg = antOppg;
    }

    /**
     * @return Returnerer navn til den gitte studenten
     */
    public String getNavn() {
        return this.navn;
    }

    /**
     * @return Returnerer antall oppgaver løst av den gitte studenten
     */
    public int getAntOppg() {
        return this.antOppg;
    }

    /**
     * @param okning Parameter som sier hvor mye antall løste oppgaver skal øke med
     */
    public void okAntOppg(int okning) {
        this.antOppg = this.antOppg + okning;
    }

    /**
     * @return Returnerer navnet + antall oppgaver løst av en gitt student
     */
    public String toString() {
        return this.navn + ", " + Double.toString(this.antOppg);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Skriv inn navn på studenten: "); String navn = in.nextLine();
        System.out.print("Skriv inn antall oppgaver studenten har gjort: "); int antOppg = in.nextInt();
        Student nyStudent = new Student(navn, antOppg);
        System.out.println("");
        System.out.println("Data registrert på student:");
        System.out.println("Navn: " + nyStudent.getNavn());
        System.out.println("Antall oppgaver gjort: " + nyStudent.getAntOppg());
        System.out.println("Legger til 4: ");
        nyStudent.okAntOppg(4);
        System.out.println("Antall oppgaver gjort: " + nyStudent.getAntOppg());
        System.out.println(nyStudent.toString());
    }
}