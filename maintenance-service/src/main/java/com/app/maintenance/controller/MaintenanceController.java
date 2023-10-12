package com.app.maintenance.controller;

import com.app.asset.model.Asset;
import com.app.maintenance.model.Maintenance;
import com.app.maintenance.service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/maintenance")
public class MaintenanceController {

    private final MaintenanceService maintenanceService;

    @Autowired
    public MaintenanceController(MaintenanceService maintenanceService) {
        this.maintenanceService = maintenanceService;
    }

    @PostMapping
    public ResponseEntity<Maintenance> createMaintenance(@RequestBody Maintenance maintenance) {
        return ResponseEntity.ok(maintenanceService.createMaintenance(maintenance));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Maintenance> getMaintenance(@PathVariable String id) {
        Maintenance maintenance = maintenanceService.getMaintenanceById(id);
        if (maintenance != null) {
            return ResponseEntity.ok(maintenance);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Maintenance>> getAllMaintenances() {
        List<Maintenance> maintenanceList = maintenanceService.getAllMaintenances();
        return ResponseEntity.ok(maintenanceList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Maintenance> updateMaintenance(@PathVariable String id, @RequestBody Maintenance updatedMaintenance) {
        Maintenance updated = maintenanceService.updateMaintenance(id, updatedMaintenance);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMaintenance(@PathVariable String id) {
        ResponseEntity<?> response = maintenanceService.deleteMaintenance(id);
        if (response.getStatusCode() == ResponseEntity.ok().build().getStatusCode()) {
            return ResponseEntity.ok("Maintenance deleted successfully");
        } else {
            return ResponseEntity.status(response.getStatusCode()).body("Maintenance record not found");
        }
    }

    @GetMapping("/technician/{technician}")
    public ResponseEntity<List<Maintenance>> getMaintenancesByTechnician(@PathVariable String technician) {
        List<Maintenance> maintenanceList = maintenanceService.getMaintenancesByTechnician(technician);
        return ResponseEntity.ok(maintenanceList);
    }

    @GetMapping("/date-range")
    public ResponseEntity<List<Maintenance>> getMaintenancesWithinDateRange(
            @RequestParam Date startDate,
            @RequestParam Date endDate) {
        List<Maintenance> maintenanceList = maintenanceService.getMaintenancesWithinDateRange(startDate, endDate);
        return ResponseEntity.ok(maintenanceList);
    }

    @GetMapping("/asset-date-range")
    public ResponseEntity<List<Maintenance>> getMaintenancesByAssetAndDateRange(
            @RequestParam Asset asset,
            @RequestParam Date startDate,
            @RequestParam Date endDate) {
        List<Maintenance> maintenanceList = maintenanceService.getMaintenancesByAssetAndDateRange(asset, startDate, endDate);
        return ResponseEntity.ok(maintenanceList);
    }

    @GetMapping("/asset-cost-range")
    public ResponseEntity<List<Maintenance>> getMaintenancesByAssetAndCostRange(
            @RequestParam Asset asset,
            @RequestParam Double minCost,
            @RequestParam Double maxCost) {
        List<Maintenance> maintenanceList = maintenanceService.getMaintenancesByAssetAndCostRange(asset, minCost, maxCost);
        return ResponseEntity.ok(maintenanceList);
    }

    @GetMapping("/total-cost-for-asset")
    public ResponseEntity<Double> calculateTotalMaintenanceCostForAsset(@RequestParam Asset asset) {
        Double totalCost = maintenanceService.calculateTotalMaintenanceCostForAsset(asset);
        return ResponseEntity.ok(totalCost);
    }

    @GetMapping("/description/{keyword}")
    public ResponseEntity<List<Maintenance>> getMaintenancesByDescriptionContaining(@PathVariable String keyword) {
        List<Maintenance> maintenanceList = maintenanceService.getMaintenancesByDescriptionContaining(keyword);
        return ResponseEntity.ok(maintenanceList);
    }
}


