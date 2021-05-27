package Clase;

import Clase.Cont;

public class Savings extends Cont {
    private int savings_id;
    private static String tipulContului = "Clase.Savings";

    public Savings(int cont_id, double balanta, double dobanda, int numarCont, int savings_id) {
        super(cont_id, balanta, dobanda, numarCont);
        this.savings_id = savings_id;
    }

    public int getSavings_id() {
        return savings_id;
    }

    public void setSavings_id(int savings_id) {
        this.savings_id = savings_id;
    }

    public static String getTipulContului() {
        return tipulContului;
    }

    public static void setTipulContului(String tipulContului) {
        Savings.tipulContului = tipulContului;
    }

    @Override
    public String toString() {
        return "Savings{" +
                "savings_id=" + savings_id +
                '}';
    }
}
