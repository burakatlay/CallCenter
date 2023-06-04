/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.callcenter.database;

import com.callcenter.entity.Employee;
import com.callcenter.entity.SubProject;
import com.callcenter.entity.Working;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author burakatlay
 */
public class PrintProcesses {
    
    private Working working = null;
    private Employee employee;
    private SubProject subProject = new SubProject(0, "");
    private int affected = 0;
    private int count = 0;
    private Connection connection;
    private PreparedStatement statement;
    private String sql;
    private java.sql.ResultSet resultSet;
    private double bonus = 0.0;
    long millis = System.currentTimeMillis();  
    java.sql.Date date = new java.sql.Date(millis);
    
    public ArrayList<Working> workingWiev() throws ClassNotFoundException, SQLException{
        
        ArrayList<Working> workings = new ArrayList<>();
        
        connection = DatabaseUtilities.getConnection();
        sql = "select * from working";
        statement = connection.prepareStatement(sql);
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            working = new Working();
            working.setWorkingId(resultSet.getInt("working_id"));
            working.setEmployee(findEmployee(resultSet.getInt("employee_id")));//buraya employe bulup bilgisini getir.
            working.setSubProject(findSubProject(resultSet.getInt("sub_project_id")));//buraya sub project bilgisini bul getir.
            working.setDate(resultSet.getDate("date"));
            working.setCount(resultSet.getInt("count"));
            working.setBonus(resultSet.getDouble("bonus"));
            
            workings.add(working);
            
        }
        
        return workings;
    }
    
    public ArrayList<Working> dateWorkingWiev(int year,int month) throws ClassNotFoundException, SQLException{
        
        ArrayList<Working> workings = new ArrayList<>();
        WorkingProcesses workingProcesses = new WorkingProcesses();
        
        java.sql.Date[] list = new java.sql.Date[2];
        list = workingProcesses.firstAndLastDay(year, month);
        
        connection = DatabaseUtilities.getConnection();
        sql = "select * from working where date=>? and date=<?";
        statement = connection.prepareStatement(sql);
        statement.setDate(1, list[0]);
        statement.setDate(2, list[1]);
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            working = new Working();
            working.setWorkingId(resultSet.getInt("working_id"));
            working.setEmployee(findEmployee(resultSet.getInt("employee_id")));//buraya employe bulup bilgisini getir.
            working.setSubProject(findSubProject(resultSet.getInt("sub_project_id")));//buraya sub project bilgisini bul getir.
            working.setDate(resultSet.getDate("date"));
            working.setCount(resultSet.getInt("count"));
            working.setBonus(resultSet.getDouble("bonus"));
            
            workings.add(working);
            
        }
        
        return workings;
    }
    
    
    public Employee findEmployee(int employeeId) throws ClassNotFoundException, SQLException{
        EmployeeProcesses employeeProcesses = new EmployeeProcesses();
        return employeeProcesses.getEmloyee(employeeId);
    }
    
    public SubProject findSubProject(int subProjectId) throws ClassNotFoundException, SQLException{
        SubProjectProcesses subProjectProcesses = new SubProjectProcesses();
        return subProjectProcesses.findSubProject(subProjectId);
    }
    
    
    
}
