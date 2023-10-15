package com.app.technician.service.impl;

import com.app.technician.dto.BaseRes;
import com.app.technician.dto.TechnicianInsertReq;
import com.app.technician.dto.TechnicianRes;
import com.app.technician.dto.TechnicianUpdateReq;
import com.app.technician.model.Technician;
import com.app.technician.repository.TechnicianRepository;
import com.app.technician.service.TechnicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TechnicianServiceImpl implements TechnicianService {

    private final TechnicianRepository technicianRepository;

    @Autowired
    public TechnicianServiceImpl(TechnicianRepository technicianRepository) {
        this.technicianRepository = technicianRepository;
    }

    @Override
    public BaseRes createTechnician(TechnicianInsertReq request) {
        Technician technician = new Technician();
        technician.setName(request.getName());
        technician.setPhoneNumber(request.getPhoneNumber());
        technician.setEmail(request.getEmail());

        technician = technicianRepository.save(technician);

        BaseRes response = new BaseRes();
        response.setId(technician.getId());
        response.setMessage("Technician created successfully");

        return response;
    }

    @Override
    public List<TechnicianRes> getAllTechnicians() {
        return technicianRepository.findAll().stream()
                .map(technician -> {
                    TechnicianRes data = new TechnicianRes();
                    data.setId(technician.getId());
                    data.setName(technician.getName());
                    data.setPhoneNumber(technician.getPhoneNumber());
                    data.setEmail(technician.getEmail());
                    return data;
                })
                .collect(Collectors.toList());
    }

    @Override
    public TechnicianRes getTechnicianById(String id) {

        Technician technician = technicianRepository.findTechnicianById(id);

        if (technician != null) {
            TechnicianRes data = new TechnicianRes();
            data.setId(technician.getId());
            data.setName(technician.getName());
            data.setPhoneNumber(technician.getPhoneNumber());
            data.setEmail(technician.getEmail());
            return data;
        }
        return null;
    }

    @Override
    public BaseRes updateTechnician(String id, TechnicianUpdateReq request) {

        Technician technician = technicianRepository.findTechnicianById(id);

        if (technician !=null) {
            technician.setName(request.getName());
            technician.setPhoneNumber(request.getPhoneNumber());
            technician.setEmail(request.getEmail());
            technicianRepository.save(technician);

            BaseRes response = new BaseRes();
            response.setId(technician.getId());
            response.setMessage("Technician updated successfully");
            return response;
        } else {
            BaseRes response = new BaseRes();
            response.setMessage("Technician not found");
            return response;
        }
    }

    @Override
    public BaseRes deleteTechnician(String id) {
        Technician technician = technicianRepository.findTechnicianById(id);
        BaseRes response = new BaseRes();

        if (technician !=null) {
            technicianRepository.deleteById(id);
            response.setId(id);
            response.setMessage("Technician deleted successfully");
        } else {
            response.setId(id);
            response.setMessage("Technician not found");
        }

        return response;
    }
}
