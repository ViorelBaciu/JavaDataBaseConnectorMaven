package org.example;

import com.mysql.cj.jdbc.MysqlDataSource;

public class ExMain {
    public static void main(String[] args) {
        String dbLocatin = "localhost:3360";
        String dbName = "jdbc_db3";
        String dbUser = "root";
        String dbPassword = "12Irina2022.";

        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl("jdbc:mysql://" + dbLocatin + "/" + dbName);
        dataSource.setUser(dbUser);
        dataSource.setPassword(dbPassword);
    }
}
