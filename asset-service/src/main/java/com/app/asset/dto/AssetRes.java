package com.app.asset.dto;

public class AssetRes {

    private String id;
    private String serialNumber;
    private String assetName;
    private String description;
    private String location;
    private boolean inUse;
    private Double purchasePrice;
    private String purchaseDate;
    private String warrantyEndDate;
    private String maintenanceNotes;

    public AssetRes(String id, String serialNumber, String assetName, String description, String location, boolean inUse, Double purchasePrice, String purchaseDate, String warrantyEndDate, String maintenanceNotes) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.assetName = assetName;
        this.description = description;
        this.location = location;
        this.inUse = inUse;
        this.purchasePrice = purchasePrice;
        this.purchaseDate = purchaseDate;
        this.warrantyEndDate = warrantyEndDate;
        this.maintenanceNotes = maintenanceNotes;
    }

    public AssetRes() {

    }

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

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
}
