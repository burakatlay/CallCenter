/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.callcenter.entity;

import java.util.Date;

/**
 *
 * @author burakatlay
 * while (alive) {
 *           Object.eat();
 *           Object.code();
 *           Object.sleep();
 *           Object.repeat();
 *       }
 */
public class SubProject extends Project{
    
    private int subProjectId;
    private String subProjectName;
    private double price;
    private String callType;
    private Date date;
    private int count;
    private double bonus;

    public SubProject(int projectId, String projectName) {
        super(projectId, projectName);
    }
    
    

    public SubProject(int subProjectId, String subProjectName, double price, String callType, int projectId, String projectName) {
        super(projectId, projectName);
        this.subProjectId = subProjectId;
        this.subProjectName = subProjectName;
        this.price = price;
        this.callType = callType;
    }
    
    

    public SubProject(int subProjectId, String subProjectName, double price, String callType, Date date, int count, double bonus, int projectId, String projectName) {
        this(subProjectId, subProjectName, price, callType, projectId, projectName);
        this.date = date;
        this.count = count;
        this.bonus = bonus;
        
    }

    public int getSubProjectId() {
        return subProjectId;
    }

    public void setSubProjectId(int subProjectId) {
        this.subProjectId = subProjectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }
    
    public String getSubProjectName() {
        return subProjectName;
    }

    public double getPrice() {
        return price;
    }

    public Date getDate() {
        return date;
    }

    public int getCount() {
        return count;
    }

    public double getBonus() {
        return bonus;
    }

    public int getProjectId() {
        return projectId;
    }

    public String getProjectName() {
        return projectName;
    }
    
    public String getCallType(){
        return callType;
    }

    public void setSubProjectName(String subProjectName) {
        this.subProjectName = subProjectName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCallType(String callType) {
        this.callType = callType;
    }
    

    public void setDate(Date date) {
        this.date = date;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    
    
    
}
