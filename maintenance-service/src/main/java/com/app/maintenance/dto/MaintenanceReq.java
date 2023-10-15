package com.app.maintenance.dto;

import com.app.technician.model.Technician;

import java.util.Date;

public class MaintenanceReq {

    private String id;
    private String assetId;
    private Date maintenanceDate;
    private Double cost;
    private String description;
    private String technicianId;
}
