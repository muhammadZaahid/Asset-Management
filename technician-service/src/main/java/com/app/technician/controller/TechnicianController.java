package com.app.technician.controller;

import com.app.technician.dto.BaseRes;
import com.app.technician.dto.TechnicianInsertReq;
import com.app.technician.dto.TechnicianRes;
import com.app.technician.dto.TechnicianUpdateReq;
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
    public ResponseEntity<BaseRes> createTechnician(@RequestBody TechnicianInsertReq request) {
        BaseRes response = technicianService.createTechnician(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TechnicianRes>> getAllTechnicians() {
        List<TechnicianRes> technicians = technicianService.getAllTechnicians();
        return new ResponseEntity<>(technicians, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TechnicianRes> getTechnicianById(@PathVariable String id) {
        TechnicianRes technician = technicianService.getTechnicianById(id);
        if (technician != null) {
            return new ResponseEntity<>(technician, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseRes> updateTechnician(@PathVariable String id, @RequestBody TechnicianUpdateReq request) {
        BaseRes response = technicianService.updateTechnician(id, request);
        if (response != null) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseRes> deleteTechnician(@PathVariable String id) {
        BaseRes response = technicianService.deleteTechnician(id);
        if (response != null) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
