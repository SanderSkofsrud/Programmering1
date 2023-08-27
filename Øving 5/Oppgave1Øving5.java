import java.util.*;

    public class Oppgave1Øving5 {
        private double teller, nevner, resultatTeller, resultatNevner;
        private String resultatOutput, resultatTotal;

        public Oppgave1Øving5(double teller, double nevner) {
            if (nevner == 0) {
                throw new IllegalArgumentException("Nevneren kan ikke være lik 0");
            } else {
                this.teller = teller;
                this.nevner = nevner;
            }
        }
        public Oppgave1Øving5(double teller) {
            this.teller = teller;
            this.nevner = 1;
        }

        public void addere(Oppgave1Øving5 b) {
            double resultatTeller = (this.teller * b.nevner) + (b.teller * this.nevner);
            double resultatNevner = this.nevner * b.nevner;
            String resultatTotal = resultatTeller + "/" + resultatNevner;
            this.resultatTeller = resultatTeller;
            this.resultatNevner = resultatNevner;
            this.resultatTotal = resultatTotal;
            this.resultatOutput = "(" + this.teller + "/" + this.nevner + ") + (" + b.teller + "/" + b.nevner + ")";
        }
        public void subtrahere(Oppgave1Øving5 b) {
            double resultatTeller = (this.teller * b.nevner) - (b.teller * this.nevner);
            double resultatNevner = this.nevner * b.nevner;
            String resultatTotal = resultatTeller + "/" + resultatNevner;
            this.resultatTeller = resultatTeller;
            this.resultatNevner = resultatNevner;
            this.resultatTotal = resultatTotal;
            this.resultatOutput = "(" + this.teller + "/" + this.nevner + ") - (" + b.teller + "/" + b.nevner + ")";
        }
        public void multiplisere(Oppgave1Øving5 b) {
            double resultatTeller = this.teller * b.teller;
            double resultatNevner = this.nevner * b.nevner;
            String resultatTotal = resultatTeller + "/" + resultatNevner;
            this.resultatTeller = resultatTeller;
            this.resultatNevner = resultatNevner;
            this.resultatTotal = resultatTotal;
            this.resultatOutput = "(" + this.teller + "/" + this.nevner + ") * (" + b.teller + "/" + b.nevner + ")";
        }
        public void dividere(Oppgave1Øving5 b) {
            double resultatTeller = this.teller * b.nevner;
            double resultatNevner = this.nevner * b.teller;
            String resultatTotal = resultatTeller + "/" + resultatNevner;
            this.resultatTeller = resultatTeller;
            this.resultatNevner = resultatNevner;
            this.resultatTotal = resultatTotal;
            this.resultatOutput = "(" + this.teller + "/" + this.nevner + ") / (" + b.teller + "/" + b.nevner + ")";
        }

        public String getResultat() {
            String resultat = this.resultatOutput + " = " + this.resultatTotal;
            return resultat;
        }

        public static void main(String[] args) {

            Oppgave1Øving5 a, b;
            try {
                a = new Oppgave1Øving5(5.2, 2.3);
            } catch(IllegalArgumentException e) {
                System.out.println(e);
                a = new Oppgave1Øving5(1);
            }
            try {
                b = new Oppgave1Øving5(17, 3);
            } catch(IllegalArgumentException e)   {
                System.out.println(e);
                b = new Oppgave1Øving5(1);
            }
            a.addere(b);
            System.out.println(a.getResultat());
            a.subtrahere(b);
            System.out.println(a.getResultat());
            a.multiplisere(b);
            System.out.println(a.getResultat());
            a.dividere(b);
            System.out.println(a.getResultat());
        }
    }