package com.app.maintenance.service.impl;

import com.app.asset.dto.AssetRes;
import com.app.asset.model.Asset;
import com.app.asset.repository.AssetRepository;
import com.app.asset.service.AssetService;
import com.app.maintenance.dto.*;
import com.app.maintenance.model.Maintenance;
import com.app.maintenance.repository.MaintenanceRepository;
import com.app.maintenance.service.MaintenanceService;
import com.app.technician.dto.TechnicianRes;
import com.app.technician.model.Technician;
import com.app.technician.repository.TechnicianRepository;
import com.app.technician.service.TechnicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {

    private final MaintenanceRepository maintenanceRepository;
    private final AssetRepository assetRepository;
    private final TechnicianRepository technicianRepository;
    private final AssetService assetService;
    private final TechnicianService technicianService;

    @Autowired
    public MaintenanceServiceImpl(MaintenanceRepository maintenanceRepository, AssetRepository assetRepository, TechnicianRepository technicianRepository, AssetService assetService, TechnicianService technicianService) {
        this.maintenanceRepository = maintenanceRepository;
        this.assetRepository = assetRepository;
        this.technicianRepository = technicianRepository;
        this.assetService = assetService;
        this.technicianService = technicianService;
    }

    @Override
    public BaseRes createMaintenance(MaintenanceInsertReq request) {

        Maintenance maintenance = new Maintenance();
        Asset asset = assetRepository.findAssetById(request.getAssetId());
        Technician technician = technicianRepository.findTechnicianById(request.getTechnicianId());

        maintenance.setAsset(asset);
        maintenance.setMaintenanceDate(request.getMaintenanceDate());
        maintenance.setCost(request.getCost());
        maintenance.setDescription(request.getDescription());
        maintenance.setTechnician(technician);

        maintenance = maintenanceRepository.save(maintenance);
        BaseRes response = new BaseRes();
        response.setId(maintenance.getId());
        response.setMessage("Maintenance created successfully");;

        return response;
    }
    @Override
    public List<MaintenanceRes> getAllMaintenances() {

        return maintenanceRepository.findAll().stream()
                .map(this::mapMaintenanceToMaintenanceRes).collect(Collectors.toList());
    }

    public List<MaintenanceRes> getMaintenanceHistoryForAsset(String assetId) {
        return maintenanceRepository.findByAssetId(assetId).stream()
                .map(this::mapMaintenanceToMaintenanceRes).collect(Collectors.toList());
    }

    @Override
    public MaintenanceRes getMaintenanceById(String id) {

        Maintenance maintenance = maintenanceRepository.findMaintenanceById(id);
        return mapMaintenanceToMaintenanceRes(maintenance);
    }
    
    public BaseRes updateMaintenance(String id, MaintenanceUpdateReq request) {
        
        Maintenance maintenance = maintenanceRepository.findMaintenanceById(id);
        Asset asset = assetRepository.findAssetById(request.getAssetId());
        Technician technician = technicianRepository.findTechnicianById(request.getTechnicianId());

        if (maintenance != null) {
            maintenance.setId(request.getId());
            maintenance.setAsset(asset);
            maintenance.setMaintenanceDate(request.getMaintenanceDate());
            maintenance.setCost(request.getCost());
            maintenance.setDescription(request.getDescription());
            maintenance.setTechnician(technician);
            maintenanceRepository.save(maintenance);

            BaseRes response = new BaseRes();
            response.setId(maintenance.getId());
            response.setMessage("Maintenance record updated successfully");
            return response;
        } else {
            BaseRes response = new BaseRes();
            response.setMessage("Maintenance not found");
            return response;
        }
    }

    @Override
    public BaseRes deleteMaintenance(String id) {
        Maintenance maintenance = maintenanceRepository.findMaintenanceById(id);
        BaseRes response = new BaseRes();

        if (maintenance !=null) {
            maintenanceRepository.deleteById(id);
            response.setId(id);
            response.setMessage("Maintenance deleted successfully");
        } else {
            response.setId(id);
            response.setMessage("Maintenance not found");
        }

        return response;
    }

    @Override
    public List<MaintenanceRes> getMaintenancesByTechnician(String technicianId) {
        return maintenanceRepository.findByTechnicianId(technicianId).stream()
                .map(this::mapMaintenanceToMaintenanceRes).collect(Collectors.toList());
    }
    @Override
    public List<MaintenanceRes> getMaintenancesWithinDateRange(Date startDate, Date endDate) {
        return maintenanceRepository.findMaintenanceByDateRange(startDate, endDate).stream()
                .map(this::mapMaintenanceToMaintenanceRes).collect(Collectors.toList());
    }

    public Double calculateTotalMaintenanceCostForAsset() {
        List<Maintenance> maintenances = maintenanceRepository.findAll();
        return maintenances.stream()
                .mapToDouble(Maintenance::getCost)
                .sum();
    }

    @Override
    public AssignTechnicianRes saveMaintenanceTask(String technicianId ,MaintenanceRes maintenanceTask) {

        Maintenance maintenance = maintenanceRepository.findMaintenanceById(maintenanceTask.getId());
        Asset asset = assetRepository.findAssetById(maintenanceTask.getAsset().getId());
        Technician technician = technicianRepository.findTechnicianById(technicianId);

        if (maintenance != null) {
        maintenance.setId(maintenanceTask.getId());
        maintenance.setAsset(asset);
        maintenance.setMaintenanceDate(maintenanceTask.getMaintenanceDate());
        maintenance.setCost(maintenanceTask.getCost());
        maintenance.setDescription(maintenanceTask.getDescription());
        maintenance.setTechnician(technician);
        maintenanceRepository.save(maintenance);

        AssignTechnicianRes response = new AssignTechnicianRes();
        response.setMaintenanceId(maintenanceTask.getId());
        response.setTechnicianId(technician.getId());
        response.setMessage("successfully assigned " +
                technician.getName() +
                " to carry out maintenance on "  +
                maintenanceTask.getAsset().getAssetName() + " assets");

        return response;
        }else {
            AssignTechnicianRes response = new AssignTechnicianRes();
            response.setMaintenanceId(maintenanceTask.getId());
            response.setTechnicianId(maintenanceTask.getTechnician().getId());
            response.setMessage("Technician Not found");
            return response;
        }
    }
    private MaintenanceRes mapMaintenanceToMaintenanceRes(Maintenance maintenance) {
        MaintenanceRes data = new MaintenanceRes();
        if (maintenance != null) {
            data.setId(maintenance.getId());
            data.setAsset(mapAssetToAssetRes(maintenance.getAsset()));
            data.setMaintenanceDate(maintenance.getMaintenanceDate());
            data.setCost(maintenance.getCost());
            data.setDescription(maintenance.getDescription());
            data.setTechnician(mapTechnicianToTechnicianRes(maintenance.getTechnician()));
        }
        return data;
    }

    private AssetRes mapAssetToAssetRes(Asset asset) {
        if (asset != null) {
            try {
                return assetService.getAssetById(asset.getId());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return new AssetRes();
    }

    private TechnicianRes mapTechnicianToTechnicianRes(Technician technician) {
        if (technician != null) {
            try {
                return technicianService.getTechnicianById(technician.getId());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return new TechnicianRes();
    }
}
