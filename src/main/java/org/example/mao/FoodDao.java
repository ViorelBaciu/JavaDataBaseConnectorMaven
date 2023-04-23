package org.example.mao;

import org.example.model.Food;


import java.awt.*;
import java.sql.SQLException;

public interface FoodDao {

    // create table
    void createTable() throws SQLException;

    //adaugare date  CREATE food
    void create(Food food) throws SQLException;

    // gasire date   READ food
    List<Food> read() throws SQLException;
    // modificare date   UPDATE food

    // stergere date   DELETE food

    // sters table
    void dropTable() throws SQLException;
}
