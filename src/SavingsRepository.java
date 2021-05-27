package repository;
import Clase.Checking;
import Clase.Cont;
import Clase.Savings;
import Config.SQLConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SavingsRepository {
    public static void insertSavings(Savings savings) {
        String sql1 = "INSERT INTO `savings` (`savings_id`, `tipulContului`) VALUES (?,?)";
        Connection connection = SQLConfig.getDataBaseConnection();

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql1)) {
            ContRepository.insertCont(
                    new Cont(savings.getCont_id(), savings.getBalanta(), savings.getDobanda(), savings.getNumarCont())
            );
            PreparedStatement statement = connection.prepareStatement(sql1);
            statement.setInt(1, savings.getSavings_id());
            statement.setString(2, savings.getTipulContului());

            statement.executeUpdate();
            System.out.println("Contul Savings a fost adaugat");
        }catch (SQLException exception) {
            System.err.println("Nu se poate insera in tabel");
        }
    }


    public static void deleteSavingsById(int id) {
        String sql = "DELETE FROM `savings` WHERE `savings_id`=?";
        Connection connection = SQLConfig.getDataBaseConnection();
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Contul savings cu id-ul " + id + " a fost sters");
        }catch (SQLException exception) {
            System.err.println("Contul savings nu a putut fi sters");
        }
    }
}


