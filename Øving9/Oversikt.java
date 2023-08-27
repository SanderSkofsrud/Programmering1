package Øving9;

import java.util.*;

public class Oversikt {

    private ArrayList<Student> studenter;
    private int antStud = 0;

    public Oversikt() {
        studenter = new ArrayList<Student>();
    }

    /**
     * @return Returnerer antall studenter fra tabellen studenter
     */
    public int getAntallStudenter() {
        return studenter.size();
    }

    /**
     * @param student Parameter som inneholder informasjon om hver student
     * @return returnerer antall oppgaver fullført av en gitt student
     */
    public int getAntallOppgStud(Student student) {
        int antall = student.getAntOppg();
        return antall;
    }

    /**
     * @param student Parameter som inneholder informasjon om hver student
     * @param okning Parameter som bestemmer hvor mye antall oppgaver fullført av en student skal øke
     */
    public void okAntallOppgStud(Student student, int okning) {
        student.okAntOppg(okning);
    }

    /**
     * @param navn Parameter som inneholder navnet til studenten
     * @param antOppg Parameter som inneholder antall oppgaver løst av studenten
     */
    public void nyStudent(String navn, int antOppg) {
        boolean navnEksisterer = false;
        for (int i = 0; i < getAntallStudenter(); i++) {
            if (studenter.get(i).getNavn().equals(navn)) {
                navnEksisterer = true;
            }
        }
        if (!navnEksisterer) {
            Student nyStudent = new Student(navn, antOppg);
            studenter.add(nyStudent);
        } else {
            System.out.println("Dette navnet er allerede i bruk!");
        }
    }

    /**
     * @return Returnerer navn og antall løste oppgaver for hver student omgjort til en string
     */
    public String toString() {
        String tekst = "";
        for (int i = 0; i < getAntallStudenter(); i++) {
            tekst = tekst + studenter.get(i) + " | ";
        }
        return tekst;
    }

    /**
     * @param navn Parameter som inneholder informasjon om navnet til studenten
     * @return Returnerer indexen/IDen til den riktige studenten
     */
    public int studentId(String navn) {
        int index = -1;
        for (int i = 0; i < getAntallStudenter(); i++) {
            if (studenter.get(i).getNavn().equals(navn)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Oversikt a = new Oversikt();
        while (true) {
            a.visMeny();
        }
    }

    public void visMeny() {
        Scanner in = new Scanner(System.in);
        System.out.println("");
        System.out.println("");
        System.out.println("Tast 1 for å vise alle studenter");
        System.out.println("Tast 2 for å finne antall oppgaver en bestemt student har gjort");
        System.out.println("Tast 3 for å finne antall studenter som er registrert");
        System.out.println("Tast 4 for å registrere en ny student");
        System.out.println("Tast 5 for å øke antall oppgaver gjort av en bestemt student");

        int menyInput = in.nextInt();
        if (menyInput == 1) {
            skrivUtAlle();
        } else if (menyInput == 2) {
            in.nextLine();
            System.out.println(toString());
            System.out.print("Hvilken student? "); String navn = in.nextLine();
            int id = studentId(navn);
            try {
                Student student = studenter.get(id);
                System.out.print(student.getNavn() + " har gjort " + student.getAntOppg() + " oppgaver");
            } catch(IndexOutOfBoundsException e) {
                System.out.print("Studenten eksisterer ikke, tast 1 for å se en oversikt over alle studenter");
            }
        } else if (menyInput == 3) {
            System.out.print(getAntallStudenter() + " studenter er registrert");
        } else if (menyInput == 4) {
            in.nextLine();
            System.out.print("Skriv inn navn på studenten: "); String navn = in.nextLine();
            System.out.print("Skriv inn antall oppgaver studenten har gjort: "); int antOppg = in.nextInt();
            nyStudent(navn, antOppg);
        } else if (menyInput == 5) {
            in.nextLine();
            System.out.println(toString());
            System.out.print("Hvilken student? "); String navn = in.nextLine();
            int id = studentId(navn);
            try {
                System.out.print("Hvor mange flere oppgaver er gjort? "); int okning = in.nextInt();
                Student student = studenter.get(id);
                student.okAntOppg(okning);
                System.out.print(student.getNavn() + " har nå gjort " + student.getAntOppg() + " oppgaver");
            } catch(IndexOutOfBoundsException e) {
                System.out.print("Studenten eksisterer ikke, tast 1 for å se en oversikt over alle studenter");
            }
        } else {
            System.out.println("Du må taste inn et tall fra 1-5");
        }
    }

    public void skrivUtAlle() {
        System.out.println("");
        if (getAntallStudenter() < 1) {
            System.out.println("Ingen studenter er registrert");
        } else {
            System.out.println("Studenter:");
            for (int i = 0; i < getAntallStudenter(); i++) {
                Student student = studenter.get(i);
                System.out.println("Navn: " + student.getNavn() + ", oppgaver: " + student.getAntOppg());
            }
        }
    }
}