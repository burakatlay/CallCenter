/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.callcenter.database;

import com.callcenter.entity.Project;
import com.callcenter.entity.SubProject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author burakatlay
 */
public class SubProjectProcesses {
    
    private Connection connection;
    private String sql;
    private PreparedStatement statement;
    private ResultSet resultSet;
    private int affected;
    private SubProject subProject = new SubProject(0, "");
    
    public ArrayList<SubProject> getSubProjectList(Project project) throws ClassNotFoundException, SQLException {
        ArrayList<SubProject> list = new ArrayList<>();
        connection = DatabaseUtilities.getConnection();
        sql = "select * from sub_project where project_id=? order by sub_project_id ASC";
        statement = connection.prepareStatement(sql);
        statement.setLong(1, project.getProjectId());

        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int subProjectId = resultSet.getInt("sub_project_id");
            String subProjectName = resultSet.getString("sub_project_name");
            double price = resultSet.getDouble("sub_project_price");
            String callType = resultSet.getString("sub_project_call_type");
            SubProject subProject = new SubProject(subProjectId, subProjectName, price, callType, project.getProjectId(), project.getProjectName());
            list.add(subProject);
        }
        connection.close();
        return list;
    }
    
    public boolean subProjectInsert(SubProject subProject) throws ClassNotFoundException, SQLException {
        connection = DatabaseUtilities.getConnection();
        sql = "insert into sub_project(project_id,sub_project_name,sub_project_price,sub_project_call_type) values(?,?,?,?)";
        statement = connection.prepareStatement(sql);
        statement.setLong(1, subProject.getProjectId());
        statement.setString(2, subProject.getSubProjectName());
        statement.setDouble(3, subProject.getPrice());
        statement.setString(4, subProject.getCallType());
        affected = statement.executeUpdate();
        connection.close();

        return affected == 1 ? true : false;
    }
    
    public boolean subProjectUpdate(SubProject subProject) throws ClassNotFoundException, SQLException{
        
        System.out.println(subProject.getSubProjectId() + " ilk- " + subProject.getSubProjectName());
        connection = DatabaseUtilities.getConnection();
        sql = "update sub_project set sub_project_name=?, sub_project_price=?, sub_project_call_type =? where sub_project_id=?";
        statement = connection.prepareStatement(sql);
        statement.setString(1, subProject.getSubProjectName());
        statement.setDouble(2, subProject.getPrice());
        statement.setString(3, subProject.getCallType());
        statement.setLong(4, subProject.getSubProjectId());
        affected = statement.executeUpdate();
        connection.close();
        System.out.println(subProject.getSubProjectId() + " ikinci- " + subProject.getSubProjectName());

        
        return affected == 1 ? true : false;
    }
    
    public boolean subProjectDelete(SubProject subProject) throws ClassNotFoundException, SQLException{
        connection = DatabaseUtilities.getConnection();
        sql = "delete from sub_project where sub_project_id=?";
        statement = connection.prepareStatement(sql);
        statement.setLong(1, subProject.getSubProjectId());
        affected = statement.executeUpdate();
        connection.close();
        
        return affected == 1 ? true : false;
    }
    
    public ArrayList<SubProject> projectView() throws ClassNotFoundException, SQLException{
        ArrayList<SubProject> list = new ArrayList<>();
        ProjectProcesses projectProcesses = new ProjectProcesses();
        
        connection = DatabaseUtilities.getConnection();
        sql = "select * from sub_project order by sub_project_id ASC";
        statement = connection.prepareStatement(sql);
        
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int projectId = resultSet.getInt("project_id");
            Project project = projectProcesses.findProject(projectId);
            String projectName = project.getProjectName();
            int subProjectId = resultSet.getInt("sub_project_id");
            String subProjectName = resultSet.getString("sub_project_name");
            double price = resultSet.getDouble("sub_project_price");
            String callType = resultSet.getString("sub_project_call_type");
            SubProject subProject = new SubProject(subProjectId, subProjectName, price, callType, projectId,projectName);

            list.add(subProject);
        }
        connection.close();
        return list;
    }
    
    public SubProject findSubProject(int subProjectId) throws ClassNotFoundException, SQLException{
        ProjectProcesses projectProcesses = new ProjectProcesses();
        connection = DatabaseUtilities.getConnection();
        sql = "select * from sub_project where sub_project_id=?";
        statement = connection.prepareStatement(sql);
        statement.setInt(1, subProjectId);
        
        resultSet = statement.executeQuery();
        if (resultSet.next()) {
            subProject.setSubProjectId(resultSet.getInt("sub_project_id"));
            subProject.setSubProjectName(resultSet.getString("sub_project_name"));
            subProject.setProjectId(resultSet.getInt("project_id"));
            subProject.setProjectName(projectProcesses.findProject(resultSet.getInt("project_id")).getProjectName());//project name lazım
            subProject.setPrice(resultSet.getDouble("sub_project_price"));
            subProject.setCallType(resultSet.getString("sub_project_call_type"));
        }
        return subProject;
    }
    
}
