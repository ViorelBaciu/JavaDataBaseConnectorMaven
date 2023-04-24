package org.example.dao;


import org.example.model.ExAnimal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ExAnimalDaoImpl implements ExAnimalDao{
    private final Connection connection;

    public ExAnimalDaoImpl( Connection connection){
        this.connection = connection;
    }
    @Override
    public void createTable()throws SQLException{
        Statement statement = connection.createStatement();
        statement.execute(" create table if not exists exAnimals" +
                "(id integer auto_increment," +
                "name varchar(100), species varchar(100), primary key(id))");
    }
    @Override
    public void create(ExAnimal exAnimal) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement(
                "insert into exanimals(name, species) values(?,?)"
        );
        preparedStatement.setString(1,exAnimal.getName());
        preparedStatement.setString(2,exAnimal.getSpecies());
        preparedStatement.execute();
    }
    @Override
    public List<ExAnimal> read()throws SQLException{
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM exanimals");

        List<ExAnimal> exanimals = new ArrayList<>();
        while(rs.next() == true){
            ExAnimal exAnimal = new ExAnimal();
            exAnimal.setId(rs.getInt(1));
            exAnimal.setName(rs.getString(2));
            exAnimal.setSpecies(rs.getString(3));
            exanimals.add(exAnimal);
        }
        return exanimals;
    }
    @Override
    public void deleteExAnimal(Integer animalId)throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement
                ("Delete from Exanimals where Id = ?");
        preparedStatement.setInt(1, animalId);
        preparedStatement.execute();
    }
    @Override
    public void dropTable()throws SQLException{
        Statement statement = connection.createStatement();
        statement.execute("drop table exanimals");
    }

}
