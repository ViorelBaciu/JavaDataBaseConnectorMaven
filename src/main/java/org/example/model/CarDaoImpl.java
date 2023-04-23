package org.example.model;
// atribut de clasa - atribute - constructori - geterii setterii - metode
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class CarDaoImpl implements CarDao{
    // Design Pattern de single
    // este un obiect pe care il apelezi de fiecare data
    // treubie un constructor de timp connection ca sa putem trimite la acest constructor de fiecare data referinta
    private static Logger
    private final Connection connection ;

    public CarDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void createTable() throws SQLException {
        // ne trebuie un Statement ca sa putem accesa baza de date
        Statement statement = connection.createStatement();
        statement.execute("Create table cars(id integer auto_increment primary key," +
                " name varchar(30), anul_fabricatiei date)");
    }
}
