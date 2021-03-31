import java.util.ArrayList;

public class Banca {
    ArrayList<Client> clienti = new ArrayList<Client>();

    void addClient(Client client) {
        clienti.add(client);
    }

    Client getClient(int cont) {
        return clienti.get(cont);
    }

    ArrayList<Client> getClienti() {
        return clienti;
    }
}
