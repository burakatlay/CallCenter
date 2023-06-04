/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.callcenter.img;

import com.callcenter.database.DatabaseUtilities;
import static com.callcenter.database.DatabaseUtilities.name;
import static com.callcenter.database.DatabaseUtilities.password;
import static com.callcenter.database.DatabaseUtilities.url;
import com.callcenter.entity.Employee;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author burakatlay
 */
public class test {

    public static String url = "jdbc:postgresql://localhost:5432/callcenter";
    public static String name = "postgres";
    public static String password = "52579485";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        Class.forName("org.postgresql.Driver");
//        Connection conn = DriverManager.getConnection(url, name, password);

//        Employee employee = new Employee(2, "burak", "atlay", "deneme2", "deneme@deneme", "deneme", "deneme1");
//        
//        int affected;
//        try (Connection connection = DatabaseUtilities.getConnection()) {
//            String sql = "insert into employee(employeename,employeesurname,password,nickname,email,photo) values(?,?,?,?,?,?)";
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setString(1, employee.getEmployeeName());
//            statement.setString(2, employee.getEmployeeSurname());
//            statement.setString(3, employee.getPassword());
//            statement.setString(4, employee.getEmployeeNickName());
//            statement.setString(5, employee.getEmail());
//            statement.setString(6, employee.getPhoto());
//            affected = statement.executeUpdate();
//        }
//        System.out.println("kayıt sayısı"+affected);
//        conn.close();
//        Employee employee = null;
//        try (Connection connection = DatabaseUtilities.getConnection()) {
//            String sql = "select * from employee where employeid=?";
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setLong(1, 3);
//            ResultSet resultSet = statement.executeQuery();
//            if (resultSet.next()) {
//                String employeeName = resultSet.getString("employeename");
//                String employeeSurname = resultSet.getString("employeesurname");
//                String employeeNickName = resultSet.getString("nickname");
//                String email = resultSet.getString("email");
//                String password = resultSet.getString("password");
//                String photo = resultSet.getString("photo");
//                employee = new Employee(3, employeeName, employeeSurname, employeeNickName, email, password, photo);
//            }
//        }
        Employee employee = new Employee(3, "Deneme", "Deneme", "", "", "", "");
        int employeeId = employee.getEmployeeId();
        
        try (Connection connection = DatabaseUtilities.getConnection()) {
            String sql = "update employee set employeename=?, employeesurname=?, password=?, nickname=?, email=?, photo=? where employeeid=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, employee.getEmployeeName());
            statement.setString(2, employee.getEmployeeSurname());
            statement.setString(3, employee.getPassword());
            statement.setString(4, employee.getEmployeeNickName());
            statement.setString(5, employee.getEmail());
            statement.setString(6, employee.getPhoto());
            statement.setInt(7, employee.getEmployeeId());
            statement.executeUpdate();
        }

//        
    }
}
