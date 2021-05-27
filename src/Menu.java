import Clase.*;
import repository.CheckingRepository;
import repository.ClientRepository;
import repository.ContRepository;
import repository.SavingsRepository;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    Scanner keyboard = new Scanner(System.in);
    Banca banca = new Banca();
    boolean exit;

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.runMenu();
        /*
        Cont cont1 = new Cont(2, 12.3, 10, 12345);
        ContRepository.insertCont(new Cont(1, 100.2, 20, 123));
        ContRepository.updateContBalantaById(12.5, 1);
        ContRepository.deleteContById(1);
        ClientRepository.insertClient(new Client(1, "Ionel", "0127327843", "Costea", cont1));
        ClientRepository.updateClientNumeById("Costel", 1);
        ClientRepository.deleteClientById(1);
        CheckingRepository.insertChecking(new Checking(1, 24.5, 12, 134, 1));
        CheckingRepository.deleteCheckingById(1);
        SavingsRepository.insertSavings(new Savings(2, 34.6, 20, 534, 1));
        SavingsRepository.deleteSavingsById(1);
         */
    }

    public void runMenu() {
        paginaDePornire();
        while (!exit) {
            afiseazaMeniul();
            int choice = introduceOptiunea();
            executareOptiune(choice);
        }
    }

    private void paginaDePornire() {
        System.out.println("+-----------------------------------------------------------------------+");
        System.out.println("|                  Bine ati venit la Raiffaisen Bank!                   |");
        System.out.println("|   Faci banking de la distanta, fara sa mai suni sau sa vii la banca   |");
        System.out.println("+-----------------------------------------------------------------------+");
    }

    private void afiseazaMeniul() {
        System.out.println("Te rugam sa faci o selectie: ");
        System.out.println("1) Creeaza un nou cont");
        System.out.println("2) Realizeaza o depunere");
        System.out.println("3) Realizeaza o retragere");
        System.out.println("4) Balanta contului");
        System.out.println("0) Exit");
    }

    private int introduceOptiunea() {
        int choice = -1;
        do {
            System.out.println("Introduceti numarul!");
            try {
                choice = Integer.parseInt(keyboard.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Selectare invalida! Introduceti doar numere!");
            }
            if (choice < 0 || choice > 4) {
                System.out.println("Selectarea nu exista! Va rugam sa introduceti din nou!");
            }
        } while (choice < 0 || choice > 4);
        return choice;
    }

    private void executareOptiune(int choice) {
        switch (choice) {
            case 0:
                System.out.println("Multumim pentru utilizarea aplicatiei!");
                break;
            case 1:
                creeazaCont();
                break;
            case 2:
                realizeazaDepunere();
                break;
            case 3:
                realizeazaRetragere();
                break;
            case 4:
                balantaContului();
                break;
            default:
                System.out.println("A aparut o eroare!");
        }
    }

    private void creeazaCont() {
        String nume;
        String prenume;
        String CNP;
        String tipulContului = "";
        double depunereInitiala = 0;
        boolean valid = false;
        while (!valid) {
            System.out.print("Va rugam sa introduceti tipul contului(checking/savings): ");
            tipulContului = keyboard.nextLine();
            if (tipulContului.equalsIgnoreCase("savings") || tipulContului.equalsIgnoreCase("checking")) {
                valid = true;
            } else {
                System.out.println("Tipul contului selectat este invalid. Te rugam sa introduci savings sau checkings");
            }
        }
        System.out.print("Va rugam sa va introduceti numele: ");
        nume = keyboard.nextLine();
        System.out.print("Va rugam sa va introduceti numarul de CNP: ");
        CNP = keyboard.nextLine();
        System.out.print("Va rugam sa va introduceti prenumele: ");
        prenume = keyboard.nextLine();
        valid = false;
        while (!valid) {
            System.out.print("Va rugam sa introduceti o depunere initiala: ");
            try {
                depunereInitiala = Double.parseDouble(keyboard.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Depunerea trebuie sa fie un numar!");
            }

            if (tipulContului.equalsIgnoreCase("checking")) {
                if (depunereInitiala < 100) {
                    System.out.println("Trebuie sa depuneti o suma minima de 100 de lei pentru a deschide contul de checking!");
                } else {
                    valid = true;
                }
            } else if (tipulContului.equalsIgnoreCase("savings")) {
                if (depunereInitiala < 50) {
                    System.out.println("Trebuie sa depuneti o suma minima de 50 de lei pentru a deschide contul de savings!");
                } else {
                    valid = true;
                }
            }

        }
        Cont cont;
        tipulContului = keyboard.nextLine();
        if (tipulContului.equalsIgnoreCase("checking")) {
            cont = new Checking(1,depunereInitiala, 12, 123, 5);
        } else {
            cont = new Savings(2,depunereInitiala, 15, 158, 5);
        }
        Client client = new Client(10, nume, prenume, CNP, cont);
        banca.addClient(client);
    }

    private void realizeazaDepunere() {
        int cont = selecteazaCont();
        if (cont >= 0) {
            System.out.print("Ce suma ati dori sa depuneti?: ");
            double suma = 0;
            try {
                suma = Double.parseDouble(keyboard.nextLine());
            } catch (NumberFormatException e) {
                suma = 0;
            }
            banca.getClient(cont).getCont().depunere(suma);
        }
    }

    private void balantaContului() {
        int cont = selecteazaCont();
        if (cont >= 0) {
            System.out.println(banca.getClient(cont).getCont());
        }
    }

    private void realizeazaRetragere() {
        int cont = selecteazaCont();
        if (cont >= 0) {
            System.out.print("Ce suma ati dori sa extrageti?: ");
            double suma = 0;
            try {
                suma = Double.parseDouble(keyboard.nextLine());
            } catch (NumberFormatException e) {
                suma = 0;
            }
            banca.getClient(cont).getCont().retragere(suma);
        }
    }

    private int selecteazaCont() {

        ArrayList<Client> clienti = banca.getClienti();
        if(clienti.size() <= 0) {
            System.out.println("Niciun client la banca ta");
            return -1;
        }
        System.out.println("Selecteaza un cont:");
        for(int i = 0; i < clienti.size(); i++) {
            System.out.println((i+1) + ") " + clienti.get(i).basicInfo());
        }
        int cont = 0;
        System.out.print("Va rugam sa introduceti selectia contului: ");
        try{
            cont = Integer.parseInt(keyboard.nextLine()) - 1;
        }
        catch(NumberFormatException e) {
            cont = -1;
        }
        if(cont < 0 || cont > clienti.size()) {
            System.out.println("Clase.Cont invalid selectat!");
            cont = -1;
        }
        return cont;
    }
}
