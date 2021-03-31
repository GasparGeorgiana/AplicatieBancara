public class Cont {
    private double balanta = 0;
    private double dobanda = 0.02;
    private int numarCont;
    private static int numarDeConturi = 1000000;

    Cont() {
        numarCont = numarDeConturi++;
    }
    public double getBalanta() {
        return balanta;
    }

    public void setBalanta(double balanta) {
        this.balanta = balanta;
    }

    public double getDobanda() {
        return dobanda * 100;
    }

    public void setDobanda(double interes) {
        this.dobanda = dobanda;
    }

    public int getNumarCont() {
        return numarCont;
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
