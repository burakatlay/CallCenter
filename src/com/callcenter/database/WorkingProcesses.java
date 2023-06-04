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
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author burakatlay
 */
public class WorkingProcesses {
    
    private Working working = null;
    private Employee employee;
    private SubProject subProject = new SubProject(0, "");
    private int affected = 0;
    private int count = 0;
    private Connection connection;
    private PreparedStatement statement;
    private String sql;
    private ResultSet resultSet;
    private double bonus = 0.0;

    public double getBonus() {
        return bonus;
    }
    
    
    long millis = System.currentTimeMillis();  
    java.sql.Date date = new java.sql.Date(millis);
    
    public int insert(SubProject subProject) throws ClassNotFoundException, SQLException{
        this.subProject = subProject;
        connection = DatabaseUtilities.getConnection();
       
        System.out.println(date);
        
        sql = "insert into working(employee_id,sub_project_id,date,count,bonus) values(?,?,?,?,?)";
        statement = connection.prepareStatement(sql);
        statement.setLong(1, 3);
        statement.setLong(2, subProject.getSubProjectId());
        statement.setDate(3, date);
        statement.setInt(4, 1);
        statement.setDouble(5, bonus);
        affected = statement.executeUpdate();
        connection.close();
        
        return affected;
    }
    
    public ArrayList<Working> workingWiev() throws ClassNotFoundException, SQLException{
        
        ArrayList<Working> workings = new ArrayList<>();
        
        connection = DatabaseUtilities.getConnection();
        sql = "select * from working where date=?";
        statement = connection.prepareStatement(sql);
        statement.setDate(1, date);
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
    
     public boolean findWorking(Employee employee,SubProject subProject) throws ClassNotFoundException, SQLException{
        
        System.out.println(date);
        
        connection = DatabaseUtilities.getConnection();
        sql = "select * from working where employee_id=? and sub_project_id=? and date=?";
        statement = connection.prepareStatement(sql);
        statement.setInt(1, employee.getEmployeeId());
        statement.setInt(2, subProject.getSubProjectId());
        statement.setDate(3, date);

        resultSet = statement.executeQuery();
        
        if (resultSet.next()) {
            System.out.println("kayıt var");
            count = resultSet.getInt("count");
            bonus = resultSet.getDouble("bonus");
            connection.close();
            return true;
            
        }else{
            bonus = 0.0;
            connection.close();
            System.out.println("kayıt yok");
            return false;
        }
        
    }
     
    public int getCount(){
        
        return count;
    }
    
    public boolean callIncrease(Employee employee,SubProject subProject) throws ClassNotFoundException, SQLException{
        this.subProject = subProject;
        this.employee = employee;
        boolean control = findWorking(employee, subProject);
        if (control) {
            count ++;
            connection = DatabaseUtilities.getConnection();
            sql = "update working set count=? where employee_id=? and sub_project_id=? and date=?";
            statement = connection.prepareStatement(sql);
            
            statement.setInt(1, count);
            statement.setLong(2, employee.getEmployeeId());
            statement.setLong(3, subProject.getSubProjectId());
            statement.setDate(4, date);
            affected = statement.executeUpdate();
            connection.close();
            return true;
        }else{
            this.insert(subProject);
            return false;
        }
        
    }
    
    public boolean callDown(Employee employee,SubProject subProject) throws ClassNotFoundException, SQLException{
        this.subProject = subProject;
        this.employee = employee;
        boolean control = findWorking(employee, subProject);
        if (control && count > 0) {
            count --;
            connection = DatabaseUtilities.getConnection();
            sql = "update working set count=? where employee_id=? and sub_project_id=? and date=?";
            statement = connection.prepareStatement(sql);
            
            statement.setInt(1, count);
            statement.setLong(2, employee.getEmployeeId());
            statement.setLong(3, subProject.getSubProjectId());
            statement.setDate(4, date);
            affected = statement.executeUpdate();
            connection.close();
            return true;
        }else{
            System.out.println("Kayıt sayısı 0");
            return false;
        }
        
    }
    
    public void addBonus(double bonus,Employee employee,SubProject subProject) throws ClassNotFoundException, SQLException{
        boolean control = findWorking(employee, subProject);
        if (control) {
            connection = DatabaseUtilities.getConnection();
            sql = "update working set bonus=? where employee_id=? and sub_project_id=? and date=?";
            statement = connection.prepareStatement(sql);
            
            statement.setDouble(1, bonus);
            statement.setLong(2, employee.getEmployeeId());
            statement.setLong(3, subProject.getSubProjectId());
            statement.setDate(4, date);
            affected = statement.executeUpdate();
            connection.close();
        }else{
            this.bonus = bonus;
            insert(subProject);
            this.bonus = 0.0;
        }
    }
    
    public double dailyEarnings() throws ClassNotFoundException, SQLException{
        
        double dailyEarn = 0;
        connection = DatabaseUtilities.getConnection();
        sql = "select * from working where date=?";
        statement = connection.prepareStatement(sql);
        statement.setDate(1, date);
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            working = new Working();           
            working.setWorkingId(resultSet.getInt("working_id"));
            working.setEmployee(findEmployee(resultSet.getInt("employee_id")));//buraya employe bulup bilgisini getir.
            working.setSubProject(findSubProject(resultSet.getInt("sub_project_id")));//buraya sub project bilgisini bul getir.
            working.setDate(resultSet.getDate("date"));
            working.setCount(resultSet.getInt("count"));
            working.setBonus(resultSet.getDouble("bonus"));    
            dailyEarn += resultSet.getDouble("bonus");
            dailyEarn += (working.getSubProject().getPrice() * resultSet.getInt("count"));
        }
        return dailyEarn;
    }
    
    public double monthlyEarnings() throws ClassNotFoundException, SQLException{
        double monthlyEarnings = 0;
        
        ArrayList<java.sql.Date> list = new ArrayList<java.sql.Date>();
        java.sql.Date[] list1 = new java.sql.Date[2];
        
        int year = Integer.valueOf(date.toString().substring(0, 4));
        int month = Integer.valueOf(date.toString().substring(5, 7));
        
        list1 = this.firstAndLastDay(year,month);
        
        java.sql.Date sqlFirstDate = new java.sql.Date(list1[0].getTime());
        java.sql.Date sqlLasDate = new java.sql.Date(list1[1].getTime());
        
        connection = DatabaseUtilities.getConnection();
        sql = "select * from working where date between ? and ?";
        statement = connection.prepareStatement(sql);
        statement.setDate(1, sqlFirstDate);
        statement.setDate(2, sqlLasDate);
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            working = new Working();           
            working.setWorkingId(resultSet.getInt("working_id"));
            working.setEmployee(findEmployee(resultSet.getInt("employee_id")));//buraya employe bulup bilgisini getir.
            working.setSubProject(findSubProject(resultSet.getInt("sub_project_id")));//buraya sub project bilgisini bul getir.
            working.setDate(resultSet.getDate("date"));
            working.setCount(resultSet.getInt("count"));
            working.setBonus(resultSet.getDouble("bonus"));    
            monthlyEarnings += resultSet.getDouble("bonus");
            monthlyEarnings += (working.getSubProject().getPrice() * resultSet.getInt("count"));
        }
        return monthlyEarnings;
    }
    
    public java.sql.Date[] firstAndLastDay(int year, int month){
        
        java.sql.Date[] list = new java.sql.Date[2];
        
        // Takvim nesnesi oluşturulur ve istenen yıl/ay bilgileri atanır
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month-1);
        
        // Ayın ilk gününe ayarlanır
        cal.set(Calendar.DAY_OF_MONTH, 1);
        Date firstDayOfMonth = cal.getTime();
        
        // Ayın son gününe ayarlanır
        cal.add(Calendar.MONTH, 1);
        cal.add(Calendar.DATE, -1);
        Date lastDayOfMonth = cal.getTime();
        
        list[0] = new java.sql.Date(firstDayOfMonth.getTime());
        list[1] = new java.sql.Date(lastDayOfMonth.getTime());
        
        System.out.println(list[0]);
        System.out.println(list[1]);
        
        return list;
    }
    
}
