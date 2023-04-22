package org.example;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private final static Logger LOGGER = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        String dbLocation = "localhost:3306";
        String dbName = "jdbc_db2";
        String dbUser ="root";
        String dbPassword = "12Irina2022."; // parola din baza de date

        // MySqlDataSource <- vine din mysql connector si o folosim ca sa configuram conexiunea
        MysqlDataSource dataSource = new MysqlDataSource();
        // Formatul pentru url-ul de conectare la baza de date
        // jdbc:mysql://<<locatia server-ului de baze de date>>/<<numele bazei de date>>
        // jdbc:mysql://localhost:3306/jdbc_db
        dataSource.setUrl("jdbc:mysql://" + dbLocation + "/" + dbName);
        dataSource.setUser(dbUser);
        dataSource.setPassword(dbPassword);

        try{
            LOGGER.log(Level.INFO, "Trying to connect to db");
            Connection connection = dataSource.getConnection();
            LOGGER.log(Level.INFO, "Connection successful" );
        } catch (SQLException sqlException){
            sqlException.printStackTrace();
            LOGGER.log(Level.SEVERE, "Error when connecting to database " + dbName + "from " + dbLocation +
                    "with user" + dbUser);
            LOGGER.log(Level.SEVERE, sqlException.getStackTrace().toString());
        }
    }
}
