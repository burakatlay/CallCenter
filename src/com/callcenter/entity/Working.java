/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.callcenter.entity;

import java.util.Date;
/**
 *
 * @author burakatlay
 */
public class Working {
    
    private int workingId;
    private ProjectProperty propertyId;
    private int callCount;
    private Date date = new Date();

    public Working() {
    }

    public Working(ProjectProperty propertyId, int callCount, Date date) {
        this.propertyId = propertyId;
        this.callCount = callCount;
        this.date = date;
    }

    public Working(int workingId, ProjectProperty propertyId, int callCount, Date date) {
        this(propertyId, callCount, date);
        this.workingId = workingId;
    }

    public int getWorkingId() {
        return workingId;
    }

    public void setWorkingId(int workingId) {
        this.workingId = workingId;
    }

    public ProjectProperty getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(ProjectProperty propertyId) {
        this.propertyId = propertyId;
    }

    public int getCallCount() {
        return callCount;
    }

    public void setCallCount(int callCount) {
        this.callCount = callCount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
    
}
