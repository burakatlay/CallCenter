/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.callcenter.database;

import com.callcenter.entity.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author burakatlay
 */
public class EmployeeProcesses {

    public int insert(Employee employee) throws SQLException, ClassNotFoundException {
        int affected;//
        try (Connection connection = DatabaseUtilities.getConnection()) {
            String sql = "insert into employee(employee_name,employee_surname,employee_password,employee_nick_name,employee_email,employee_photo) values(?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, employee.getEmployeeName());
            statement.setString(2, employee.getEmployeeSurname());
            statement.setString(3, employee.getPassword());
            statement.setString(4, employee.getEmployeeNickName());
            statement.setString(5, employee.getEmail());
            statement.setString(6, employee.getPhoto());
            affected = statement.executeUpdate();
            connection.close();
        }
        return affected;

    }

    public Employee getEmloyee(int employeeId) throws ClassNotFoundException, SQLException {
        Employee employee = null;
        try (Connection connection = DatabaseUtilities.getConnection()) {
            String sql = "select * from employee where employee_id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, employeeId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String employeeName = resultSet.getString("employee_name");
                String employeeSurname = resultSet.getString("employee_surname");
                String employeeNickName = resultSet.getString("employee_nick_name");
                String email = resultSet.getString("employee_email");
                String password = resultSet.getString("employee_password");
                String photo = resultSet.getString("employee_photo");
                employee = new Employee(employeeId, employeeName, employeeSurname, employeeNickName, email, password, photo);
            }
        }
        return employee;
    }

    public int updateEmployee(Employee employee) throws ClassNotFoundException, SQLException {
        
        int affected;
        try (Connection connection = DatabaseUtilities.getConnection()) {
            String sql = "update employee set employee_name=?, employee_surname=?, employee_nick_name=?, employee_email=?, employee_password=?, employee_photo=? where employee_id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, employee.getEmployeeName());
            statement.setString(2, employee.getEmployeeSurname());
            statement.setString(3, employee.getEmployeeNickName());
            statement.setString(4, employee.getEmail());
            statement.setString(5, employee.getPassword());
            statement.setString(6, employee.getPhoto());
            statement.setInt(7, employee.getEmployeeId());
            affected = statement.executeUpdate();
        }

        return affected;
    }

}
