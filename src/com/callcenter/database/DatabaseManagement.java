/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.callcenter.database;

import com.callcenter.entity.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author burakatlay
 */
public class DatabaseManagement {

    public Employee loginUser(String userName, String userPassword) throws SQLException, ClassNotFoundException {

        Employee employee = null;
        try (Connection connection = DatabaseUtilities.getConnection()) {
            String sql = "select * from employee where employeeName = ? and employeepassword = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, userName);
            statement.setString(2, userPassword);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                employee = new Employee(
                        resultSet.getInt("employeeid"),
                        resultSet.getString("employeename"),
                        resultSet.getString("employeesurname"),
                        resultSet.getString("employeenickname"),
                        resultSet.getString("employeeemail"),
                        resultSet.getString("employeepassword"),
                        resultSet.getString("employeephoto")
                );
            }
        }
        return employee;
    }
}
