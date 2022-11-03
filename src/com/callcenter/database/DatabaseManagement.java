package com.callcenter.database;

import com.callcenter.entity.Employee;
import com.callcenter.library.database.DatabaseUtilities;
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
        Connection connection = DatabaseUtilities.getConnection();
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
                    resultSet.getString("employeephoto"),
                    resultSet.getString("employeepassword"),
                    resultSet.getString("employeeemail"),
                    resultSet.getString("employeenickname")
            );
        }
        connection.close();
        return employee;
    }
}
