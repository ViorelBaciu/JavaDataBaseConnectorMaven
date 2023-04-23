package org.example.mao;

import java.sql.SQLException;

public interface FoodMao {

    // create table
    void createTable() throws SQLException;

    //adaugare date  CREATE food

    // gasire date   READ food

    // modificare date   UPDATE food

    // stergere date   DELETE food

    // sters table
    void dropTable() throws SQLException;
}
