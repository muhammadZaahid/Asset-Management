package com.app.maintenance.service;

import com.app.asset.model.Asset;
import com.app.maintenance.model.Maintenance;
import com.app.maintenance.repository.MaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

@Service
public class MaintenanceService {

    private final MaintenanceRepository maintenanceRepository;

    @Autowired
    public MaintenanceService(MaintenanceRepository maintenanceRepository, RestTemplate restTemplate) {
        this.maintenanceRepository = maintenanceRepository;
    }

    public Maintenance createMaintenance(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    public List<Maintenance> getMaintenanceHistoryForAsset(Asset asset) {
        return maintenanceRepository.findByAsset(asset);
    }

    public List<Maintenance> getAllMaintenances() {
        return maintenanceRepository.findAll();
    }

    public Maintenance getMaintenanceById(String id) {
        return maintenanceRepository.findById(id).orElse(null);
    }

    public Maintenance updateMaintenance(String id, Maintenance updatedMaintenance) {
        // Retrieve the existing maintenance record by ID
        Maintenance existingMaintenance = getMaintenanceById(id);

        if (existingMaintenance == null) {
            // The maintenance record doesn't exist
            return null;
        }

        // Update the fields of the existing maintenance record
        existingMaintenance.setDescription(updatedMaintenance.getDescription());
        existingMaintenance.setMaintenanceDate(updatedMaintenance.getMaintenanceDate());
        existingMaintenance.setCost(updatedMaintenance.getCost());
        existingMaintenance.setTechnician(updatedMaintenance.getTechnician());

        // Save the updated maintenance record
        return maintenanceRepository.save(existingMaintenance);
    }

    public ResponseEntity<?> deleteMaintenance(String id) {
        if (maintenanceRepository.existsById(id)) {
            maintenanceRepository.deleteById(id);
            return ResponseEntity.ok("Maintenance record deleted successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Maintenance record not found");
    }

    public List<Maintenance> getMaintenancesByTechnician(String technician) {
        return maintenanceRepository.findByTechnician(technician);
    }

    public List<Maintenance> getMaintenancesWithinDateRange(Date startDate, Date endDate) {
        return maintenanceRepository.findByMaintenanceDateBetween(startDate, endDate);
    }

    public List<Maintenance> getMaintenancesByAssetAndDateRange(Asset asset, Date startDate, Date endDate) {
        return maintenanceRepository.findByAssetAndMaintenanceDateBetween(asset, startDate, endDate);
    }

    public List<Maintenance> getMaintenancesByAssetAndCostRange(Asset asset, Double minCost, Double maxCost) {
        return maintenanceRepository.findByAssetAndCostBetween(asset, minCost, maxCost);
    }

    public Double calculateTotalMaintenanceCostForAsset(Asset asset) {
        List<Maintenance> maintenances = maintenanceRepository.findByAsset(asset);
        return maintenances.stream()
                .mapToDouble(Maintenance::getCost)
                .sum();
    }

    public List<Maintenance> getMaintenancesByDescriptionContaining(String keyword) {
        return maintenanceRepository.findByDescriptionContaining(keyword);
    }
}

