/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.callcenter.database;

import com.callcenter.entity.Project;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author burakatlay
 */
public class ProjectProcesses {

    private Connection connection;
    private String sql;
    private PreparedStatement statement;
    private ResultSet resultSet;
    private int affected;

    public ArrayList<Project> getProjectList() throws ClassNotFoundException, SQLException {
        ArrayList<Project> list = new ArrayList<>();
        connection = DatabaseUtilities.getConnection();
        sql = "select * from project order by project_id ASC";
        statement = connection.prepareStatement(sql);

        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int projectId = resultSet.getInt("project_id");
            String projectName = resultSet.getString("project_name");
            Project project = new Project(projectId, projectName);
            list.add(project);
        }
        connection.close();
        return list;
    }

    public boolean projectInsert(String projectName) throws ClassNotFoundException, SQLException {
        connection = DatabaseUtilities.getConnection();
        sql = "insert into project(project_name) values(?)";
        statement = connection.prepareStatement(sql);
        statement.setString(1, projectName);
        affected = statement.executeUpdate();
        connection.close();

        return affected == 1 ? true : false;
    }

    public boolean projectDelete(int projectID) throws ClassNotFoundException, SQLException {

        connection = DatabaseUtilities.getConnection();
        sql = "delete from project where project_id=?";
        statement = connection.prepareStatement(sql);
        statement.setLong(1, projectID);
        affected = statement.executeUpdate();
        connection.close();

        return affected == 1 ? true : false;
    }

    public boolean projectUpdate(Project project) throws ClassNotFoundException, SQLException {
        
        connection = DatabaseUtilities.getConnection();
        sql = "update project set project_name=? where project_id=?";
        statement = connection.prepareStatement(sql);
        statement.setString(1, project.getProjectName());
        statement.setLong(2, project.getProjectId());
        affected = statement.executeUpdate();

        return affected == 1 ? true : false;
    }
    
    public Project firstProject() throws ClassNotFoundException, SQLException{
        Project project =null;
        connection = DatabaseUtilities.getConnection();
        sql = "select * from project";
        statement = connection.prepareStatement(sql);

        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int projectId = resultSet.getInt("project_Id");
            String projectName = resultSet.getString("project_name");
            project = new Project(projectId, projectName);
            return project;
        }
        connection.close();
        return project;
    }
    
    public Project findProject(int projectId) throws ClassNotFoundException, SQLException{
        
        Project project = null;
        connection = DatabaseUtilities.getConnection();
        sql = "select * from project where project_id=?";
        statement = connection.prepareStatement(sql);
        statement.setInt(1, projectId);

        resultSet = statement.executeQuery();
        
        if (resultSet.next()) {
            projectId = resultSet.getInt("project_id");
            String projectName = resultSet.getString("project_name");
            project = new Project(projectId, projectName);
            
        }
        connection.close();
        return project;
    }
}
