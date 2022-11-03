package com.callcenter.entity;

/**
 *
 * @author burakatlay
 */
public class Project {
    int projectId;
    String projectName;
    Employee employeeId;

    public Project() {
    }

    public Project(int projectId, String projectName, Employee employeeId) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.employeeId = employeeId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }
    
    
    
}
