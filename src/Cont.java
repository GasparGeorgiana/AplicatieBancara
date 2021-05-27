package Clase;

public class Cont {
    private int cont_id;
    private double balanta = 0;
    private double dobanda = 0.02;
    private int numarCont;
    private static int numarDeConturi = 1000000;


    public Cont(int cont_id, double balanta, double dobanda, int numarCont) {
        this.cont_id = cont_id;
        this.balanta = balanta;
        this.dobanda = dobanda;
        this.numarCont = numarCont;
    }

    public int getCont_id() {
        return cont_id;
    }

    public void setCont_id(int cont_id) {
        this.cont_id = cont_id;
    }

    public double getBalanta() {
        return balanta;
    }

    public void setBalanta(double balanta) {
        this.balanta = balanta;
    }

    public double getDobanda() {
        return dobanda;
    }

    public void setDobanda(double dobanda) {
        this.dobanda = dobanda;
    }

    public int getNumarCont() {
        return numarCont;
    }

    public void setNumarCont(int numarCont) {
        this.numarCont = numarCont;
    }

    public static int getNumarDeConturi() {
        return numarDeConturi;
    }

    public static void setNumarDeConturi(int numarDeConturi) {
        Cont.numarDeConturi = numarDeConturi;
    }

    @Override
    public String toString() {
        return "Cont{" +
                "cont_id=" + cont_id +
                ", balanta=" + balanta +
                ", dobanda=" + dobanda +
                ", numarCont=" + numarCont +
                '}';
    }

    public void retragere(double suma) {
        if(suma + 5 > balanta) {
            System.out.println("Aveti fonduri insuficiente!");
            return;
        }
        balanta -= suma + 5;
        verificaDobanda(0);
        System.out.println("Ati retras " + suma + "lei si ati suportat o taxa de 5 lei");
        System.out.println("Acum aveti in balanta " + balanta + "lei");
    }

    public void depunere(double suma) {
        if(suma <= 0) {
            System.out.println("Nu puteti depune o suma negativa!");
            return;
        }
        verificaDobanda(suma);
        suma = suma + suma * dobanda;
        balanta += suma;
        System.out.println("Ati depus " + suma + "lei si ati suportat o dobanda de" + (dobanda*100) + "%");
        System.out.println("Acum aveti in balanta " + balanta + "lei");
    }

    public void verificaDobanda(double suma) {
        if(balanta + suma > 10000) {
            dobanda = 0.05;
        } else {
            dobanda = 0.02;
        }
    }

}
