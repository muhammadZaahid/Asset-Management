package com.app.asset.model;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "asset")
public class Asset {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "serialNumber")
    private String serialNumber;

    @Column(name = "assetName")
    private String assetName;

    @Column(name = "description")
    private String description;

    @Column(name = "location")
    private String location;

    @Column(name = "inUse")
    private boolean inUse;

    @Column(name = "purchasePrice")
    private Double purchasePrice;

    @Column(name = "purchaseDate")
    private String purchaseDate;

    @Column(name = "warrantyEndDate")
    private String warrantyEndDate;

    @Column(name = "maintenanceNotes")
    private String maintenanceNotes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isInUse() {
        return inUse;
    }

    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getWarrantyEndDate() {
        return warrantyEndDate;
    }

    public void setWarrantyEndDate(String warrantyEndDate) {
        this.warrantyEndDate = warrantyEndDate;
    }

    public String getMaintenanceNotes() {
        return maintenanceNotes;
    }

    public void setMaintenanceNotes(String maintenanceNotes) {
        this.maintenanceNotes = maintenanceNotes;
    }

    @PrePersist
    private void generateId() {
        this.id = UUID.randomUUID().toString();
    }
}
