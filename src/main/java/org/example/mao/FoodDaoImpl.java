package org.example.mao;

import org.example.model.Food;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class FoodDaoImpl implements FoodDao {

    private final Connection connection;

    public FoodDaoImpl(Connection connection){
        this.connection = connection;
    }

    @Override
    public void createTable() throws SQLException{
        Statement statement = connection.createStatement();
        statement.execute("create table if not exists food (id integer auto_increment, " +
                "name varchar(100)," +
                "description varchar(100), " +
                "calories_per_100 integer," +
                "expiration_date date," +
                "primary key(id) )");
    }
    @Override
    public void create(Food food) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement(
                "insert into food(name,species) values(?,?)"
        );
        preparedStatement.setInt(1,food.getId());
        preparedStatement.setString(2,food.getName());
        preparedStatement.setString(3,food.getDescription());
        preparedStatement.setInt(4,food.getCalories_per_100());
        preparedStatement.setDate(4,food.getExpiration_date());
        preparedStatement.execute();
    }
    @Override
    public void dropTable() throws SQLException{
        Statement statement = connection.createStatement();
        statement.execute("drop table food");
    }

}
