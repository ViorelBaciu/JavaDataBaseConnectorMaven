package org.example.dao;

import org.example.model.Animal;

import java.awt.*;
import java.sql.SQLException;

// Animal Data Access Object <- clasa pentru a accesa date din "animals"
// manipulare structura baya de date( creare si stergere tabel)
// manipulare date = CRUD
public interface AnimalDao {

    // creat table
    // de verificat inca o data
    void createTable() throws SQLException;

    //adaugare date      CREATE animals
    void create(Animal animal) throws SQLException;

    //gasire date        READ animals
    List<Animal> read() throws SQLException;
    //modificare date    UPDATE animals

    // stergere date     DELETE animals

    //sters table
    void dropTable() throws SQLException;
}
