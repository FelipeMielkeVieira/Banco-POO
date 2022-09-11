package br.senai.sc.banco.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public static final String URL = "jdbc:mysql://localhost:3306/banco";
    public static final String USER = "root";
    public static final String PASSWORD = "root";

    public Connection conectaBD() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
