package org.example;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.example.dao.ExAnimalDao;
import org.example.dao.ExAnimalDaoImpl;
import org.example.model.ExAnimal;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExMain {
    private final static Logger LOGGER = Logger.getLogger(ExMain.class.getName());
    public static void main(String[] args) {
        String dbLocatin = "localhost:3306";
        String dbName = "jdbc_db3";
        String dbUser = "root";
        String dbPassword = "12Irina2022.";

        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl("jdbc:mysql://" + dbLocatin + "/" + dbName);
        dataSource.setUser(dbUser);
        dataSource.setPassword(dbPassword);
        try{
            LOGGER.log(Level.INFO, " Trying to connect DataBase");
            Connection connection = dataSource.getConnection();
            LOGGER.log(Level.INFO, "Connection succesful");

            ExAnimalDao exAnimalDao = new ExAnimalDaoImpl(connection);
            Statement statement = connection.createStatement();

            // create table
            exAnimalDao.createTable();
            LOGGER.info("Create Table ExAnimals");

            // insert values
            exAnimalDao.create(new ExAnimal(null, "Lucky", "Dog"));
            exAnimalDao.create(new ExAnimal(null, "Rex", "Dog"));
            exAnimalDao.create(new ExAnimal(null, "Mitzi","Cat"));
            exAnimalDao.create(new ExAnimal(null, "Pego","Cat"));
            exAnimalDao.create(new ExAnimal(null, "Pago","Parrot"));
            exAnimalDao.create(new ExAnimal(null, "Piper", "Parrot"));
            LOGGER.info("Data insertion was successful");

            // read Table
            ResultSet rs = statement.executeQuery("SELECT * FROM exanimals");
            while(rs.next() == true){
                System.out.println("Id: " + rs.getInt(1));
                System.out.println("Name: " + rs.getString(2));
                System.out.println("Species: " + rs.getString(3));
            }

            // delete from Table
            exAnimalDao.deleteExAnimal(1);
            LOGGER.info("The method for delete an information from animal has been succesfully");

            // drop Table - stergere tabel
            // exAnimalDao.dropTable();
            // LOGGER.info("Table has been deleted");


        }catch (SQLException sqlException){
            sqlException.printStackTrace();
            LOGGER.log(Level.SEVERE, sqlException.getMessage());
            sqlException.getStackTrace();
        }
    }
}
