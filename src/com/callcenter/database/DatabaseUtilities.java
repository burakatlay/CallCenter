/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.callcenter.database;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author burakatlay
 */
public class DatabaseUtilities {

//    public static String url = "jdbc:postgresql://localhost:5432/callcenter";
//    public static String name = "";
//    public static String password = "";
    
//    public static String url = "";
//    public static String name = "";
//    public static String password = "";
    
    public static String url = "jdbc:mysql://localhost:3306/call_center";
    public static String name = "";
    public static String password = "";
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, name, password);
        return conn;
    }
}
