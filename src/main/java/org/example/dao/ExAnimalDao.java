package org.example.dao;

import org.example.model.ExAnimal;

import java.sql.SQLException;
import java.util.List;

public interface ExAnimalDao {

    // create table
    public void createTable()throws SQLException;

    // adaugare date  CREATE animals
    public void create(ExAnimal exAnimal)throws SQLException;

    // gasire date   READ animals
    public List<ExAnimal> read()throws SQLException;
    // modificare date   DELETE from exanimals
    public void deleteExAnimal(Integer animalId) throws SQLException;

    // sters table
    public void dropTable()throws SQLException;
}
