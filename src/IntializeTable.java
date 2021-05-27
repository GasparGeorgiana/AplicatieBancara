package Config;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class IntializeTable {
    public static void setUpDb() {
        List<String> SQLTables = new ArrayList<>();

        // CONT

        SQLTables.add("create table if not exists cont\n" +
                "(\n" +
                "\tcont_id int not null,\n" +
                "    balanta double not null,\n" +
                "    dobanda double not null,\n" +
                "    numarCont int not null,\n" +
                "    numarDeConturi int not null,\n" +
                "    primary key (cont_id),\n" +
                ");");

        // CLIENT

        SQLTables.add("create table if not exists client\n" +
                "(\n" +
                "\tclient_id int not null,\n" +
                "    nume varchar(45) not null,\n" +
                "    prenume varchar(45) not null,\n" +
                "    CNP varchar(45) not null,\n" +
                "    foreign key (cont_id) references cont(cont_id) on delete cascade\n" +
                "    primary key (client_id)\n" +
                ");");

        // CHECKING

        SQLTables.add("create table if not exists checking\n" +
                "(\n" +
                "\tchecking_id int not null,\n" +
                "    tipulContului varchar(45) not null,\n" +
                "    primary key (checking_id),\n" +
                "    foreign key (cont_id) references cont(cont_id) on delete cascade\n" +
                ");");

        // SAVINGS

        SQLTables.add("create table if not exists savings\n" +
                "(\n" +
                "\tsavings_id int not null,\n" +
                "    tipulContului varchar(45) not null,\n" +
                "    primary key (savings_id),\n" +
                "    foreign key (cont_id) references cont(cont_id) on delete cascade\n" +
                ");");


        Connection dataBaseConnection = SQLConfig.getDataBaseConnection();

        for(String table : SQLTables) {
            try(Statement statement = dataBaseConnection.createStatement()) {
                statement.execute(table);
                System.out.println("Tabelul a fost creat cu succes");
            }catch (SQLException exception) {
                System.out.println("Tabelul nu a putut fi creat\n" + exception.getMessage());
            }
        }
    }
    private IntializeTable() {

    }
}
