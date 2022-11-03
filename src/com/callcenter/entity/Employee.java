package com.callcenter.entity;

/**
 *
 * @author burakatlay
 */
public class Employee {
    
    int employeeId;
    String employeeName;
    String employeeSurname;
    String employeePhoto;
    String employeePassword;
    String employeeEmail;
    String employeeNickName;
    
    public Employee(){
        
    }

    public Employee(int employeeId, String employeeName, String employeeSurname, String employeePassword, String employeeEmail, String employeeNickName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeSurname = employeeSurname;
        this.employeePassword = employeePassword;
        this.employeeEmail = employeeEmail;
        this.employeeNickName = employeeNickName;
    }

    public Employee(int employeeId, String employeeName, String employeeSurname, String employeePhoto, String employeePassword, String employeeEmail, String employeeNickName) {
        this(employeeId, employeeName, employeeSurname, employeePassword, employeeEmail, employeeNickName);
        this.employeePhoto = employeePhoto;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeSurname() {
        return employeeSurname;
    }

    public void setEmployeeSurname(String employeeSurname) {
        this.employeeSurname = employeeSurname;
    }

    public String getEmployeePhoto() {
        return employeePhoto;
    }

    public void setEmployeePhoto(String employeePhoto) {
        this.employeePhoto = employeePhoto;
    }

    public String getEmployeePassword() {
        return employeePassword;
    }

    public void setEmployeePassword(String employeePassword) {
        this.employeePassword = employeePassword;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeNickName() {
        return employeeNickName;
    }

    public void setEmployeeNickName(String employeeNickName) {
        this.employeeNickName = employeeNickName;
    }

    
    
    
}
