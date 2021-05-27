package Clase;

import Clase.Cont;

public class Checking extends Cont {
    private int checking_id;
   private static String tipulContului = "Clase.Checking";

    public Checking(int cont_id, double balanta, double dobanda, int numarCont, int checking_id) {
        super(cont_id, balanta, dobanda, numarCont);
        this.checking_id = checking_id;
    }

    public int getChecking_id() {
        return checking_id;
    }

    public void setChecking_id(int checking_id) {
        this.checking_id = checking_id;
    }

    public static String getTipulContului() {
        return tipulContului;
    }

    public static void setTipulContului(String tipulContului) {
        Checking.tipulContului = tipulContului;
    }

    @Override
    public String toString() {
        return "Checking{" +
                "checking_id=" + checking_id +
                '}';
    }
}
