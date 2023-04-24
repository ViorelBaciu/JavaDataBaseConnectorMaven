package org.example;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.example.dao.AnimalDao;
import org.example.dao.AnimalDaoImpl;
import org.example.mao.FoodDao;
import org.example.mao.FoodDaoImpl;
import org.example.model.Animal;


import org.example.model.Food;

import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private final static Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        String dbLocation = "localhost:3306";
        String dbName = "jdbc_db2";
        String dbUser = "root";
        String dbPassword = "12Irina2022."; // parola din baza de date

        // MySqlDataSource <- vine din mysql connector si o folosim ca sa configuram conexiunea
        MysqlDataSource dataSource = new MysqlDataSource();
        // Formatul pentru url-ul de conectare la baza de date
        // jdbc:mysql://<<locatia server-ului de baze de date>>/<<numele bazei de date>>
        // jdbc:mysql://localhost:3306/jdbc_db
        dataSource.setUrl("jdbc:mysql://" + dbLocation + "/" + dbName);
        dataSource.setUser(dbUser);
        dataSource.setPassword(dbPassword);

        try {
            LOGGER.log(Level.INFO, "Trying to connect to db");
            Connection connection = dataSource.getConnection();
            LOGGER.log(Level.INFO, "Connection successful");

            AnimalDao animalDao = new AnimalDaoImpl(connection);
            FoodDao foodDao = new FoodDaoImpl(connection);


            // statement <- used for transfering sql commands to db server
            Statement statement = connection.createStatement();

            animalDao.createTable();
            LOGGER.info("Created table animals");


            animalDao.create(new Animal(null, "Lucky", "dog"));
            animalDao.create(new Animal(null, "Rex", "dog"));
            animalDao.create(new Animal(null, "Lulu", "cat"));
            LOGGER.info("Data insertion was successful");
            animalDao.deleteAnimal(1);
            LOGGER.info("The method for delete an information from animal was succesfully");


//            carDao.createTable();
//            carDao.createCar(new Car(null, " Renault ", Date.valueOf("2008-10-07")));
//            carDao.createCar(new Car(null, " Renault23 ", Date.valueOf("2008-10-07")));
//            carDao.updateCar(new Car(1, "BMW", Date.valueOf("2011-02-12")));
//            List<Car> cars = carDao.readAllCars();
            System.out.println("Masinile din baza de date sunt : ");

            // de verificat inca o data acest for
//            for (Car c : cars) {
//                System.out.println(c);
//            }

            Date expirationDate = Date.valueOf("2024-10-12");
            foodDao.create(new Food(null, "Ciocolata", " ciocolata de casa",
                    550, expirationDate));
            foodDao.create(new Food(null, "Alune", " pung de 500g de alune prajite",
                    650, expirationDate));

            // pentru ca este un varchar , intelij se asteapta sa fie scris intre ghilimele
            statement.execute(" update Animals Set Name = \" Dog2 \" where Id = 2 ");

            animalDao.createTable();
            foodDao.createTable();

            LOGGER.info("Tables create was successfull");


            // Intotdeauna trebuie rulat.execute() daac vrem sa fie executat codul sql de baza de date
//            preparedStatement.execute();


            ResultSet rs = statement.executeQuery("SELECT * FROM animals");
            while (rs.next() == true) {
                System.out.println("Id: " + rs.getInt(1));
                System.out.println("Name: " + rs.getString(2));
                System.out.println("Species: " + rs.getString(3));
            }
            // display all foods
            //Food:
            // 1. ciocolata - ciocolata de casa - 550kcal per 100 g - expira la 2024-10-12
            // 2. alune - punga de 500g de alune prajite - 600kcal per 100g - expira la 2024-10-12

            ResultSet rs1 = statement.executeQuery("SELECT * FROM food where calories_per_100 < 600");
            // order by calore desc
            System.out.println("Food");
            while (rs1.next() == true) {
                System.out.println("Id: " + rs1.getInt(1));
                System.out.println("Name: " + rs1.getString(2));
                System.out.println("Description: " + rs1.getString(3));
                System.out.println("Calories_per_100: " + rs1.getInt(4));
                System.out.println("Expiration_date: " + rs1.getDate(5));
            }

            animalDao.dropTable();
            foodDao.dropTable();
//            carDao.dropTable();
            LOGGER.info("Tables crated was succesful");

            // ca sa salvam


        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            LOGGER.log(Level.SEVERE, sqlException.getMessage());
            sqlException.getStackTrace();
        }
    }
}
