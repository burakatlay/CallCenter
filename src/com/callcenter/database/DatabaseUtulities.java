/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.callcenter.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author burakatlay
 */
public class DatabaseUtulities {
    public static String url = "jdbc:postgresql://localhost:5432/callcenter";
    public static String name = "postgres";
    public static String password = "52579485";

    
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection(url, name, password);
        return conn;
    }
}
