package com.callcenter.entity;

/**
 *
 * @author burakatlay
 */
public class ProjectProperty {
    int propertyId;
    Project projectId;
    String propertyName;
    Double propertyPrice;
    boolean perCallOrMunite;

    public ProjectProperty() {
    }

    public ProjectProperty(int propertyId, Project projectId, String propertyName, Double propertyPrice, boolean perCallOrMunite) {
        this.propertyId = propertyId;
        this.projectId = projectId;
        this.propertyName = propertyName;
        this.propertyPrice = propertyPrice;
        this.perCallOrMunite = perCallOrMunite;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public Project getProjectId() {
        return projectId;
    }

    public void setProjectId(Project projectId) {
        this.projectId = projectId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public Double getPropertyPrice() {
        return propertyPrice;
    }

    public void setPropertyPrice(Double propertyPrice) {
        this.propertyPrice = propertyPrice;
    }

    public boolean isPerCallOrMunite() {
        return perCallOrMunite;
    }

    public void setPerCallOrMunite(boolean perCallOrMunite) {
        this.perCallOrMunite = perCallOrMunite;
    }
    
    
}
