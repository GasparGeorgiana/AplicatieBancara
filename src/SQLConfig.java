package Config;

import Exception.SQLCustomException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConfig {
    private static Connection connection;
    private static String URL = "jdbc:mysql://localhost:3306/sys";
    private static String USER = "root";
    private static String PASSWORD = "parola";

    public static Connection getDataBaseConnection() {

        try {
            if(connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Successfully connected to DB");
            }
        } catch(SQLException exception) {
            throw new SQLCustomException("Can not connect to db", exception);
        }
        return connection;
    }

    public static void closeDataBaseCOnnection() {
        try {
            if(connection != null & !connection.isClosed()) {
                connection.close();
            }
        }catch (SQLException exception) {
            throw new SQLCustomException("Can not close connection to db", exception);
        }
    }

    private SQLConfig(){

    }
}
