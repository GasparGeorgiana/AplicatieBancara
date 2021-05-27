package Clase;

import Clase.Cont;

public class Client {
    private int client_id;
    private final String nume;
    private final String CNP;
    private final String prenume;
    private final Cont cont;

    public Client(int client_id, String nume, String CNP, String prenume, Cont cont) {
        this.client_id = client_id;
        this.nume = nume;
        this.CNP = CNP;
        this.prenume = prenume;
        this.cont = cont;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getNume() {
        return nume;
    }

    public String getCNP() {
        return CNP;
    }

    public String getPrenume() {
        return prenume;
    }

    @Override
    public String toString() {
        return "Client{" +
                "client_id=" + client_id +
                ", nume='" + nume + '\'' +
                ", CNP='" + CNP + '\'' +
                ", prenume='" + prenume + '\'' +
                ", cont=" + cont +
                '}';
    }
    public String basicInfo() {
        return  "Nume: " + nume +
                "Prenume: " + prenume +
                "CNP: " + CNP +
                "Numarul contului: " +cont.getNumarCont();
    }


    public Cont getCont() {
        return cont;
    }
}
