package org.example.model;
// atribut de clasa - atribute - constructori - geterii setterii - metode
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

//public class CarDaoImpl implements CarDao{
//    // Design Pattern de single
//    // este un obiect pe care il apelezi de fiecare data
//    // treubie un constructor de timp connection ca sa putem trimite la acest constructor de fiecare data referinta
//    private static Logger
//    private final Connection connection ;
//
//    public CarDaoImpl(Connection connection) {
//        this.connection = connection;
//    }
//
//    @Override
//    public void createTable() throws SQLException {
//        // ne trebuie un Statement ca sa putem accesa baza de date
//        Statement statement = connection.createStatement();
//        statement.execute("Create table cars(id integer auto_increment primary key," +
//                " name varchar(30), anul_fabricatiei date)");
//    }
//    @Override
//    public void create (Car car) throws SQLException{
//        PreparedStatement preparedStatement = connection.prepareStatement("insert into cars(name, anul_fabricatiei) values(?,?)");
//        preparedStatement.setString(1,car.getName());
//        preparedStatement.setDate(2,car.getAnulFabricatiei());
//        preparedStatement.execute();
//    }
//    // asa afisam in consola
//    @Override
//    public List<Car> readAllCars() throws SQLException{
//        Statement statement = connection.createStatement();
//        ResultSet rs = statement.executeQuery("SELECT * FROM cars");
//        List<Car> carList = new ArrayList<>();
//        while( rs.next() == true){
//            Car car = new Car();
//            car.setName(rs.getString(2));
//            car.setAnulFabricatiei(rs.getDate(3));
//            car.setId(rs.getInt(1));
//            carList.add(car);
//        }
//        return carList;
//    }
//    @Override
//    public void updateCar(Car updatedCar) throws SQLException{
//        PreparedStatement preparedStatement = connection.prepareStatement("update cars set name = ?," +
//                " anul_fabricatiei = ? where id = ?");
//        preparedStatement.setString(1, updatedCar.getName());
//        preparedStatement.setDate(2, updatedCar.getAnulFabricatiei());
//        preparedStatement.setInt(3, updatedCar.getId());
//        preparedStatement.executeUpdate();
//    }
//}
