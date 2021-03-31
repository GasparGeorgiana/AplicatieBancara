public class Client {

    private final String nume;
    private final String CNP;
    private final String prenume;
    private final Cont cont;

    Client(String nume, String prenume, String CNP, Cont cont) {
        this.nume = nume;
        this.prenume = prenume;
        this.CNP = CNP;
        this.cont = cont;
    }

    @Override
    public String toString() {
        return "\nInformatii despre clienti\n" +
                "Nume: " + nume + "\n" +
                "Prenume: " + prenume + "\n" +
                "CNP: " + CNP + "\n" +
                cont;
    }

    public String basicInfo() {
        return  "Nume: " + nume +
                "Prenume: " + prenume +
                "CNP: " + CNP +
                "Numarul contului: " +cont.getNumarCont();
    }

    Cont getCont() {
        return cont;
    }
}
