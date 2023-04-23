package org.example.model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface CarDao {

    @Override
    public void createTable()throws SQLException{

    }
    @Override
    public void createCar (Car car ) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement("insert into cars(name, anul_fabricatiei" +
                "values(?,?)");
        preparedStatement.setString(1, car.getName());
        preparedStatement.setDate(2,car.getAnulFabricatiei());
        preparedStatement.execute();
    }
}
