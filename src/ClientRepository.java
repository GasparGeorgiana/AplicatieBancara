package repository;
import Clase.Client;
import Config.SQLConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientRepository {
    public static void insertClient(Client client) {
        String sql1 = "INSERT INTO `client` (`client_id`, `nume`, `prenume`, `CNP`) VALUES (?,?,?,?)";
        Connection connection = SQLConfig.getDataBaseConnection();

        try{
            PreparedStatement statement = connection.prepareStatement(sql1);
            statement.setInt(1, client.getClient_id());
            statement.setString(2, client.getNume());
            statement.setString(3, client.getPrenume());
            statement.setString(4, client.getCNP());

            statement.executeUpdate();
            System.out.println("Clientul a fost adaugat");
        }catch (SQLException exception) {
            System.err.println("Nu se poate insera in tabel");
        }
    }

    public static void updateClientNumeById(String newNume, int id) {
        String sql = "UPDATE `client` SET `nume`=? WHERE `client_id`=?";
        Connection connection = SQLConfig.getDataBaseConnection();
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, newNume);
            statement.setInt(2, id);
            statement.executeUpdate();

            System.out.println("Numele clientului cu id-ul " + id + " a fost schimbat");
        }catch (SQLException exception) {
            System.err.println("Nu s-a putut schimba numele clientului " + id);
        }
    }

    public static void deleteClientById(int id) {
        String sql = "DELETE FROM `client` WHERE `client_id`=?";
        Connection connection = SQLConfig.getDataBaseConnection();
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Clientul cu id-ul " + id + " a fost sters");
        }catch (SQLException exception) {
            System.err.println("Clientul nu a putut fi sters");
        }
    }
}
