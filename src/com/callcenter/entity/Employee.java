/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.callcenter.entity;

/**
 *
 * @author burakatlay
 */
public class Employee {

    private int employeeId;
    private String employeeName;
    private String employeeSurname;
    private String employeeNickName;
    private String email;
    private String password;
    private String photo;

    public Employee(int employeeId, String employeeName, String employeeSurname, String employeeNickName, String email, String password, String photo) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeSurname = employeeSurname;
        this.employeeNickName = employeeNickName;
        this.email = email;
        this.password = password;
        this.photo = photo;
    }

    public Employee() {
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeeSurname() {
        return employeeSurname;
    }

    public String getEmployeeNickName() {
        return employeeNickName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoto() {
        return photo;
    }

    
}
