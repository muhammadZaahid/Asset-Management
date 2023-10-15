package com.app.maintenance.dto;

import com.app.asset.dto.AssetRes;
import com.app.technician.dto.TechnicianRes;
import com.app.technician.model.Technician;

import java.util.Date;

public class MaintenanceRes {

    private String id;
    private AssetRes asset;
    private Date maintenanceDate;
    private Double cost;
    private String description;
    private TechnicianRes technician;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public AssetRes getAsset() {
        return asset;
    }

    public void setAsset(AssetRes asset) {
        this.asset = asset;
    }

    public Date getMaintenanceDate() {
        return maintenanceDate;
    }

    public void setMaintenanceDate(Date maintenanceDate) {
        this.maintenanceDate = maintenanceDate;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TechnicianRes getTechnician() {
        return technician;
    }

    public void setTechnician(TechnicianRes technician) {
        this.technician = technician;
    }
}
