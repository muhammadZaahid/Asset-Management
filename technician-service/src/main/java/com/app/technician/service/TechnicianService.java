package com.app.technician.service;

import com.app.technician.model.Technician;
import com.app.technician.repository.TechnicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnicianService {

    @Autowired
    private final TechnicianRepository technicianRepository;

    public TechnicianService(TechnicianRepository technicianRepository) {
        this.technicianRepository = technicianRepository;
    }

    public Technician createTechnician(Technician technician) {
        return technicianRepository.save(technician);
    }

    public List<Technician> getAllTechnicians() {
        return technicianRepository.findAll();
    }

    public Technician getTechnicianById(String id) {
        return technicianRepository.findById(id).orElse(null);
    }

    public Technician updateTechnician(String id, Technician updatedTechnician) {
        Technician existingTechnician = getTechnicianById(id);

        if (existingTechnician != null) {
            existingTechnician.setName(updatedTechnician.getName());
            existingTechnician.setPhoneNumber(updatedTechnician.getPhoneNumber());
            existingTechnician.setEmail(updatedTechnician.getEmail());

            return technicianRepository.save(existingTechnician);
        }

        return null;
    }

    public boolean deleteTechnician(String id) {
        Technician existingTechnician = getTechnicianById(id);

        if (existingTechnician != null) {
            technicianRepository.delete(existingTechnician);
            return true;
        }

        return false;
    }

}
