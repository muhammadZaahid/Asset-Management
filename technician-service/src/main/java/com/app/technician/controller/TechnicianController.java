package com.app.technician.controller;

import com.app.technician.model.Technician;
import com.app.technician.service.TechnicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/technician")
public class TechnicianController {

    @Autowired
    private final TechnicianService technicianService;

    public TechnicianController(TechnicianService technicianService) {
        this.technicianService = technicianService;
    }

    @PostMapping
    public ResponseEntity<Technician> createTechnician(@RequestBody Technician technician) {
        Technician createdTechnician = technicianService.createTechnician(technician);
        return new ResponseEntity<>(createdTechnician, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Technician>> getAllTechnicians() {
        List<Technician> technicians = technicianService.getAllTechnicians();
        return new ResponseEntity<>(technicians, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Technician> getTechnicianById(@PathVariable String id) {
        Technician technician = technicianService.getTechnicianById(id);
        if (technician != null) {
            return new ResponseEntity<>(technician, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Technician> updateTechnician(@PathVariable String id, @RequestBody Technician updatedTechnician) {
        Technician updated = technicianService.updateTechnician(id, updatedTechnician);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTechnician(@PathVariable String  id) {
        boolean deleted = technicianService.deleteTechnician(id);
        if (deleted) {
            return new ResponseEntity<>("Technician deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Technician not found", HttpStatus.NOT_FOUND);
        }
    }

}
