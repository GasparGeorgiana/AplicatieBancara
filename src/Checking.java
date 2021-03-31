public class Checking extends Cont {
   private static String tipulContului = "Checking";

   Checking(double depunereInitiala) {
       super();
       this.setBalanta(depunereInitiala);
       this.verificaDobanda(0);
   }

   @Override
    public String toString() {
       return "Tipul Contului: " + tipulContului + "Cont\n" +
               "Numarul Contului: " + this.getNumarCont() + "\n" +
               "Balanta: " + this.getBalanta() + "\n" +
               "Rata dobanzii: " + this.getDobanda() + "\n";

   }
}
