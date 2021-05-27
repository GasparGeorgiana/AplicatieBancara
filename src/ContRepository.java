package repository;
import Clase.Cont;
import Config.SQLConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContRepository {
    public static void insertCont(Cont cont) {

        String sql1 = "INSERT INTO `cont` (`cont_id`, `balanta`, `dobanda`, `numarCont`) VALUES (?,?,?,?)";
        Connection connection = SQLConfig.getDataBaseConnection();

        try{
            PreparedStatement statement = connection.prepareStatement(sql1);
            statement.setInt(1, cont.getCont_id());
            statement.setInt(2, cont.getNumarCont());
            statement.setDouble(3, cont.getBalanta());
            statement.setDouble(4, cont.getDobanda());

            statement.executeUpdate();
            System.out.println("Contul a fost adaugat");
        }catch (SQLException exception) {
            System.err.println("Nu se poate insera in tabel");
        }
    }

    public static void updateContBalantaById(Double newBalanta, int id) {
        String sql = "UPDATE `cont` c \n" +
                "SET c.`balanta` = ? \n" +
                "WHERE `cont_id` = ?";
        Connection connection = SQLConfig.getDataBaseConnection();
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDouble(1, newBalanta);
            statement.setInt(2, id);
            statement.executeUpdate();

            System.out.println("Balanta contului cu id-ul " + id + " a fost schimbata");
        }catch (SQLException exception) {
            System.err.println("Nu s-a putut schimba balanta contului " + id);
        }
    }

    public static void deleteContById(int id) {
        String sql = "DELETE FROM `cont` WHERE `cont_id`= ?";
        Connection connection = SQLConfig.getDataBaseConnection();
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Contul cu id-ul " + id + " a fost sters");
        }catch (SQLException exception) {
            System.err.println("Contul nu a putut fi sters");
        }
    }
}
