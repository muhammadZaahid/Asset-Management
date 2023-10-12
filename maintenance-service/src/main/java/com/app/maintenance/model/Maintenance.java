package com.app.maintenance.model;

import com.app.asset.model.Asset;
import jakarta.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "maintenance_records")
public class Maintenance {

    @Id
    @Column(name = "id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "asset_id")
    private Asset asset;

    @Column(name = "maintenance_date")
    private Date maintenanceDate;

    @Column(name = "cost")
    private Double cost;

    @Column(name = "description")
    private String description;

    @Column(name = "technician")
    private String technician;

    public Maintenance() {
        // Default constructor
    }

    // Getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
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

    public String getTechnician() {
        return technician;
    }

    public void setTechnician(String technician) {
        this.technician = technician;
    }

    @PrePersist
    private void generateId() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
    }
}

