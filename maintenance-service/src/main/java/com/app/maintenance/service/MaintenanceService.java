package com.app.maintenance.service;

import com.app.asset.dto.AssetRes;
import com.app.asset.model.Asset;
import com.app.maintenance.dto.*;
import com.app.maintenance.model.Maintenance;
import com.app.maintenance.repository.MaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;


public interface MaintenanceService {

    BaseRes createMaintenance(MaintenanceInsertReq request);
    List<MaintenanceRes> getAllMaintenances();
    List<MaintenanceRes> getMaintenanceHistoryForAsset(String assetId);
    MaintenanceRes getMaintenanceById(String id);
    BaseRes updateMaintenance(String id, MaintenanceUpdateReq request);
    BaseRes deleteMaintenance(String id);
    List<MaintenanceRes> getMaintenancesByTechnician(String technicianId);
    List<MaintenanceRes> getMaintenancesWithinDateRange(Date startDate, Date endDate);
    Double calculateTotalMaintenanceCostForAsset();
    AssignTechnicianRes saveMaintenanceTask(String technicianId, MaintenanceRes maintenanceTask);
}

