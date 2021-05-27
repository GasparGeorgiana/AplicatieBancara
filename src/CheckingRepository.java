package repository;
import Clase.Checking;
import Clase.Cont;
import Config.SQLConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CheckingRepository {
    public static void insertChecking(Checking checking) {
        String sql1 = "INSERT INTO `checking` (`checking_id`, `tipulContului`) VALUES (?,?)";
        Connection connection = SQLConfig.getDataBaseConnection();

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql1)) {
            ContRepository.insertCont(
                    new Cont(checking.getCont_id(), checking.getBalanta(), checking.getDobanda(), checking.getNumarCont())
            );

            PreparedStatement statement = connection.prepareStatement(sql1);
            statement.setInt(1, checking.getChecking_id());
            statement.setString(2, checking.getTipulContului());

            statement.executeUpdate();
            System.out.println("Contul Checking a fost adaugat");
        }catch (SQLException exception) {
            System.err.println("Nu se poate insera in tabel");
        }
    }

    public static void deleteCheckingById(int id) {
        String sql = "DELETE FROM `checking` WHERE `id_checking`=?";
        Connection connection = SQLConfig.getDataBaseConnection();
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Contul checking cu id-ul " + id + " a fost sters");
        }catch (SQLException exception) {
            System.err.println("Contul checking nu a putut fi sters");
        }
    }
}


