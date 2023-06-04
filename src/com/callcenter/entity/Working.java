/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.callcenter.entity;

import java.sql.Date;

/**
 *
 * @author burakatlay
 */
public class Working {
    
    private int workingId;
    private Employee employee;
    private SubProject subProject;
    private Date date;
    private int count;
    private double bonus;

    public Working() {
    }

    public Working(int workingId, Employee employee, SubProject subProject, Date date, int count, double bonus) {
        this.workingId = workingId;
        this.employee = employee;
        this.subProject = subProject;
        this.date = date;
        this.count = count;
        this.bonus = bonus;
    }

    public int getWorkingId() {
        return workingId;
    }

    public void setWorkingId(int workingId) {
        this.workingId = workingId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public SubProject getSubProject() {
        return subProject;
    }

    public void setSubProject(SubProject subProject) {
        this.subProject = subProject;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
    
    
    
}
