package com.app.maintenance.controller;

import com.app.asset.model.Asset;
import com.app.maintenance.dto.*;
import com.app.maintenance.model.Maintenance;
import com.app.maintenance.service.MaintenanceService;
import com.app.technician.dto.TechnicianRes;
import com.app.technician.dto.TechnicianUpdateReq;
import com.app.technician.model.Technician;
import com.app.technician.service.TechnicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
    @RequestMapping("/maintenance")
public class MaintenanceController {

    @Autowired
    private final MaintenanceService maintenanceService;
    private final TechnicianService technicianService;


    public MaintenanceController(MaintenanceService maintenanceService, TechnicianService technicianService) {
        this.maintenanceService = maintenanceService;
        this.technicianService = technicianService;
    }

    @PostMapping
    public ResponseEntity<BaseRes> createMaintenance(@RequestBody MaintenanceInsertReq request) {
        BaseRes response = maintenanceService.createMaintenance(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MaintenanceRes>> getAllMaintenances() {
        List<MaintenanceRes> response = maintenanceService.getAllMaintenances();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/history/{assetId}")
    public ResponseEntity<List<MaintenanceRes>> getMaintenanceHistoryForAsset(@PathVariable String assetId){
        List<MaintenanceRes> response = maintenanceService.getMaintenanceHistoryForAsset(assetId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MaintenanceRes> getMaintenanceById(@PathVariable String id) {
        MaintenanceRes response = maintenanceService.getMaintenanceById(id);
        if (response != null) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseRes> updateMaintenance(@PathVariable String id, @RequestBody MaintenanceUpdateReq request) {
        BaseRes response = maintenanceService.updateMaintenance(id, request);
        if (response != null) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseRes> deleteMaintenance(@PathVariable String id) {
        BaseRes response = maintenanceService.deleteMaintenance(id);
        if (response != null) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/technician/{technicianId}")
    public ResponseEntity<List<MaintenanceRes>> getMaintenancesByTechnician(@PathVariable String technicianId) {
        List<MaintenanceRes> response = maintenanceService.getMaintenancesByTechnician(technicianId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/date-range")
    public ResponseEntity<List<MaintenanceRes>>  getMaintenanceRecordsInDateRange(
            @RequestParam("startDate") @DateTimeFormat(pattern = "dd-MM-yyyy") Date startDate,
            @RequestParam("endDate") @DateTimeFormat(pattern = "dd-MM-yyyy") Date endDate) {

        List<MaintenanceRes> response = maintenanceService.getMaintenancesWithinDateRange(startDate, endDate);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("/total-maintenance-cost")
    public ResponseEntity<Double> calculateTotalMaintenanceCostForAsset() {
        Double totalCost = maintenanceService.calculateTotalMaintenanceCostForAsset();
        return ResponseEntity.ok(totalCost);
    }

    @PutMapping("/assign-technician/{maintenanceId}/{technicianId}")
    public ResponseEntity<AssignTechnicianRes> assignTechnicianToMaintenance(@PathVariable String maintenanceId, @PathVariable String technicianId) {

        MaintenanceRes maintenance = maintenanceService.getMaintenanceById(maintenanceId);
        AssignTechnicianRes response = maintenanceService.saveMaintenanceTask(technicianId,maintenance);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}


