package Clase;

import java.util.ArrayList;

public class Banca {
    ArrayList<Client> clienti = new ArrayList<Client>();

    public void addClient(Client client) {
        clienti.add(client);
    }

    public Client getClient(int cont) {
        return clienti.get(cont);
    }

    public ArrayList<Client> getClienti() {
        return clienti;
    }
}
